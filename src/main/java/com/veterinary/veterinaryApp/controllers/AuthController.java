package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.ClientDTO;
import com.veterinary.veterinaryApp.DTOs.requestBodys.LoginDTO;
import com.veterinary.veterinaryApp.DTOs.requestBodys.RegisterDTO;
import com.veterinary.veterinaryApp.Repositories.AccountRepository;
import com.veterinary.veterinaryApp.Repositories.ClientRepository;
import com.veterinary.veterinaryApp.models.Account;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.serviceSecurity.JwtUtilService;
import com.veterinary.veterinaryApp.serviceSecurity.UserDetailsServiceImplem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import static com.veterinary.veterinaryApp.utils.Utils.fiveDigits;

@RestController
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImplem userDetailsServiceImplem;

    @Autowired
    private JwtUtilService jwtUtilService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountRepository accountRepository;


    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginDTO loginDTO){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.email(),loginDTO.password())); // usa un autenticaction provaider que genera un usedetails usando el userdetails que yo le paso
            final UserDetails userDetails = userDetailsServiceImplem.loadUserByUsername(loginDTO.email()); // carga los detalles de usuario
            final String jwt = jwtUtilService.generateToken(userDetails); //genera el token
            return ResponseEntity.ok(jwt); // respuesta ok y esperamos que nos devuelva el token
        }catch (Exception e){
            return new ResponseEntity<>("Email or password invalid", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/current") //obtener ese usuario logeado
    public ResponseEntity<?> getClient (Authentication authentication){ // ese cliente ya logeado
        Client client = clientRepository.findByEmail(authentication.getName()); // obtener el nombre de ese ususario ya logeado
        return ResponseEntity.ok(new ClientDTO(client));
    }


    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegisterDTO registerDTO){

        if (clientRepository.findByEmail(registerDTO.email()) != null) {
            return new ResponseEntity<>("Email is already registered", HttpStatus.FORBIDDEN);
        }

        if (registerDTO.firstName().isBlank()){
            return new ResponseEntity<>("The firs name  field must not be empty", HttpStatus.FORBIDDEN);
        }
        if (registerDTO.lastName().isBlank()){
            return new ResponseEntity<>("The last name field must not be empty", HttpStatus.FORBIDDEN);
        }
        if (registerDTO.email().isBlank()){
            return new ResponseEntity<>("The email field must not be empty", HttpStatus.FORBIDDEN);
        }
        if (registerDTO.password().isBlank()){
            return new ResponseEntity<>("The password field must not be empty", HttpStatus.FORBIDDEN);
        }

        if (registerDTO.phone() == 0){
            return new ResponseEntity<>("The password field must not be empty", HttpStatus.FORBIDDEN);
        }

        Client client = new Client(
                registerDTO.firstName(),
                registerDTO.lastName(),
                registerDTO.email(),
                passwordEncoder.encode(registerDTO.password()),
                registerDTO.phone());

        String number;
        do {
            number = "N-" + fiveDigits();
        } while (accountRepository.findByNumber(number) != null);

        Account account = new Account(0.0, number);
//        account.setClient(client);
//        client.addAccount(account);
        clientRepository.save(client);
        accountRepository.save(account);

        return new ResponseEntity<>("Client created", HttpStatus.CREATED);
    }




}

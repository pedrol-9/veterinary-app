package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.ClientDTO;
import com.veterinary.veterinaryApp.DTOs.requestBodys.LoginDTO;
import com.veterinary.veterinaryApp.DTOs.requestBodys.RegisterDTO;
import com.veterinary.veterinaryApp.Repositories.AccountRepository;
import com.veterinary.veterinaryApp.Repositories.ClientRepository;
import com.veterinary.veterinaryApp.models.Account;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.serviceSecurity.JwtUtilService;
import com.veterinary.veterinaryApp.serviceSecurity.UserDetailsServiceImp;
import com.veterinary.veterinaryApp.services.AccountService;
import com.veterinary.veterinaryApp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static com.veterinary.veterinaryApp.utils.Utils.fiveDigits;

@RestController
@RequestMapping("/api-veterinary")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;

    @Autowired
    private JwtUtilService jwtUtilService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody LoginDTO loginDTO){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.email(),loginDTO.password()));
            final UserDetails userDetails = userDetailsServiceImp.loadUserByUsername(loginDTO.email());
            final String jwt = jwtUtilService.generateToken(userDetails);
            return ResponseEntity.ok(jwt);
        }catch (Exception e){
            return new ResponseEntity<>("Email or password invalid", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/current")
    public ResponseEntity<?> getCurrentClient (Authentication authentication) {
        Client client = clientService.getClientByEmail(authentication.getName());
        return ResponseEntity.ok(new ClientDTO(client));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody RegisterDTO registerDTO){

        if (clientService.getClientByEmail(registerDTO.email()) != null) {
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
        } while (accountService.getAccountByNumber(number) != null);

        Account account = new Account(0.0, number);
        account.setClient(client);
        client.setAccount(account);
        clientService.saveClient(client);
        accountService.saveAccount(account);

        return new ResponseEntity<>("Client created", HttpStatus.CREATED);
    }
}

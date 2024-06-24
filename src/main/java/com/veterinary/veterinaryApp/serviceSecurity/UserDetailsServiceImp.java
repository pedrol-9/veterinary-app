package com.veterinary.veterinaryApp.serviceSecurity;

import com.veterinary.veterinaryApp.Repositories.ClientRepository;
import com.veterinary.veterinaryApp.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Client client = clientRepository.findByEmail(username);

        if (client == null){
            throw new UsernameNotFoundException(username);
        }

        String rol = "";
        if (client.isAdmin()){
            rol = "ADMIN";
        } else {
            rol = "CLIENT";
        }

        return User
                .withUsername(username) //email
                .password(client.getPassword())
                .roles(rol)
                .build();
    }
}

package com.veterinary.veterinaryApp;

import com.veterinary.veterinaryApp.Repositories.AccountRepository;
import com.veterinary.veterinaryApp.Repositories.ClientRepository;
import com.veterinary.veterinaryApp.models.Account;
import com.veterinary.veterinaryApp.models.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VeterinaryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinaryAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(ClientRepository clientRepository, AccountRepository accountRepository) {
		return (args) -> {

			// creacion de usuarios
			Client useradmin = new Client("Jelena", "Palavecino", "jelena@vetadmin.com", "123", 31334177);
			Client client = new Client("Lucas", "Madrigal", "lucas@mail.com", "123", 51258927);

			// Creación de Account
			clientRepository.save(useradmin);
			clientRepository.save(client);

			// creacion de cuentas
//			Account account1 = new Account(1000);
//			Account account2 = new Account(1000);
//			Account account3 = new Account(1000);

//			accountRepository.save(account1);
//			accountRepository.save(account2);
//			accountRepository.save(account3);
//
//			account1.setUser(client);
//			account2.setUser(client);
//			account3.setUser(useradmin);

			// para saber cuando inicia la app
			System.out.println("****************************************************");
			System.out.println("*                                                  *");
			System.out.println("*        Bienvenido a Mi Aplicación Veterinaria    *");
			System.out.println("*                                                  *");
			System.out.println("****************************************************");

		};
	}
}

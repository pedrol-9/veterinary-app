package com.veterinary.veterinaryApp;

import com.veterinary.veterinaryApp.Repositories.*;
import com.veterinary.veterinaryApp.models.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.veterinary.veterinaryApp.utils.Utils.fiveDigits;

@SpringBootApplication
public class VeterinaryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinaryAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(ClientRepository clientRepository, AccountRepository accountRepository, PetRepository petRepository, VeterinarianRepository veterinarianRepository, OfferingRepository offeringRepository, AppointmentRepository appointmentRepository, InvoiceRepository invoiceRepository) {
		return (args) -> {

			// creacion de usuarios
			Client userAdmin = new Client("Jelena", "Palavecino", "jelena@vetadmin.com", "123", 31334177);
			clientRepository.save(userAdmin);
			Client lucas = new Client("Lucas", "Madrigal", "lucas@mail.com", "123", 51258927);
			clientRepository.save(lucas);
			Client pedro = new Client("Pedro", "Sanabria", "pedro@sanabria.com", "123", 51258927);
			clientRepository.save(pedro);
			Client leonel = new Client("Leonel", "Borjas", "leonel@borjas.com", "123", 51258927);
			clientRepository.save(leonel);

			// creacion de cuentas
			Account account1 = new Account(1000, fiveDigits());
			Account account2 = new Account(1500, fiveDigits());
			Account account3 = new Account(2000, fiveDigits());
			Account account4 = new Account(2500, fiveDigits());

			account1.setClient(userAdmin);
			account2.setClient(lucas);
			account3.setClient(pedro);
			account4.setClient(leonel);

			accountRepository.save(account1);
			accountRepository.save(account2);
			accountRepository.save(account3);
			accountRepository.save(account4);
			
			// Creación de Pets
			Pet pet1 = new Pet("Pulguita", 5, "Perro", "Chihuahua", "healthy dog");
			Pet pet2 = new Pet("Luna", 2, "Gato", "Persa", "healthy cat");
			Pet pet3 = new Pet("Pelusa", 3, "Gato", "Siames", "angry cat, need sedation");
			Pet pet4 = new Pet("Coco", 1, "Perro", "Pastor Aleman", "blind dog");
			Pet pet5 = new Pet("Tomate", 6, "Perro", "Pastor Aleman", "healthy dog");
			Pet pet6 = new Pet("Firulais", 15, "Perro", "Golden Retriever", "very old dog");

			userAdmin.addPet(pet1);
			lucas.addPet(pet2);
			pedro.addPet(pet3);
			leonel.addPet(pet4);
			userAdmin.addPet(pet5);
			userAdmin.addPet(pet6);

			petRepository.save(pet1);
			petRepository.save(pet2);
			petRepository.save(pet3);
			petRepository.save(pet4);
			petRepository.save(pet5);
			petRepository.save(pet6);

			// Creación de Veterinarios
			Veterinarian vet1 = new Veterinarian("Brayan", "Veterinary Dermatology", "Calle 1 # 2 - 3", 31334177);
			veterinarianRepository.save(vet1);
			Veterinarian vet2 = new Veterinarian("Brayan", "Animal Behavior", "Calle 4 # 5 - 6", 31334177);
			veterinarianRepository.save(vet2);
			Veterinarian vet3 = new Veterinarian("Brayan", "Veterinary Anesthesiology and Emergency Medicine", "Calle 7 # 8 - 9", 31334177);
			veterinarianRepository.save(vet3);
			Veterinarian vet4 = new Veterinarian("Brayan", "Intern", "Calle 10 # 11 - 12", 31334177);
			veterinarianRepository.save(vet4);

			// creación de Servicios
			Offering dogShower = new Offering("Dog Shower", "Experience our comprehensive Dog Shower Service, tailored to pamper dogs of all sizes.", AnimalSize.NONE, 1000, new ArrayList<>(List.of("LUNES", "MIERCOLES", "VIERNES")), new ArrayList<>(List.of("8:00 AM", "10:00 AM")));

			Offering dogWalk = new Offering("Dog Walk", "Enjoy peace of mind with our professional Dog Walk Service, designed to keep your furry friend happy and active.", AnimalSize.NONE, 500, new ArrayList<>(List.of("LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES", "SABADO")), new ArrayList<>(List.of("7:00 AM", "7:00 PM")));

			// creación de Appointment
			Appointment appointment1 = new Appointment(LocalDateTime.now().plusDays(3), LocalDateTime.now(), "Please get my dog a good shower, I´ll pick him up at noon", AppointmentStatus.CONFIRMED);
			appointmentRepository.save(appointment1);

			// Creación de Invoice
			Invoice invoice1 = new Invoice(LocalDateTime.now(), 1000, InvoiceStatus.PENDING);

			// Asignar cita al cliente
			lucas.addAppointment(appointment1);

			// asignar cuenta a la invoice
			invoice1.setAccount(account4);

			// Asignar pet a la cita
			pet1.addAppointment(appointment1);

			// Asignar cita al veterinario
			vet2.addAppointment(appointment1);

			// Asignar servicio a la cita
			appointment1.setOffering(dogShower);

			// Asignar invoice a la cita
			appointment1.setInvoice(invoice1);

			// Asignar invoice a la cuenta y setear status según el balance de la cuenta y el estado de la cita
			// invoice1.setStatus(appointment1);

			// Persistir objetos


	/*		veterinarianRepository.save(vet1);
			veterinarianRepository.save(vet2);
			veterinarianRepository.save(vet3);
			veterinarianRepository.save(vet4);*/

			offeringRepository.save(dogShower);
			offeringRepository.save(dogWalk);
			invoiceRepository.save(invoice1);


			// para saber cuando inicia la app
			System.out.println("****************************************************");
			System.out.println("*                                                  *");
			System.out.println("*        Bienvenido a Mi Aplicación Veterinaria    *");
			System.out.println("*                                                  *");
			System.out.println("****************************************************");

		};
	}
}

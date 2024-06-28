package com.veterinary.veterinaryApp;

import com.veterinary.veterinaryApp.Repositories.*;
import com.veterinary.veterinaryApp.models.*;
import com.veterinary.veterinaryApp.services.AvailableSlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.veterinary.veterinaryApp.utils.Utils.fiveDigits;

@SpringBootApplication
public class VeterinaryAppApplication {


    @Autowired
    PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(VeterinaryAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner initDatabase(ClientRepository clientRepository, AccountRepository accountRepository,
                                          PetRepository petRepository, VeterinarianRepository veterinarianRepository,
                                          OfferingRepository offeringRepository, AppointmentRepository appointmentRepository,
                                          InvoiceRepository invoiceRepository, AvailableSlotsRepository availableSlotsRepository) {
        return (args) -> {

            // creacion de usuarios
            Client userAdmin = new Client("Jelena", "Palavecino", "jelena@vetadmin.com", passwordEncoder.encode("abc123"), 31334177);

            Client lucas = new Client("Lucas", "Madrigal", "lucas@mail.com", passwordEncoder.encode("123"), 51258927);

            Client pedro = new Client("Pedro", "Sanabria", "pedro@sanabria.com", passwordEncoder.encode("123"), 51258927);

            Client leonel = new Client("Leonel", "Borjas", "leonel@borjas.com", passwordEncoder.encode("123"), 51258927);

            clientRepository.save(userAdmin);
            clientRepository.save(lucas);
            clientRepository.save(pedro);
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
            Pet pet1 = new Pet("Pulguita", "5 años", "Perro", "Chihuahua", AnimalSize.SMALL, "healthy dog");
            Pet pet2 = new Pet("Luna", "2 años", "Gato", "Persa", AnimalSize.BIGGER, "healthy cat");
            Pet pet3 = new Pet("Pelusa", "3 meses", "Gato", "Siames", AnimalSize.MEDIUM, "angry cat, need sedation");
            Pet pet4 = new Pet("Coco", "1 año", "Perro", "Pastor Aleman", AnimalSize.SMALL, "blind dog");
            Pet pet5 = new Pet("Tomate", "6 meses", "Perro", "Pastor Aleman", AnimalSize.LARGE, "healthy dog");
            Pet pet6 = new Pet("Firulais", "15 años", "Perro", "Golden Retriever", AnimalSize.BIGGER, "very old dog");

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

            // Creación de Servicios
            List<String> daysOfService = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
            List<String> hoursOfService = Arrays.asList("09:00-12:00", "13:00-17:00");

            // Instancias de Offering
            Offering generalEnquiry = new Offering(
                    "General Enquiry",
                    "General consultation for check-ups and medical examinations of your pets.",
                    50.00,
                    daysOfService,
                    hoursOfService
            );

            Offering vaccination = new Offering(
                    "Vaccination",
                    "Complete vaccination to keep your pets protected against diseases.",
                    30.00,
                    daysOfService,
                    hoursOfService
            );

            Offering surgery = new Offering(
                    "Surgery",
                    "Surgeries and surgical procedures with the best care.",
                    200.00,
                    daysOfService,
                    hoursOfService
            );

            Offering canineHairdressing = new Offering(
                    "Canine Hairdressing",
                    "Grooming service to keep your pet clean and healthy.",
                    40.00,
                    daysOfService,
                    hoursOfService
            );

            Offering hospitalisation = new Offering(
                    "Hospitalisation",
                    "Care and monitoring of pets requiring hospitalisation.",
                    150.00,
                    daysOfService,
                    hoursOfService
            );

            Offering deworming = new Offering(
                    "Deworming",
                    "Deworming service to eliminate internal and external parasites, keeping your pet healthy.",
                    25.00,
                    daysOfService,
                    hoursOfService
            );


            offeringRepository.save(generalEnquiry);
            offeringRepository.save(vaccination);
            offeringRepository.save(surgery);
            offeringRepository.save(canineHairdressing);
            offeringRepository.save(hospitalisation);
            offeringRepository.save(deworming);

            List<String> daysOfServiceSlots = generateNextSevenDays();
            List<String> hoursOfServiceSlots = List.of("09:00", "10:00", "11:00");

            List<AvailableSlots> availableSlotsList = new ArrayList<>();

            for (String day : daysOfServiceSlots) {
                LocalDate date = LocalDate.parse(day);
                for (String hour : hoursOfServiceSlots) {
                    availableSlotsList.add(new AvailableSlots(date, hour, generalEnquiry));
                    availableSlotsList.add(new AvailableSlots(date, hour, vaccination));
                    availableSlotsList.add(new AvailableSlots(date, hour, surgery));
                    availableSlotsList.add(new AvailableSlots(date, hour, canineHairdressing));
                    availableSlotsList.add(new AvailableSlots(date, hour, hospitalisation));
                    availableSlotsList.add(new AvailableSlots(date, hour, deworming));
                }
            }

            for (AvailableSlots slot : availableSlotsList) {
                availableSlotsRepository.save(slot);
            }

            generalEnquiry.setAvailableSlots(availableSlotsList);
            vaccination.setAvailableSlots(availableSlotsList);
            surgery.setAvailableSlots(availableSlotsList);
            canineHairdressing.setAvailableSlots(availableSlotsList);
            hospitalisation.setAvailableSlots(availableSlotsList);
            deworming.setAvailableSlots(availableSlotsList);

            // creación de Appointment
            Appointment appointment1 = new Appointment(LocalDateTime.now().plusDays(3), LocalDateTime.now(), "Please get my dog a good shower, I´ll pick him up at noon", AppointmentStatus.CONFIRMED);

            // asignación de Cita a cliente
            appointment1.setClient(lucas);

            // asignación de cita a servicio
            appointment1.setOffering(hospitalisation);

            // Creación de Veterinarios
            Veterinarian vet1 = new Veterinarian("Brayan", "Veterinary Dermatology", "Calle 1 # 2 - 3", "31334177", "derma@tology.com");

            Veterinarian vet2 = new Veterinarian("Brayan", "Animal Behavior", "Calle 4 # 5 - 6", "31334177", "behavior@tology.com");

            Veterinarian vet3 = new Veterinarian("Brayan", "Veterinary Anesthesiology and Emergency Medicine", "Calle 7 # 8 - 9", "31334177", "anesthesio@logy.com");

            Veterinarian vet4 = new Veterinarian("Brayan", "Intern", "Calle 10 # 11 - 12", "31334177", "intern@tology.com");

            // Asignación de Cita a veterinario
            vet1.addAppointment(appointment1);

            veterinarianRepository.save(vet1);
            veterinarianRepository.save(vet2);
            veterinarianRepository.save(vet3);
            veterinarianRepository.save(vet4);

            // Creación de Invoice
            Invoice invoice1 = new Invoice(LocalDateTime.now(), 1000, InvoiceStatus.CHARGED);

            // Asignar invoice a la cita
            invoice1.setAppointment(appointment1);
            appointment1.setInvoice(invoice1);
            invoice1.setAccount(account2);

            invoiceRepository.save(invoice1);

            // Asignación de cita al cliente
            lucas.addAppointment(appointment1);

            // asignar cuenta a la invoice
            invoice1.setAccount(account4);

            // Asignar pet a la cita
            pet1.addAppointment(appointment1);

            // Asignar cita al veterinario
            vet2.addAppointment(appointment1);

            appointmentRepository.save(appointment1);

            // para saber cuando inicia la app
            System.out.println("****************************************************");
            System.out.println("*                                                  *");
            System.out.println("*        Bienvenido a Mi Aplicación Veterinaria    *");
            System.out.println("*                                                  *");
            System.out.println("****************************************************");

        };
    }

    public static List<String> generateNextSevenDays() {
        List<String> dates = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        int addedDays = 0;
        while (addedDays < 7) {
            if (!(currentDate.getDayOfWeek() == DayOfWeek.SATURDAY || currentDate.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                dates.add(currentDate.format(formatter));
                addedDays++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return dates;
    }
}
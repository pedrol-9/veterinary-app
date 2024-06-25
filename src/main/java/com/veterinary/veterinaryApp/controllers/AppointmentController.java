package com.veterinary.veterinaryApp.controllers;

import com.veterinary.veterinaryApp.DTOs.AppointmentDTO;
import com.veterinary.veterinaryApp.DTOs.VeterinarianDTO;
import com.veterinary.veterinaryApp.DTOs.requestBodys.NewAppointmentDTO;
import com.veterinary.veterinaryApp.models.*;
import com.veterinary.veterinaryApp.services.*;
import com.veterinary.veterinaryApp.utils.CyclicCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api-veterinary/appointments")
public class AppointmentController {

  @Autowired
  private AppointmentService appointmentService;

  @Autowired
  private ClientService clientService;

  @Autowired
  private PetService petService;

  @Autowired
  private OfferingService offeringService;

  @Autowired
  private VeterinarianService veterinarianService;

  @Autowired
  private InvoiceService invoiceService;

  @GetMapping("/")
  public ResponseEntity<?> getAllAppointments() {
    return ResponseEntity.ok(appointmentService.getAppointmentDTOs());
  }

  @PostMapping("/new")
  public ResponseEntity<?> createAppointment(@RequestBody NewAppointmentDTO newAppointmentDTO, Authentication authentication) {

    // cliente para asociar la cita
    Client client = clientService.getCurrentClient(authentication);

    // cuenta para asociar la invoice que se asocia a la cita
    Account account = client.getAccount();

    if (newAppointmentDTO.dateTime() == null) {
      return ResponseEntity.badRequest().body("The date and time field must not be empty");
    }

    // fechas para crear el turno
    LocalDateTime dateTime = newAppointmentDTO.dateTime();
    LocalDateTime creationDate = LocalDateTime.now();

    // Description para crear el turno
    String description = newAppointmentDTO.description();

    // status para crear el turno
    AppointmentStatus status = AppointmentStatus.valueOf(newAppointmentDTO.status().name().toUpperCase());

    // long petId para asociar una mascota a la cita y determinar el precio del servicio segun la mascota
    Long petId = newAppointmentDTO.petId();
    Pet pet = petService.getPetById(petId);

    if (pet == null) {
      return ResponseEntity.badRequest().body("Pet not found");
    }

    // animal size para determinar el precio del servicio
    AnimalSize petSize = pet.getAnimalSize();

    // long offeringId para asociar un servicio a la cita
    long offeringId = newAppointmentDTO.offeringId();
    Offering offering = offeringService.getOfferingById(offeringId);
    double baseRate = offering.getPrice();

    // método que calcula el precio del servicio segun el tamaño de la mascota
    double amountToCharge = offeringService.calculatePrice(petSize, baseRate);

    CyclicCounter vetCounter = new CyclicCounter(1, 3);
    long vetId = vetCounter.next();
    // Obtener el veterinario correspondiente al contador
    Veterinarian veterinarian = veterinarianService.getVeterinarianById(vetId);

    List<VeterinarianDTO> veterinarians = veterinarianService.getAllVeterinariansDTO();

    // Crear Invoice para asociarla a esa cita
    Invoice newInvoice = new Invoice(dateTime, amountToCharge, InvoiceStatus.PENDING);

    // Asociar Invoice a la cuenta
    newInvoice.setAccount(account);

    // Guardar Invoice en la base de datos
    invoiceService.saveInvoice(newInvoice);

    // Crear el turno y asociar con demás entidades
    Appointment newAppointment = new Appointment(dateTime, creationDate, description, status);

    // Asociar Invoice a la cita
    newInvoice.setAppointment(newAppointment);

    // asociar turno a client, pet, offering y veterinarian
    appointmentService.setEntities(newAppointment, client, pet, veterinarian, offering, newInvoice);

    // Guardar el turno en la base de datos
    appointmentService.saveAppointment(newAppointment);

    // Crear el DTO para devolver la respuesta
    AppointmentDTO newAppointmentObject = new AppointmentDTO(newAppointment);

    return new ResponseEntity<>(newAppointmentObject, HttpStatus.CREATED);
  }
}

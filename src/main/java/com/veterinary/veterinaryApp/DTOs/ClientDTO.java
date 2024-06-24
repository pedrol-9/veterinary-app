package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Appointment;
import com.veterinary.veterinaryApp.models.AppointmentStatus;
import com.veterinary.veterinaryApp.models.Client;
import com.veterinary.veterinaryApp.models.Pet;

import java.time.LocalDateTime;
import java.util.List;

public class ClientDTO {

  private Long id;

  private String clientName;

  private String email;

  private AccountDTO account;

  private int phone;

  private boolean admin;

  private List<PetDTO> pets;

  private List<AppointmentDTO> confirmedAppointments;

  public ClientDTO(Client client) {

    List<Appointment> appointmentsAux = client.getAppointments().stream().filter(app -> app.getAppointmentStatus().equals(AppointmentStatus.CONFIRMED)).toList(); // variable auxiliar para obtener las citas confirmadas y sacar solo un array de fechas

    List<Pet> petsAux = client.getPets();

    this.id = client.getId();
    this.clientName = client.getFirstName() + " " + client.getLastName();
    this.email = client.getEmail();
    this.phone = client.getPhone();
    this.admin = client.isAdmin();
    this.account = new AccountDTO(client.getAccount());
    this.pets = petsAux.stream().map(PetDTO::new).toList();
    this.confirmedAppointments = appointmentsAux.stream().map(AppointmentDTO::new).toList();

  }

  public Long getId() {
    return id;
  }

  public String getClientName() {
    return clientName;
  }

  public String getEmail() {
    return email;
  }

  public AccountDTO getAccount() {
    return account;
  }

  public int getPhone() {
    return phone;
  }

  public boolean isAdmin() {
    return admin;
  }

  public List<PetDTO> getPets() {
    return pets;
  }

  public List<AppointmentDTO> getConfirmedAppointments() {
    return confirmedAppointments;
  }
}

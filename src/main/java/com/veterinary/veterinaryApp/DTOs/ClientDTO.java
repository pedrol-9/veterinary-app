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

  private long account;

  private String accountNumber;

  private int phone;

  private boolean admin;

  private List<String> pets;

  private List<LocalDateTime> confirmedAppointments;

  public ClientDTO(Client client) {

    List<Appointment> appointmentsAux = client.getAppointments().stream().filter(app -> app.getAppointmentStatus().equals(AppointmentStatus.CONFIRMED)).toList(); // variable auxiliar para obtener las citas confirmadas y sacar solo un array de fechas

    this.id = client.getId();
    this.clientName = client.getFirstName() + " " + client.getLastName();
    this.email = client.getEmail();
    this.account = client.getAccount().getId();
    this.accountNumber = client.getAccount().getNumber();
    this.phone = client.getPhone();
    this.admin = client.isAdmin();
    this.pets = client.getPets().stream().map(Pet::getPetName).toList();
    this.confirmedAppointments = appointmentsAux.stream().map(Appointment::getDateTime).toList();

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

  public long getAccount() {
    return account;
  }

  public int getPhone() {
    return phone;
  }

  public boolean isAdmin() {
    return admin;
  }

  public List<String> getPets() {
    return pets;
  }

  public List<LocalDateTime> getConfirmedAppointments() {
    return confirmedAppointments;
  }

  public String getAccountNumber() {
    return accountNumber;
  }
}

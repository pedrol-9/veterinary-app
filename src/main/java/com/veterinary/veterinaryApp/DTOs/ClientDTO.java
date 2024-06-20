package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Client;

public class ClientDTO {

  private Long id;
  private String clientName;
  private String email;
  private int phone;
  private String password;
  private boolean admin;

  public ClientDTO(Client client) {
    this.id = client.getId();
    this.clientName = client.getFirstName() + " " + client.getLastName();
    this.email = client.getEmail();
    this.phone = client.getPhone();
    this.password = client.getPassword();
    this.admin = client.isAdmin();
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
  public int getPhone() {
    return phone;
  }
  public String getPassword() {
    return password;
  }
  public boolean isAdmin() {
    return admin;
  }
}

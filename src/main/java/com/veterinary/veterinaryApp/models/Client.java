package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  int phone;

  boolean admin;

  @OneToOne // tengo mis dudas
  private Account account;

  @OneToMany(mappedBy = "owner")
  private List<Pet> pets;

  @OneToMany(mappedBy = "client")
  private Appointment appointment;

  // Constructores
  public Client() {
  }

  public Client(String firstName, String lastName, String email, String password, int phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.setAdmin(email);
  }

  // Métodos accesores
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getPhone() {
    return phone;
  }

  public void setPhone(int phone) {
    this.phone = phone;
  }

  public boolean isAdmin() {
    return admin;
  }

  public void setAdmin(String email) {
    this.admin = email.contains("@admin.com");
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Appointment getAppointment() {
    return appointment;
  }

  public void setAppointment(Appointment appointment) {
    this.appointment = appointment;
  }

  public List<Pet> getPets() {
    return pets;
  }

  public void setPets(List<Pet> pets) {
    this.pets = pets;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
        + ", password=" + password + ", phone=" + phone + ", admin=" + admin + "]";
  }
}

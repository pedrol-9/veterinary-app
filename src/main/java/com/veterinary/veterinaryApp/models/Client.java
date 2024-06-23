package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
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

  @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
  private Account account;

  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
  private List<Pet> pets = new ArrayList<>();

  @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
  private List<Appointment> appointments = new ArrayList<>();

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
    this.admin = email.contains("@vetadmin.com");
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

  public List<Appointment>  getAppointments() {
    return appointments;
  }

  public void setAppointments(List<Appointment> appointments) {
    this.appointments = appointments;
  }

  public List<Pet> getPets() {
    return pets;
  }

  public void setPets(List<Pet> pets) {
    this.pets = pets;
  }

  // Otros metodos
  public void addAppointment(Appointment appointment) {
    this.appointments.add(appointment);
    appointment.setClient(this);
  }

  public void addPet(Pet pet) {
    pet.setOwner(this);
    pets.add(pet);
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
        + ", password=" + password + ", phone=" + phone + ", admin=" + admin + "]";
  }
}

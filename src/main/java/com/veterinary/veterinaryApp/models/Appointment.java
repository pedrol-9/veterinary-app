package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {

  @Id
  @GeneratedValue
  private Long id;

  private LocalDateTime dateTime;

  @ManyToOne
  @JoinColumn(name = "veterinarian_id")
  private Veterinarian veterinarian;

  @ManyToOne
  @JoinColumn(name = "walker_id")
  private Walker walker;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne
  @JoinColumn(name = "pet_id")
  private Pet pet;

  @ManyToOne
  @JoinColumn(name = "service_id")
  private Service service;

  // constructores
  public Appointment(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public Appointment() {
  }

  // getters y setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public Veterinarian getVeterinarian() {
    return veterinarian;
  }

  public void setVeterinarian(Veterinarian veterinarian) {
    this.veterinarian = veterinarian;
  }

  public Walker getWalker() {
    return walker;
  }

  public void setWalker(Walker walker) {
    this.walker = walker;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }


}

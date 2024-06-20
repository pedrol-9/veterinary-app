package com.veterinary.veterinaryApp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Appointment {

  @Id
  @GeneratedValue
  private Long id;

  private LocalDateTime dateTime;

  private Veterinarian veterinarian;

  private Walker walker;

  private Client client;

  private Pet pet;

  // private Service service;


  // constructores
  public Appointment(LocalDateTime dateTime) {
    this.dateTime = dateTime;

  }

  public Appointment() {
  }


}

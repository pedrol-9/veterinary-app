package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    private LocalDateTime creationDatetime;

    private String notes;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus; // SCHEDULED, CONFIRMED, CLOSED, cancelled;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private Veterinarian veterinarian;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Offering offering;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    // constructores
    public Appointment() {
    }

    public Appointment(LocalDateTime dateTime, LocalDateTime creationDatetime, String notes, AppointmentStatus appointmentStatus) {
        this.dateTime = dateTime;
        this.creationDatetime = creationDatetime;
        this.notes = notes;
        this.appointmentStatus = appointmentStatus;
    }

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

  public LocalDateTime getCreationDatetime() {
    return creationDatetime;
  }

  public void setCreationDatetime(LocalDateTime creationDatetime) {
    this.creationDatetime = creationDatetime;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Veterinarian getVeterinarian() {
    return veterinarian;
  }

  public void setVeterinarian(Veterinarian veterinarian) {
    this.veterinarian = veterinarian;
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

  public Offering getOffering() {
    return offering;
  }

  public void setOffering(Offering offering) {
    this.offering = offering;
  }

  public Invoice getInvoice() {
    return invoice;
  }

  public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
  }

  public AppointmentStatus getAppointmentStatus() {
    return appointmentStatus;
  }

  public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
    this.appointmentStatus = appointmentStatus;
  }
}

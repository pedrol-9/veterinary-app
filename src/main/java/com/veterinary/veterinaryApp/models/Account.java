package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private double balance;

  private String number;

  @OneToOne
  @JoinColumn(name = "user_id")
  private Client client;

  // Constructores
  public Account() {
  }

  public Account(double balance, String number) {
    this.balance = balance;
    this.number = number;
  }

  // Getters y Setters
  public Long getId() {
    return id;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public Client getUser() {
    return client;
  }

  public void setUser(Client client) {
    this.client = client;
  }

  @Override
  public String toString() {
    return "Account [id=" + id + ", balance=" + balance + ", user=" + client + "]";
  }
}

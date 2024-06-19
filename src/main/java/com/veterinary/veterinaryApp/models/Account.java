package com.veterinary.veterinaryApp.models;

import jakarta.persistence.*;

@Entity
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private double balance;

  @OneToOne
  @JoinColumn(name = "user_id")
  private Client client;

  // Constructores
  public Account() {
  }

  public Account(double balance) {
    this.balance = balance;
  }

  // Getters y Setters
  public Long getId() {
    return id;
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

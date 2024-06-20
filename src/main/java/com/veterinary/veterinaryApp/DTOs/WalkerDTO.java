package com.veterinary.veterinaryApp.DTOs;

import com.veterinary.veterinaryApp.models.Walker;

public class WalkerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public WalkerDTO(Walker walker) {
        this.id = walker.getId();
        this.firstName = walker.getFirstName();
        this.lastName = walker.getLastName();
        this.phone = walker.getPhone();
        this.address = walker.getAddress();
    }

    public WalkerDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}

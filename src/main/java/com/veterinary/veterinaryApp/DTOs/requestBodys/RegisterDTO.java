package com.veterinary.veterinaryApp.DTOs.requestBodys;

public record RegisterDTO (String firstName, String lastName, String email, String password, int phone) {
}

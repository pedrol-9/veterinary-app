package com.veterinary.veterinaryApp.DTOs.requestBodys;

import jakarta.validation.constraints.NotNull;

public record UpdateOfferingDTO (@NotNull double price, @NotNull long id) {
}

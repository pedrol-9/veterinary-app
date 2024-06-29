package com.veterinary.veterinaryApp.DTOs.requestBodys;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record NewOfferingDTO(@NotNull String name, @NotNull String description,  double price, String image) {

}

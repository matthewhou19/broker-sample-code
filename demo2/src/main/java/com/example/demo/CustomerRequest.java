package com.example.demo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CustomerRequest {
    @NotEmpty(message = "Pickup date is required")
    private String pickupDate;

    @Min(value = 1, message = "The number of vehicles must be at least 1")
    @Max(value = 12, message = "The number of vehicles must be at most 12")
    private int vehicles;

    @Min(value = 50, message = "Price per space must be at least $50")
    @Max(value = 20000, message = "Price per space must be at most $20,000")
    private int pricePerSpace;

    @NotNull(message = "Options cannot be null")
    private List<String> options;
}

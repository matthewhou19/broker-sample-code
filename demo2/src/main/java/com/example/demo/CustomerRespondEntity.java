package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;



@Entity
@Data
public class CustomerRespondEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Date is required")
    private String date;

    @NotNull(message = "Name is required")
    private String name;

    @Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Phone number must be in the format xxx-xxx-xxxx")
    private String phoneNumber;


    private String email;

    @NotNull(message = "Vehicle information is required")
    private String vehicle;

    @Column(name = "\"year\"")
    private Integer year;

    @NotNull(message = "Make is required")
    private String make;

    @NotNull(message = "Model is required")
    private String model;

    @NotNull(message = "Vehicle type is required")
    private String vehicleType;

    private String vehicleCondition;

    @NotNull(message = "Origin state is required")
    private String originState;

    @Column(name = "originZipCode")
    private String originZipCode;

    @NotNull(message = "Destination state is required")
    private String destinationState;

    @Column(name = "destinationZipCode")
    private String destinationZipCode;

    @NotNull(message = "Estimate shipping date is required")
    private String estimateShippingDate;

    private String archivedStatus;

    private String assignedTo;

}

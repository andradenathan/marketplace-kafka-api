package com.github.andradenathan.marketplace.entities.customers;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Table(name = "customers")
public class Customer {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String status;
    private String profilePictureUrl;
    private Boolean isEmailVerified;
}

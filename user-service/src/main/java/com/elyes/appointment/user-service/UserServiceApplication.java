package com.elyes.advanced.appointment.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Main application class for the User Service microservice.
 * Part of the Advanced Smart Appointment Booking System.
 * 
 * @author Elyes
 * @version 1.0
 * @copyright 2024-2025
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
} 
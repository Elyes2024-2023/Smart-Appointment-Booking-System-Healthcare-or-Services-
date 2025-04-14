package com.elyes.advanced.appointment.user.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Swagger API documentation.
 * Part of the Advanced Smart Appointment Booking System.
 * 
 * @author Elyes
 * @version 1.0
 * @copyright 2024-2025
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Advanced Smart Appointment Booking System - User Service API")
                        .description("API documentation for the User Service of the Advanced Smart Appointment Booking System")
                        .version("1.0")
                        .license(new License()
                                .name("Copyright (c) 2024-2025 Elyes")
                                .url("https://github.com/Elyes2024-2023/Advanced-Smart-Appointment-Booking-System")))
                .components(new Components()
                        .addSecuritySchemes("bearer-jwt", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
} 
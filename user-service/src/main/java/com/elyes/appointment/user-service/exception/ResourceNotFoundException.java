package com.elyes.advanced.appointment.user.exception;

/**
 * Custom exception for handling resource not found scenarios.
 * 
 * @author Elyes
 * @version 1.0
 */
public class ResourceNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }
} 
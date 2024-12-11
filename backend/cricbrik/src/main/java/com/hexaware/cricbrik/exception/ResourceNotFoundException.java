package com.hexaware.cricbrik.exception;

/**
 * Exception: ResourceNotFoundException
 * Description: Custom exception for resource not found scenarios.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {

        super(message);
    }
}
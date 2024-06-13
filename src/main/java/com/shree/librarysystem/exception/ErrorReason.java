package com.shree.librarysystem.exception;

public enum ErrorReason {
    CONSTRAINT_VIOLATION("Constraint violation occurred"),
    RESOURCE_NOT_FOUND("Resource not found"),
    VALIDATION_FAILED("Validation failed"),
    INTERNAL_SERVER_ERROR("Internal server error");

    private final String message;

    ErrorReason(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

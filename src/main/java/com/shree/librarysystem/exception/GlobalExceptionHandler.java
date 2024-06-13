package com.shree.librarysystem.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorInfo> handleConstraintViolationException(ConstraintViolationException ex) {
        ErrorInfo errorInfo = new ErrorInfo(
                HttpStatus.BAD_REQUEST.toString(),
                ex.getMessage(),
                ErrorReason.CONSTRAINT_VIOLATION.getMessage()
        );
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorInfo> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorInfo errorInfo = new ErrorInfo(
                HttpStatus.NOT_FOUND.toString(),
                ex.getMessage(),
                ErrorReason.RESOURCE_NOT_FOUND.getMessage()
        );
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> handleException(Exception ex) {
        ErrorInfo errorInfo = new ErrorInfo(
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                ex.getMessage(),
                ErrorReason.INTERNAL_SERVER_ERROR.getMessage()
        );
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

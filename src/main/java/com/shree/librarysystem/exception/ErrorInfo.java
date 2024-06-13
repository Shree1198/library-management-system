package com.shree.librarysystem.exception;

public class ErrorInfo {
    private String code;
    private String message;
    private String reason;

    public ErrorInfo(String code, String message, String reason) {
        this.code = code;
        this.message = message;
        this.reason = reason;
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

package com.example.homework7.exception;

public class PasswordException extends Exception {
    public PasswordException(String message) {
        super("Password must contain a special characters");
    }
}

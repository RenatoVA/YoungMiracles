package com.grupo1software.youngmiracles.exception;

public class RolNotFoundException extends RuntimeException {
    public RolNotFoundException() {super("Role not found");}

    public RolNotFoundException(String message) {}
}

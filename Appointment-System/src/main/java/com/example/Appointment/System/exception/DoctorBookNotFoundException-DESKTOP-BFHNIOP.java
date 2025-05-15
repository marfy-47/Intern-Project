package com.example.Appointment.System.Exception;

public class DoctorBookNotFoundException extends Throwable {
    public DoctorBookNotFoundException(String message) {
        super(message);
    }
}
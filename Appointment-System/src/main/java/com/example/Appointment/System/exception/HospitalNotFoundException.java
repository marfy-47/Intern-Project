package com.example.Appointment.System.Exception;

public class HospitalNotFoundException extends RuntimeException {
  public HospitalNotFoundException(String message) {
    super(message);
  }
}

# Appointment System - Spring Boot Application

## Overview
This repository contains a Spring Boot-based application for an appointment system that allows doctors and patients to book, manage, and view medical appointments. The application utilizes JPA for database interaction, with entities for managing doctors, patients, and appointments. Additionally, it includes a lab test booking feature, providing functionality for booking lab tests at hospitals.

## Today's Work Summary

### 1. **Doctor Entity and Repository**
   - **Doctor Entity**: 
     The `Doctor` entity class was created with attributes such as `id`, `doctorName`, `designation`, `contactNumber`, `email`, `yearsOfExperience`, `hospitalOrClinicName`, and more. Relationships with `Patient` and `DoctorBooking` entities are defined using `@OneToMany` and `@ManyToMany`.
     
   - **Doctor Repository**:
     The `DoctorRepository` interface was created, extending `JpaRepository`. This repository provides CRUD operations for the `Doctor` entity, along with custom queries for searching by `email` and `licenseNumber`.

   - **Doctor Service**:
     A `DoctorService` class was implemented to handle business logic for fetching and saving doctors, as well as fetching doctors by email.

   - **Doctor Controller**:
     A REST API controller (`DoctorController`) was implemented to expose endpoints for interacting with the `Doctor` entity. Endpoints include retrieving all doctors, fetching by ID, creating or updating a doctor, and deleting a doctor.

### 2. **Lab Test Booking Mapper and DTO**
   - **Lab Test Booking Mapper**:
     The `LabTestBookingMapper` class was developed to map between `LabTestBookingDTO` and `LabTestBooking` entities. It includes:
     - `toLabTestBooking()` method: Converts a `LabTestBookingDTO` into a `LabTestBooking` entity, ensuring that patient and hospital data are correctly set.
     - `toLabTestBookingDTO()` method: Converts a `LabTestBooking` entity into a `LabTestBookingDTO` for returning data in the API response.
     - `toLabTestBookingDTOS()` method: Maps a list of `LabTestBooking` entities to a list of `LabTestBookingDTO`.

   - **Lab Test Booking Error Handling**:
     Error handling was added to manage scenarios where a patient or hospital is not found. Custom exceptions `LabTestBookingNotFoundException` and `PatientNotFoundException` are thrown when appropriate.

   - **Mapping Relationships**:
     The mapper ensures the relationships between the `LabTestBooking`, `Patient`, and `Hospital` entities are correctly handled. The `LabTestBooking` is added to the relevant sets in the `Patient` and `Hospital` entities.

### 3. **Spring Security Context**
   - The patient information is fetched from the Spring Security context using `SecurityContextHolder.getContext().getAuthentication().getName()` to get the authenticated user’s name (which is assumed to be the patient's name).
   - The patient’s name is used to fetch the `Patient` entity from the database.

### 4. **Improvements and Fixes**
   - **Fixed Duplicate Declaration**: The code for the `Hospital` entity was updated to fix a duplicate declaration issue, ensuring that the hospital is retrieved correctly.
   - **Updated Set Handling**: Instead of overwriting the `Set<LabTestBooking>`, the new `LabTestBooking` is added to the existing set of `LabTestBooking` objects for both `Patient` and `Hospital`.

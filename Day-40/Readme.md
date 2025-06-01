# 💊 Prescription Generator (Spring Boot + React + H2 Database)

A full-stack web application for generating medical prescriptions. Built with **Spring Boot (Gradle)** as backend and **React.js** as frontend. Uses **JWT authentication**, **H2 in-memory database**, and supports basic CRUD operations for prescriptions.

---

## 🏗️ Project Structure

### 🔙 Backend (Spring Boot)

# Project Structure
src
├── main
│ ├── java/com/example/prescription_generation
│ │ ├── entity # Prescription.java, User.java
│ │ ├── controller # PrescriptionController.java, AuthController.java
│ │ ├── service # PrescriptionService.java, AuthService.java
│ │ ├── repository # PrescriptionRepository.java, UserRepository.java
│ │ ├── dto # PrescriptionDTO.java, LoginRequest.java, JwtResponse.java
│ │ └── config # SecurityConfig.java, JwtUtils.java
│ └── resources
│ ├── application.properties
└── build.gradle


## 🔐 JWT Authentication (Backend)

- Login via `/api/auth/login`
- Get JWT token in response
- Use token in frontend via `Authorization: Bearer <token>` header

---

## 🗄️ H2 Database Configuration

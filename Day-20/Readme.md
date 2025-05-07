# 🗓️ Extended Appointment System

This project is an extended version of the basic Appointment System, designed to provide a more interactive user interface and better separation of concerns using service-layer architecture.

## 🚀 What's New in the Extended Version

- ✅ **Thymeleaf UI Integration**: Replaced basic HTML or API-only responses with dynamic views rendered using Thymeleaf templates.
- ✅ **Service Layer Added**: Introduced a dedicated service layer to handle business logic, improving code structure, testability, and maintainability.

## 🧩 Project Architecture

- **Controller Layer** – Handles HTTP requests and interacts with the service layer.
- **Service Layer** – Contains the business logic and communicates with repositories.
- **Repository Layer** – Interfaces with the database using Spring Data JPA.
- **View Layer** – Built with Thymeleaf templates for server-side rendering.

## 🛠 Technologies Used

- **Backend**: Spring Boot (Java), Spring MVC
- **Templating Engine**: Thymeleaf
- **Database**: H2 / MySQL (configurable)
- **Build Tool**: Graddle
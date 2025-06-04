                                                                        📋 Prescription Generation Management
                                                                        
                                                                        
    A complete web application that streamlines the process of prescription generation by doctors. Built with a robust Java-based backend and a dynamic frontend, this project ensures seamless,    secure, and efficient management of prescriptions.

🛠️ Tech Stack
# Backend:

    ☕ Java 21/Coretto

    🚀 Spring Boot

    🔗 JPA Data Hibernate

    🛡️ Spring Security

    🔐 JWT Token-based Authentication and Authorization

    📝 Lombok

    📚 Swagger (OpenAPI)

# Frontend:

    🖥️ Thymeleaf

Database:

    💾 H2 Database (In-Memory
    http://localhost:8080/h2-console/

📖 About the Project
This project allows doctors to securely create, manage, and view patient prescriptions. With built-in authentication and role-based authorization, it ensures that only authorized users can access sensitive information.

# Key Points:

    JWT Token is used for stateless authentication and authorization, ensuring secure access to protected endpoints.

    The application uses an H2 in-memory database, making it easy to set up and test without requiring additional installations.

    Swagger is integrated to simplify API testing and exploration.

    The project is designed to be opened and run in an IDE like IntelliJ IDEA, Eclipse, or NetBeans.


💻 Getting Started
# Prerequisites
    Java 21

    Spring Boot. Version 3.4.5

# JPA Data Hibernate

# Graddle. Version 0.0.1-snapshot

    An IDE such as IntelliJ IDEA, Eclipse, or NetBeans (recommended for easier code navigation and execution)


# Running the Application
    1️⃣ Clone the repository:

        bash
        Copy
        Edit
        git clone https://https://github.com/marfy-47/Intern-Project
        cd prescription-generation-management

    2️⃣ Open the project in your preferred IDE:

        Import the project as a Graddle project in IntelliJ IDEA, Eclipse, or NetBeans.

    3️⃣ Run the application:

    Use your IDE’s "Run" or "Debug" configuration, or run via Graddle:

        bash
        Copy
        Edit
        mvn spring-boot:run

    4️⃣ Access the application:

        Web Application: http://localhost:8080

        Swagger UI: http://localhost:8080/swagger-ui/index.html

        Use Swagger to test API endpoints (GET, POST, PUT, DELETE) easily.

        Provide your JWT Token in the Authorize section to test secured endpoints.

    5️⃣ Access H2 Database Console:

        Navigate to http://localhost:8080/h2-console

        JDBC URL: jdbc:h2:mem:testdb

        Username: root

        Password: (leave blank)


# 🔐 Security
    JWT Token-based Authentication and Authorization:

    When a user logs in, a JWT token is generated and returned.

    This token must be included in the Authorization header of API requests (e.g., Bearer <token>).

    Spring Security integrates seamlessly with JWT to ensure that only authenticated users can access protected endpoints.

🗂️ Project Structure
bash
Copy
Edit
prescription-generation-management/
├── src/
│   ├── main/
│   │   ├── java/com/example/prescription_generation/
│   │   │   ├── configuration/       # Application and security configurations
│   │   │   ├── controller/          # REST and web controllers
│   │   │   ├── implementation/      # Service implementations
│   │   │   ├── jwt/                 # JWT utilities and filters
│   │   │   ├── model/               # Domain models and DTOs
│   │   │   │   ├── entity/          # Entity classes
│   │   │   │   └── dto/             # Data Transfer Objects
│   │   │   ├── repository/          # JPA repositories
│   │   │   ├── service/             # Service interfaces
│   │   │   ├── thymeleaf/           # Thymeleaf-related components
│   │   │   └── validation/          # Custom validators
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/              # CSS, images
│   │       └── templates/           # Thymeleaf templates
│   └── test/                        # Unit and integration tests
└── build.graddle                    # Graddle configuration

📑 License
    This project is licensed under the MIT License - see the LICENSE file for details.

🤝 Contributing
    Contributions are welcome! Feel free to open issues or submit pull requests.

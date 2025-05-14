**📅 Date:** May 14, 2025  
**🔧 Build Tool:** Gradle  
**🧰 Framework:** Spring Boot

---

## ✅ Summary of Today's Work

### 1. 🔐 Implemented JWT Authentication (Gradle)

- Set up JWT-based login and token generation using `jjwt` (0.9.1).
- Secured endpoints using Bearer token.
- Created `JwtUtil`, `JwtFilter`, and `AuthController`.
- Configured `SecurityFilterChain` with stateless session.
- Implemented a basic in-memory `UserDetailsService`.
- Integrated with Swagger UI for testing Bearer tokens.

---

### 2. 📊 Integrated Swagger with JWT Support

- Added Swagger/OpenAPI (springdoc-openapi 2.2.0) to visualize and test secured APIs.
- Used `@SecurityRequirement(name = "bearerAuth")` to secure endpoints in Swagger UI.
- Created a `SwaggerConfig` class to define the security schema and Bearer setup.

---

### 3. 📞 Validation Utility Enhancement

- Updated the `ImportantValidation` class with:
  - ✅ Email validation
  - ✅ Bangladeshi phone number validation
  - ✅ Strong password validation (min 8 chars, 1 upper, 1 lower, 1 digit, 1 special)

---

### 4. 🧾 Explored & Understood Code

- Studied and understood:
  - `@Service`, `@RestController`, `@Autowired`, `@Builder`, `@Entity`, `@OneToMany`, and other Spring annotations.
  - Class-level and method-level validation using regex patterns.
  - Controller-service-entity structure in a Spring Boot REST API.

---

## ✅ Technologies Used

- **Spring Boot**
- **Spring Security**
- **JWT (io.jsonwebtoken)**
- **Swagger (springdoc-openapi)**
- **Gradle**
- **Regex for Validation**
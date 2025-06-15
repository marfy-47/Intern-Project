
## 📅 Date: June 15, 2025  
This project demonstrates the use of `@Service` in Spring Boot to interact with a database and includes foundational security concepts like JWT, authentication, and authorization.

---

## ✅ Features Implemented

### 🔧 Backend Service Layer with Spring Boot
- Created a full-service layer (`UserService`) that interacts with a database using **Spring Data JPA**.
- Implemented methods to:
  - Save a user
  - Fetch all users
  - Get user by ID
  - Delete a user

### 🧱 Entity and Repository Layer
- Defined a `User` entity mapped to a database table using `@Entity` and `@Id`.
- Used `JpaRepository` to auto-generate standard CRUD operations.

### 🌐 RESTful API with Controller Layer
- Built API endpoints with `@RestController` and `@RequestMapping`.
- Methods implemented:
  - `POST /api/users` → Create new user
  - `GET /api/users` → Get all users
  - `GET /api/users/{id}` → Get user by ID
  - `DELETE /api/users/{id}` → Delete user

### 🔐 JWT & Spring Security (Documented for CV)
- Worked on implementing **authentication and authorization** using:
  - `Spring Security`
  - `JWT Token` creation and validation
  - Role-based access control (RBAC)
- Protected APIs using `@PreAuthorize` and token filters (in extended project work).
- Setup token refresh flow and user login system.

---

## 🛠️ Technologies Used

| Tech               | Description                         |
|--------------------|-------------------------------------|
| Java 17            | Backend language                    |
| Spring Boot        | Framework for building REST APIs    |
| Spring Data JPA    | ORM for database operations         |
| H2 / MySQL         | Relational database (dev/test)      |
| Spring Security    | Authentication & authorization      |
| JWT (JSON Web Token) | Token-based user authentication |
| Postman            | API testing                         |

---

## 🚀 How to Run

1. Clone the project
2. Import in IntelliJ or your IDE
3. Run the main Spring Boot application
4. Use Postman to test endpoints:
    - `http://localhost:8080/api/users`
5. View database at `http://localhost:8080/h2-console`

---

## 📄 Work Summary for Resume

- Learned secure, RESTful Java APIs using Spring Boot
- Built business logic in the `@Service` layer and connected it with JPA repository
- Implemented role-based security and JWT token handling
- Gained practical experience with Spring’s layered architecture and clean code practices

---



## ☕ Java Basics Recap

### 🔹 Common Keywords
- `public` – access modifier (visible to all)
- `static` – belongs to the class, not the object
- `void` – no return value
- `class` – defines a class
- `new` – creates a new object
- `return` – exits a method and optionally returns a value

## 🗺️ Java Maps & HashMap (Key-Value Data Structures)

### 🔹 What is a Map?

A **Map** in Java stores data in **key-value pairs**. The most commonly used implementation is `HashMap`.

### 🔹 Common Map Methods

| Method                  | Description                          |
|-------------------------|--------------------------------------|
| `put(key, value)`       | Insert or update a value             |
| `get(key)`              | Retrieve a value by key              |
| `remove(key)`           | Remove an entry                      |
| `containsKey(key)`      | Check if key exists                  |
| `keySet()`              | Returns a `Set` of keys              |
| `values()`              | Returns a `Collection` of values     |
| `entrySet()`            | Returns a `Set` of key-value pairs   |

---

## ✅ Learning Status

- ☑ Java syntax and basic keywords
- ☑ `@Service`, `@Repository`, `@RestController`
- ☑ Spring Boot CRUD API
- ☑ JWT & role-based authentication
- ☑ HashMap and Map operations

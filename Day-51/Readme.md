# 📘 Spring Boot - Data JPA Query Methods, Pagination, and Sorting

## 📅 Date: June 25, 2025

## 📌 Topics Covered:
- Spring Data JPA Query Methods
- Pagination in Spring Boot using `Pageable`
- Sorting with `Sort` object

---

## 🔍 1. Spring Data JPA Query Methods

Spring Data JPA allows developers to define repository methods by just declaring method names — no implementation needed.

### 🛠 Common Keywords:
| Keyword        | Description                        |
|----------------|------------------------------------|
| `findBy`       | Select based on field value        |
| `findAllBy`    | Select all rows matching condition |
| `countBy`      | Count rows matching condition      |
| `existsBy`     | Check if row exists                |
| `deleteBy`     | Delete matching row(s)             |
| `And`, `Or`    | Combine conditions                 |
| `Between`, `LessThan`, `GreaterThan` | Range conditions  |

### ✅ Examples:
```java
List<User> findByName(String name);
User findByEmailAndStatus(String email, String status);
List<Product> findByPriceBetween(double min, double max);
boolean existsByUsername(String username);
long countByCategory(String category);


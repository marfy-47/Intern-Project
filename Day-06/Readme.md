# Project Update: Learning FetchType, CascadeType, and DTO Extension

## 📚 What I Learned

### 🔄 FetchType (Lazy vs Eager)
In JPA, `FetchType` defines when related entities are loaded from the database:

- `FetchType.LAZY`: The related entities are **loaded on demand**. This is the default for `@OneToMany` and `@ManyToMany` relationships. It's memory-efficient but requires care to avoid `LazyInitializationException`.
- `FetchType.EAGER`: The related entities are loaded immediately with the parent. This is the default for `@OneToOne` and `@ManyToOne`. However, it can be expensive in terms of performance if not used properly.

**Example:**
```java
@OneToMany(mappedBy = "blog", fetch = FetchType.LAZY)
private List<Comment> comments;


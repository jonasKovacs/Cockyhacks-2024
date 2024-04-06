package backend.app.src.main.java.com.myapp.model;

import java.util.List;

public class User {
    private Long id;
    private String username;
    private String email;
    private String passwordHash; // Store only a hashed version of the password
    private String role; // e.g., "student", "instructor", "admin"

    // Constructors
    public User() {}

    public User(Long id, String username, String email, String passwordHash, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }
}

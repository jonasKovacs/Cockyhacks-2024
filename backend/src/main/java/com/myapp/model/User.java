package com.myapp.model;
import java.util.UUID;
import java.util.ArrayList;

public class User {
    public UUID id;
    public String username;
    public String password;
    public String email;
    public Role role;
    public ArrayList<Review> reviews;

    public User(String username, String password, String email, Role role) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.reviews = new ArrayList<Review>();
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public void addReview(Review review) {
        this.reviews.add(review);
    }
}

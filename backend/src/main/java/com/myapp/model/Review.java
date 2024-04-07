package com.myapp.model;
import java.util.UUID;
//import java.util.ArrayList;
import java.time.LocalDateTime;

public class Review {
    public UUID id;
    public Course course;
    public User user;
    public double starRating;
    public String content;
    public LocalDateTime datePosted;

    public Review(Course course, User user, double starRating, String content) {
        this.id = UUID.randomUUID();
        this.course = course;
        this.user = user;
        this.starRating = starRating;
        this.content = content;
        this.datePosted = LocalDateTime.now();
    }
    public void setRating(double starRating) {
        this.starRating = starRating;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public void updateReview(double starRating, String content) {
        this.starRating = starRating;
        this.content = content;
    }

}
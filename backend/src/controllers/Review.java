package backend.src.controllers;
import java.util.ArrayList;
import java.util.UUID;

public class Review {
    public UUID id;
    public Course course;
    public User user;
    public double starRating;
    public String content;

    public Review(Course course, User user, double starRating, String content) {
        this.id = UUID.randomUUID();
        this.course = course;
        this.user = user;
        this.starRating = starRating;
        this.content = content;
    }
}

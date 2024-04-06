package backend.app.src.main.java.com.myapp.controllers;
import java.util.UUID;
//import java.util.ArrayList;

public class ReviewController {
    public UUID id;
    public CourseController course;
    public UserController user;
    public double starRating;
    public String content;

    public ReviewController(CourseController course, UserController user, double starRating, String content) {
        this.id = UUID.randomUUID();
        this.course = course;
        this.user = user;
        this.starRating = starRating;
        this.content = content;
    }
}

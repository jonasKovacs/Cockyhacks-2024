package backend.app.src.main.java.com.myapp.controllers;
import java.util.UUID;
import java.util.ArrayList;

public class CourseController {
    public UUID id;
    public String courseNumber;
    public String title;
    public ArrayList<ReviewController> reviews;
    
    public CourseController(String courseNumber, String title) {
        this.id = UUID.randomUUID();
        this.courseNumber = courseNumber;
        this.title = title;
        this.reviews = new ArrayList<ReviewController>();
    }
}

package backend.src.controllers;
import java.util.ArrayList;
import java.util.UUID;

public class Course {
    public UUID id;
    public String courseNumber;
    public String title;
    public ArrayList<Review> reviews;

    public Course(String title) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.reviews = new ArrayList<Review>();
    }

}

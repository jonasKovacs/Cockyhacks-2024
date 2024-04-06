package backend.app.src.main.java.com.myapp.model;
import java.util.ArrayList;
import java.util.UUID;
public class Course {
    public UUID id;
    public String courseNumber;
    public String title;
    public ArrayList<Review> reviews;
    
    public Course(String courseNumber, String title) {
        this.id = UUID.randomUUID();
        this.courseNumber = courseNumber;
        this.title = title;
        this.reviews = new ArrayList<Review>();
    }
}

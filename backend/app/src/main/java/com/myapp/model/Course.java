package backend.app.src.main.java.com.myapp.model;

public class Course {
    private Long id;
    private String title;
    private String description;
    private Integer creditHours;
    private List<Long> prerequisiteCourseIds; // A list of IDs for prerequisite courses

    // Constructors
    public Course() {}

    public Course(Long id, String title, String description, Integer creditHours, List<Long> prerequisiteCourseIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creditHours = creditHours;
        this.prerequisiteCourseIds = prerequisiteCourseIds;
    }
}

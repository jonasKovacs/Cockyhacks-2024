package com.myapp.model;
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
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void addReview(Review review) {
        this.reviews.add(review);
    }
    public void removeReview(UUID reviewId) {
        for (Review review : this.reviews) {
            if (review.id == reviewId) {
                this.reviews.remove(review);
                return;
            }
        }
    }
}

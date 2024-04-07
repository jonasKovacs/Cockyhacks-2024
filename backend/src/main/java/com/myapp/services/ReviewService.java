package com.myapp.services;
import com.myapp.model.*;
import java.util.UUID;
import java.util.ArrayList;

public class ReviewService {
    public ArrayList<Review> reviews;
    public UserService userService = UserService.getInstance();
    public CourseService courseService = CourseService.getInstance();
    public ReviewService(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ReviewService() {
        this.reviews = new ArrayList<Review>();
    }
    public ArrayList<Review> getAllReviews() {
        return this.reviews;
    }
    public Review createReview(Review review) {
        this.reviews.add(review);
        return review;
    }
    public Review getReviewById(UUID reviewId) {
        for (Review review : this.reviews) {
            if (review.id.equals(reviewId)) {
                return review;
            }
        }
        return null;
    }

    public ArrayList<Review> getAllReviewsByCourse(UUID courseId) {
        for (Course course : courseService.courses) {
            if (course.id.equals(courseId)) {
                return course.reviews;
            }
        }
        return null;
    }
  
    public ArrayList<Review> getAllReviewsByUser(UUID userId) {
        ArrayList<User> users = userService.users;
        for (User user : users) {
            if (user.id.equals(userId)) {
                return user.reviews;
            }
        }
        return null;
    }
  
    public Review updateReview(UUID reviewId, Review updatedReview) {
        for (Review review : this.reviews) {
            if (review.id.equals(reviewId)) {
                review.starRating = updatedReview.starRating;
                review.content = updatedReview.content;
                return review;
            }
        }
        return null;
    }

    public void deleteReview(UUID reviewId) {
        for (Review review : this.reviews) {
            if (review.id.equals(reviewId)) {
                this.reviews.remove(review);
                return;
            }
        }
    }
  

    public Double calculateAverageCourseRating(UUID courseId) {
        double totalRating = 0;
        int totalReviews = 0;
        for (Course course : courseService.courses) {
            if (course.id.equals(courseId)) {
                for (Review review : course.reviews) {
                    totalRating += review.starRating;
                    totalReviews++;
                }
            }
        }
        return totalRating / totalReviews;
    }
}

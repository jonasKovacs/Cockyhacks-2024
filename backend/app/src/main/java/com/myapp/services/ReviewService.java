package backend.app.src.main.java.com.myapp.services;
import backend.app.src.main.java.com.myapp.model.*;
import java.util.UUID;
import java.util.ArrayList;

public class ReviewService {
    public ArrayList<Review> reviews;

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
          return null;
    }
    public Review getReviewById(UUID reviewId) {
          return null;
    }
    public ArrayList<Review> getAllReviewsByCourse(UUID courseId) {
          return null;
    }
  
    public ArrayList<Review> getAllReviewsByUser(UUID userId) {
        return null;
    }
  
    public Review updateReview(UUID reviewId, Review updatedReview) {
        return null;
    }

    public void deleteReview(UUID reviewId) {

    }
  

    public Double calculateAverageCourseRating(UUID courseId) {
        return null;
    }
  

    public void reportReview(UUID reviewId) {

    }
}

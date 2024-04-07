package com.myapp.controllers;
import com.myapp.model.Review;
import com.myapp.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Get all reviews
    @GetMapping
    public ResponseEntity<ArrayList<Review>> getAllReviews() {
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    // Create a new review
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    // Get a review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable UUID id) {
        Review review = reviewService.getReviewById(id);
        return review != null ? new ResponseEntity<>(review, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update a review
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable UUID id, @RequestBody Review updatedReview) {
        Review review = reviewService.updateReview(id, updatedReview);
        return review != null ? new ResponseEntity<>(review, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a review
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable UUID id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get all reviews for a specific course
    @GetMapping("/course/{courseId}")
    public ResponseEntity<ArrayList<Review>> getAllReviewsByCourse(@PathVariable UUID courseId) {
        ArrayList<Review> reviews = reviewService.getAllReviewsByCourse(courseId);
        return reviews != null ? new ResponseEntity<>(reviews, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Get all reviews by a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<ArrayList<Review>> getAllReviewsByUser(@PathVariable UUID userId) {
        ArrayList<Review> reviews = reviewService.getAllReviewsByUser(userId);
        return reviews != null ? new ResponseEntity<>(reviews, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Calculate average course rating
    @GetMapping("/course/{courseId}/averageRating")
    public ResponseEntity<Double> calculateAverageCourseRating(@PathVariable UUID courseId) {
        Double averageRating = reviewService.calculateAverageCourseRating(courseId);
        return new ResponseEntity<>(averageRating, HttpStatus.OK);
    }
}
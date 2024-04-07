package com.myapp.controllers;

import com.myapp.model.Course;
import com.myapp.model.Review;
import com.myapp.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService = CourseService.getInstance();

    // Get all courses
    @GetMapping
    public ResponseEntity<ArrayList<Course>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    // Get a course by ID
    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable UUID courseId) {
        Course course = courseService.getCourseById(courseId);
        return course != null ? new ResponseEntity<>(course, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Create a new course
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    // Update an existing course
    @PutMapping("/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable UUID courseId, @RequestBody Course updatedCourse) {
        Course course = courseService.updateCourse(courseId, updatedCourse);
        return course != null ? new ResponseEntity<>(course, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a course
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable UUID courseId) {
        Course course = courseService.deleteCourse(courseId);
        return course != null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Add a review to a course
    @PostMapping("/{courseId}/reviews")
    public ResponseEntity<Void> addReviewToCourse(@PathVariable UUID courseId, @RequestBody Review review) {
        courseService.addReviewToCourse(courseId, review);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Remove a review from a course
    @DeleteMapping("/{courseId}/reviews/{reviewId}")
    public ResponseEntity<Void> removeReviewFromCourse(@PathVariable UUID courseId, @PathVariable UUID reviewId) {
        courseService.removeReviewFromCourse(courseId, reviewId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Example endpoint for sorting reviews of a course by rating in descending order
    @GetMapping("/{courseId}/reviews/sort/descending")
    public ResponseEntity<Void> sortReviewsByRatingDescending(@PathVariable UUID courseId) {
        courseService.sortReviewsByRatingDescending(courseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Add more endpoints as needed based on your CourseService methods
}

package backend.app.src.main.java.com.myapp.services;
import backend.app.src.main.java.com.myapp.model.*;
import java.util.ArrayList;
import java.util.UUID;
public class CourseService {
    private ArrayList<Course> courses;
    public CourseService() {
        this.courses = new ArrayList<Course>();
    }
    public CourseService(ArrayList<Course> courses) {
        this.courses = courses;
    }

/*getAllCourses()
getCourseById(Long courseId)
createCourse(Course course)
updateCourse(Long courseId, Course updatedCourse)
deleteCourse(Long courseId)*/

    public ArrayList<Course> getAllCourses() {
        return this.courses;
    }

    public Course getCourseById(UUID courseId) {
        for (Course course : this.courses) {
            if (course.id == courseId) {
                return course;
            }
        }
        return null;
    }

    public Course createCourse(Course course) {
        this.courses.add(course);
        return course;
    }

    public Course updateCourse(UUID courseId, Course updatedCourse) {
        for (Course course : this.courses) {
            if (course.id == courseId) {
                course.courseNumber = updatedCourse.courseNumber;
                course.title = updatedCourse.title;
                return course;
            }
        }
        return null;
    }

    public Course deleteCourse(UUID courseId) {
        for (Course course : this.courses) {
            if (course.id == courseId) {
                this.courses.remove(course);
                return course;
            }
        }
        return null;
    }
    public void sortReviewsByRatingDescending(UUID courseId) {
        for (Course course : this.courses) {
            if (course.id == courseId) {
                course.reviews.sort((r1, r2) -> Double.compare(r2.starRating, r1.starRating));
            }
        }
    }
    public void sortReviewsByratingAscending(UUID courseId) {
        for (Course course : this.courses) {
            if (course.id == courseId) {
                course.reviews.sort((r1, r2) -> Double.compare(r1.starRating, r2.starRating));
            }
        }
    }
    public void sortReviewsByDate(UUID courseId) {
        for (Course course : this.courses) {
            if (course.id == courseId) {
                course.reviews.sort((r1, r2) -> r1.datePosted.compareTo(r2.datePosted));
            }
        }
    }

    public void addReviewToCourse(UUID courseId, Review review) {
        for (Course course : this.courses) {
            if (course.id == courseId) {
                course.reviews.add(review);
            }
        }
    }

    public void removeReviewFromCourse(UUID courseId, UUID reviewId) {
        for (Course course : this.courses) {
            if (course.id == courseId) {
                course.removeReview(reviewId);
            }
        }
    }
}

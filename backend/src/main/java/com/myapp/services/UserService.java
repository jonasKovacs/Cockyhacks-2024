package com.myapp.services;
import com.myapp.model.*;
import java.util.UUID;
import java.util.ArrayList;

public class UserService {

     public ArrayList<User> users;
     private static UserService instance;

     public UserService(ArrayList<User> users) {
          this.users = users;

     }

     public static UserService getInstance() {
          if (instance == null) {
               instance = new UserService(new ArrayList<User>());
          }
          return instance;
     }

    public void reportReview(UUID reviewId) {

    }
     public UserService() {
          this.users = new ArrayList<User>();
     }
     public void registerUser(User user) {
          this.users.add(user);
     }
     public User authenticateUser(String email, String password) {
          for (User user : this.users) {
               if (user.email.equals(email) && user.password.equals(password)) {
                    return user;
               }
          }
          return null;
     }
     public User getUserById(UUID id) {
          for (User user : this.users) {
               if (user.id.equals(id)) {
                    return user;
               }
          }
          return null;
     }
     public User updateUser(UUID id, User updatedUser) {
          for (User user : this.users) {
               if (user.id.equals(id)) {
                    user.username = updatedUser.username;
                    user.password = updatedUser.password;
                    user.email = updatedUser.email;
                    user.role = updatedUser.role;
                    return user;
               }
          }
          return null;
     }
     public ArrayList<Review> getUserReviews(UUID userId) {
          for (User user : this.users) {
               if (user.id == userId) {
                    return user.reviews;
               }
          }
          return null;
     }
     public ArrayList<User> getAllUsers() {
          return this.users;
     }

}

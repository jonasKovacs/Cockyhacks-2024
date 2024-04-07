package backend.src.main.java.com.myapp.services;
import backend.src.main.java.com.myapp.model.*;
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

     /*
registerUser(UserDto userDto): Registers a new user.
authenticateUser(String email, String password): Validates user credentials and handles login.
getUserById(Long userId): Retrieves user details.
updateUser(Long userId, UserDto updatedUser): Updates user profile information.
changeUserPassword(Long userId, String newPassword): Changes the user's password.
resetUserPassword(String email): Initiates a password reset process.
assignRoleToUser(Long userId, Role role): Assigns a role to the user (optional).
getUserReviews(Long userId): Retrieves all reviews made by the user (can be part of the ReviewService or UserService depending on how you want to structure it).
*/
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

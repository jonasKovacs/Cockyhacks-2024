package backend.app.src.main.java.com.myapp.controllers;
import java.util.UUID;
import java.util.ArrayList;

public class UserController {
    public UUID id;
    public String username;
    public String password;
    public String email;
    public Role role;
    public ArrayList<UUID> reviews;

    public UserController(String username, String password, String email, Role role) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.reviews = new ArrayList<UUID>();
    }
}

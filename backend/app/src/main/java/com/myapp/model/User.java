package backend.app.src.main.java.com.myapp.model;
import java.util.UUID;
import java.util.ArrayList;

public class User {
    public UUID id;
    public String username;
    public String password;
    public String email;
    public Role role;
    public ArrayList<UUID> reviews;

    public User(String username, String password, String email, Role role) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.reviews = new ArrayList<UUID>();
}

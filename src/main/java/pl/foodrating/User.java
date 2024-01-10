package pl.foodrating;

public class User {
    private static int nextId = 1;

    private int id;
    private String username;

    // Constructor
    public User(String username) {
        this.id = nextId++;
        this.username = username;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

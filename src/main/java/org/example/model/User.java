package org.example.model;

public class User {
    private final int id;
    private final String username;
    private final String role;
    private final String status;

    public User(int id, String username, String role, String status) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.status = status;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getRole() { return role; }
    public String getStatus() { return status; }
}
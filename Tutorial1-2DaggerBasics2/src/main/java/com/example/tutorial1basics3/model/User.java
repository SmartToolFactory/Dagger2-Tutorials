package com.example.tutorial1basics3.model;

public class User {

    private String name;

    private String email;

    public User() {
        name = "Unknown";
        email = "abc@xyz.com";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}



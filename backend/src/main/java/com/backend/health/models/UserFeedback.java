package com.backend.health.models;

public class UserFeedback {
    private String username;
    private String feedback;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public UserFeedback(String username, String feedback) {
        this.username = username;
        this.feedback = feedback;
    }

    
}
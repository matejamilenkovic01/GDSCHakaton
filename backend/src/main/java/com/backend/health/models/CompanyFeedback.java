package com.backend.health.models;

public class CompanyFeedback {
    private String name;
    private String feedback;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFeedback() {
        return feedback;
    }
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    public CompanyFeedback(String name, String feedback) {
        this.name = name;
        this.feedback = feedback;
    }
    
}
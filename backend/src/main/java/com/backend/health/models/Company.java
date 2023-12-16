package com.backend.health.models;

import java.sql.Blob;

public class Company {
    private String name;
    private String password;
    private String description;
    private Blob logo;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Blob getLogo() {
        return logo;
    }
    public void setLogo(Blob logo) {
        this.logo = logo;
    }
    public Company(String name, String password, String description, Blob logo) {
        this.name = name;
        this.password = password;
        this.description = description;
        this.logo = logo;
    }

    
}
package com.backend.health.models;

import java.sql.Blob;

public class Promotion {
    private int idR;
    private String name;
    private String description;
    private String company;
    private int points;
    private Blob photo;
    private int approved;
    private int active;
    public int getIdR() {
        return idR;
    }
    public void setIdR(int idR) {
        this.idR = idR;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public Blob getPhoto() {
        return photo;
    }
    public void setPhoto(Blob photo) {
        this.photo = photo;
    }
    public int getApproved() {
        return approved;
    }
    public void setApproved(int approved) {
        this.approved = approved;
    }
    public int getActive() {
        return active;
    }
    public void setActive(int active) {
        this.active = active;
    }
    public Promotion(int idR, String name, String description, String company, int points, Blob photo, int approved,
            int active) {
        this.idR = idR;
        this.name = name;
        this.description = description;
        this.company = company;
        this.points = points;
        this.photo = photo;
        this.approved = approved;
        this.active = active;
    }
}
package com.backend.health.models;

public class User {
    private String username;
    private String password;
    private String name;
    private String email;
    private Integer balance;
    
    public User(String username, String password, String name, String mail, Integer balance) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = mail;
        this.balance = balance;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    public Integer getBalance() {
        return balance;
    }
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    
}

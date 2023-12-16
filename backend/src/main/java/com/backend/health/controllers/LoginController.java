package com.backend.health.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.health.db.DB;
import com.backend.health.models.Admin;
import com.backend.health.models.Company;
import com.backend.health.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/login")
public class LoginController {
    
    
    @GetMapping("/getUser")
    public User getUser(@RequestParam String username, 
    @RequestParam String password) {

        try {
            Connection conn = DB.source().getConnection();
            String query = "select * from user where username=? and password=?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, username);
            stm.setString(2, password);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new User(username, password, rs.getString("name"),
                rs.getString("email"), rs.getInt("balance"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/getAdmin")
    public Admin getAdmin(@RequestParam String username, 
    @RequestParam String password) {

        try {
            Connection conn = DB.source().getConnection();
            String query = "select * from admin where username=? and password=?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, username);
            stm.setString(2, password);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new Admin(username, password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("/getCompany")
    public Company getCompany(@RequestParam String name, 
    @RequestParam String password) {

        try {
            Connection conn = DB.source().getConnection();
            String query = "select * from company where name=? and password=?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, name);
            stm.setString(2, password);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return new Company(name, password, rs.getString("description"),
                 rs.getBlob("logo"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PostMapping("/postUser")
    public int postUser(@RequestBody User user) {
        try{
            Connection conn = DB.source().getConnection();
            String query = "insert into user(username, password, name, email, balance) values(?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, user.getUsername());
            stm.setString(2, user.getPassword());
            stm.setString(3, user.getName());
            stm.setString(4, user.getEmail());
            stm.setInt(5, user.getBalance());

            return stm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @PostMapping("/postCompany")
    public int postCompany(@RequestBody Company company) {
        try{
            Connection conn = DB.source().getConnection();
            String query = "insert into company(name, password, description, logo) values(?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, company.getName());
            stm.setString(2, company.getPassword());
            stm.setString(3, company.getDescription());
            stm.setBlob(4, company.getLogo());

            return stm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
package com.backend.health.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.health.db.DB;
import com.backend.health.models.Company;
import com.backend.health.models.Coupon;
import com.backend.health.models.Promotion;
import com.backend.health.models.Reward;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getCompanies")
    public ArrayList<Company> getCompanies() {

        ArrayList<Company> companies = new ArrayList<>();

        try {
            Connection conn = DB.source().getConnection();
            String query = "select * from company";
            PreparedStatement stm = conn.prepareStatement(query);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                companies.add(new Company(rs.getString("name"), 
                rs.getString("password"), rs.getString("description"),
                rs.getBlob("logo")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return companies;
    }

    @GetMapping("/getCompanyPromotions")
    public ArrayList<Promotion> getCompanyPromotions(@RequestParam Company c) {

        ArrayList<Promotion> promotions = new ArrayList<>();

        try {
            Connection conn = DB.source().getConnection();
            String query = "";
            ResultSet rs;
            if (c != null) {
                query = "select * from promotion where company=?";
                PreparedStatement stm = conn.prepareStatement(query);
                stm.setString(1, c.getName());
                rs = stm.executeQuery();
                
            } else {
                query = "select * from promotion";
                PreparedStatement stm = conn.prepareStatement(query);
                rs = stm.executeQuery();
            }
            while (rs.next()) {
                promotions.add(new Promotion(rs.getInt("idP"),
                rs.getString("name"), 
                rs.getString("description"), 
                rs.getString("company"),
                rs.getInt("points"),
                rs.getBlob("photo"),
                rs.getInt("approved"),
                rs.getInt("active")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return promotions;
    }

    @GetMapping("/getCompanyRewards")
    public ArrayList<Reward> getCompanyRewards(@RequestParam Company c) {

        ArrayList<Reward> rewards = new ArrayList<>();

        try {
            Connection conn = DB.source().getConnection();
            String query = "";
            ResultSet rs;
            if (c != null) {
                query = "select * from reward where company=?";
                PreparedStatement stm = conn.prepareStatement(query);
                stm.setString(1, c.getName());
                rs = stm.executeQuery();
                
            } else {
                query = "select * from reward";
                PreparedStatement stm = conn.prepareStatement(query);
                rs = stm.executeQuery();
            }
            while (rs.next()) {
                rewards.add(new Reward(rs.getInt("idP"),
                rs.getString("name"), 
                rs.getString("description"), 
                rs.getString("company"),
                rs.getInt("points"),
                rs.getBlob("photo"),
                rs.getInt("approved"),
                rs.getInt("active")));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return rewards;
    }

    @GetMapping("/createCoupon")
    public int createCoupon(@RequestParam String username, @RequestParam int idR) {
        
        try{
            Connection conn = DB.source().getConnection();

            String query1 = "select * from reward where idR=?";
            PreparedStatement stm1 = conn.prepareStatement(query1);
            stm1.setInt(1, idR);
            ResultSet rs1 = stm1.executeQuery();
            if (rs1.next()) {
                int isActive = rs1.getInt("active");
                if (isActive == 0) return -1;

                String query2 = "select * from user where username=?";
                PreparedStatement stm2 = conn.prepareStatement(query2);
                stm2.setString(1, username);
                ResultSet rs2 = stm2.executeQuery();
                if (rs2.next()) {
                    if (rs2.getInt("balance") < 
                    rs1.getInt("points")) return -2;
                    
                    String query3 = "update user set balance=? where username=?";
                    PreparedStatement stm3 = conn.prepareStatement(query3);
                    stm3.setInt(1, rs2.getInt("balance") - rs1.getInt("points"));
                    stm3.setString(2, username);

                    stm3.executeUpdate();
                    String query = "insert into coupon(username, reward, used,code) values(?,?, ?, ?)";
                    PreparedStatement stm = conn.prepareStatement(query);
                    stm.setString(1, username);
                    stm.setInt(2, idR);
                    stm.setInt(3, 0);
                    stm.setInt(4, Coupon.staticCode++);
                    return stm.executeUpdate();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }




}

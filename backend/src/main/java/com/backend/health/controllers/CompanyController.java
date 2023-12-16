package com.backend.health.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.backend.health.db.DB;
import com.backend.health.models.Promotion;
import com.backend.health.models.Reward;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/company")
public class CompanyController {
    
    @PostMapping("/postReward")
    public int postReward(@RequestBody Reward reward) {
        try{
            Connection conn = DB.source().getConnection();
            String query = "insert into reward(name, description, company, points, photo, approved, active) values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, reward.getName());
            stm.setString(2, reward.getDescription());
            stm.setString(3, reward.getCompany());
            stm.setInt(4, reward.getPoints());
            stm.setBlob(5, reward.getPhoto());
            stm.setInt(6, 0);
            stm.setInt(7, 1);
            return stm.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    @PostMapping("/postPromotion")
    public int postPromotion(@RequestBody Promotion promotion) {
        try{
            Connection conn = DB.source().getConnection();
            String query = "insert into reward(name, description, company, points, photo, approved, active) values(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, promotion.getName());
            stm.setString(2, promotion.getDescription());
            stm.setString(3, promotion.getCompany());
            stm.setInt(4, promotion.getPoints());
            stm.setBlob(5, promotion.getPhoto());
            stm.setInt(6, 0);
            stm.setInt(7, 1);
            return stm.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
}

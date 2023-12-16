package com.backend.health.models;

public class Coupon {

    private int idC;
    private String username;
    private int reward;
    private int used;
    private int code;

    public static int staticCode = 0;

    public Coupon(int idC, String username, int reward, int used, int code) {
        this.idC = idC;
        this.username = username;
        this.reward = reward;
        this.used = used;
        this.code = code;
    }

    public int getIdC() {
        return idC;
    }
    public void setIdC(int idC) {
        this.idC = idC;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public int getReward() {
        return reward;
    }
    public void setReward(int reward) {
        this.reward = reward;
    }
    public int getUsed() {
        return used;
    }
    public void setUsed(int used) {
        this.used = used;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    



}
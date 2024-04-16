package com.Mafunzo.Mafunzo.Model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String fname;
    private String lname;
    private String email;
    private String password;
    private XpSystem xpSystem;
    private List<User> friends;
    private List<Activities> activitiesList;

    public User(){

    }

    public User(XpSystem xpSystem, String fname, String lname, String email, String password) {
        this.xpSystem = xpSystem;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.activitiesList = new ArrayList<>();
        this.friends = new ArrayList<>();
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Activities> getActivitiesList() {
        return activitiesList;
    }
}

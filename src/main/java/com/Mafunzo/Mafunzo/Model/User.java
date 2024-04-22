package com.Mafunzo.Mafunzo.Model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document("User")
public class User implements Serializable {
    private String fname;
    private String lname;
    private int evaluationScore;
    @Id
    private String email;
    @Id
    private String password;
    private XpSystem xp;
    private List<User> friends;
    private List<Activities> activitiesList;


    public User(XpSystem xp, String fname, String lname, String email, String password, int evaluationScore) {
            this.xp = new XpSystem(0,1,0,0,100);
            this.fname = fname;
            this.lname = lname;
            this.email = email;
            this.password = password;
            this.activitiesList = new ArrayList<>();
            this.friends = new ArrayList<>();
            this.evaluationScore = evaluationScore;
    }

    public User() {
    }

        //TOOD: koppla ett user objekt till profilsida.
        public String getFname () {
            return fname;
        }
        public void setFname (String fname){
            this.fname = fname;
        }
        public String getLname () {
            return lname;
        }
        public String getName () {
            return fname + " " + lname;
        }
        public void setLname (String lname){
            this.lname = lname;
        }
        public String getEmail () {
            return email;
        }
        public void setEmail (String email){
            this.email = email;
        }
        public String getPassword () {
            return password;
        }
        public void setPassword (String password){
            this.password = password;
        }

        public int getEvaluationScore () {
            return evaluationScore;
        }

    public double getXp() {
        if (this.xp == null) {
            return 0;
        }
        return xp.getXp();
        }
        public int getLvl() {
            if (this.xp == null) {
                return 1;
            }
            return xp.getLvl();
        }

        public void setXp(XpSystem xp) {
            this.xp = xp;
        }

        public List<Activities> getActivitiesList() {
        return activitiesList;
    }

        public int getStreak() {
            if (this.xp == null) {
                return 0;
            }
            return xp.getStreak();
        }
        public double getXpToLevel() {
            if (this.xp == null) {
                return 100;
            }
            return xp.getXpToLevel();
        }
}


package com.Mafunzo.Mafunzo.Model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User is a class that represents a user.
 *
 * @author Kevin Nordkvist, William Starå, Adam Mheisen, Kasper Svenlin och Isak Hakola
 */
@Document("User")
public class User implements Serializable {
    @Id
    private String id;
    private String fname;
    private String lname;
    private int evaluationScore;
    @Indexed(unique = true)
    private String email;
    private String password;
    private XpHandler xpHandler;
    private List<User> follower;
    private List<User> following;
    private List<Activities> activitiesList;
    private String image;
    private boolean streakIsUpdated;



    public User(XpHandler xpHandler, String fname, String lname, String email, String password, int evaluationScore, String image) {
        this.xpHandler = new XpHandler(0, 1, 0, 0, 100);
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.activitiesList = new ArrayList<>();
        this.follower = new ArrayList<>();
        this.following = new ArrayList<>();
        this.evaluationScore = evaluationScore;
        this.image = image;
        this.streakIsUpdated = false;
    }

    public User() {
    }

    public String getName() {
        return fname + " " + lname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getEvaluationScore() {
        return evaluationScore;
    }

    public XpHandler getXpSystem() {
        if (this.xpHandler == null) {
            return new XpHandler(0, 1, 0, 0, 100);
        }
        return xpHandler;
    }

    public int getLvl() {
        if (this.xpHandler == null) {
            return 1;
        }
        return xpHandler.getLvl();
    }

    public List<Activities> getActivitiesList() {
        if (this.activitiesList == null) {
            return new ArrayList<>();
        }
        return activitiesList;
    }
    public List<Activities> displayActivitesReverse(){
        if (this.activitiesList == null) {
            return new ArrayList<>();
        }
        List<Activities> tempActivities = new ArrayList<>();
        for (int i = activitiesList.size()-1; i > 0; i--) {
            tempActivities.add(activitiesList.get(i));

        }
        return tempActivities;
    }

    public List<User> getFollower(){
        if (this.follower == null) {
            return new ArrayList<>();
        }
        return follower;
    }

    public List<User> getFollowing(){
        if (this.following == null) {
            return new ArrayList<>();
        }
        return following;
    }

    public int getStreak() {
        if (this.xpHandler == null) {
            return 0;
        }
        return xpHandler.getStreak();
    }

    public double getXpToLevel() {
        if (this.xpHandler == null) {
            return 100;
        }
        return xpHandler.getXpToLevel();
    }

    public void setStreakIsUpdated(boolean streakIsUpdated) {
        this.streakIsUpdated = streakIsUpdated;
    }

    public boolean getStreakIsUpdated(){
        return  streakIsUpdated;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}


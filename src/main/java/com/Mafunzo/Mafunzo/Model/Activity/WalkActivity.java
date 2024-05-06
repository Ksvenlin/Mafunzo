package com.Mafunzo.Mafunzo.Model.Activity;

import com.Mafunzo.Mafunzo.Model.Activities;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Class that represents a walk activity
 *
 * @author Isak Hakola & Kasper Svenlin
 */

public class WalkActivity implements Activities {

    private String description;
    private double duration;
    private double distance;
    private String caption;
    private  LocalDateTime timeStamp;




    public WalkActivity() {
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return "Promenad";
    }

    public double getDuration() {
        return duration;
    }

    public double getDistance() {
        return distance;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String printInfo() {
        return "Aktivitet: " + getName() + "\n" + "Beskrivning: " + getDescription() +
                "\n" + "Tid: " + getDuration() + " minuter" + "\n" + "Distans: " + getDistance() + " km";
    }
}

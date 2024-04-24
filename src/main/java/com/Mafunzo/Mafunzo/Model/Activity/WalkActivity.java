package com.Mafunzo.Mafunzo.Model.Activity;

import com.Mafunzo.Mafunzo.Model.Activities;

import java.time.Duration;
import java.time.LocalDateTime;

public class WalkActivity implements Activities {

    private String description;
    private double duration;
    private double distance;


    public WalkActivity(){
        this.description = "Min första promenad!";

    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String getDescpriction() {
        return "Min första promenad!";
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

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String printInfo(){
        return "Aktivitet: " + getName() + "\n" + "Beskrivning: " + getDescpriction() +
                "\n" + "Tid: " + getDuration() + " minuter" + "\n" + "Distans: " + getDistance() + " km";
    }
}

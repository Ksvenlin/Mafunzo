package com.Mafunzo.Mafunzo.Model.Activity;

import com.Mafunzo.Mafunzo.Model.Activities;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Class that represents a bike activity
 *
 * @author Isak Hakola & Kasper Svenlin
 */
public class BikeActivity implements Activities {

    private String description;
    private double duration;
    private double distance;


    public BikeActivity() {
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
        return "Cykling";
    }

    public double getDuration() {
        return duration;
    }

    public double getDistance() {
        return distance;
    }


    @Override
    public String printInfo() {
        return "Aktivitet: " + getName() + "\n" + "Beskrivning: " + getDescription() +
                "\n" + "Tid: " + getDuration() + " minuter" + "\n" + "Distans: " + getDistance() + " km";
    }
}

package com.Mafunzo.Mafunzo.Model.Activity;

import com.Mafunzo.Mafunzo.Model.Activities;
import com.Mafunzo.Mafunzo.Model.Day;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Class that represents a walk activity
 *
 * @author Isak Hakola, Kasper Svenlin & Kevin Nordkvist
 */

public class WalkActivity implements Activities {

    private String description;
    private double duration;
    private double distance;
    private String caption;
    private Day timeStamp;




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
        return "Walk";
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

    public Day getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Day timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public List<Exercise> getExerciseList() {
        return null;
    }

    @Override
    public String printInfo() {
        return timeStamp.getDay().toString() + " «» " + getName() + " «» Duration: " + getDuration() + " min «» Distance: " + getDistance() + " km";

    }
}

package com.Mafunzo.Mafunzo.Model.Activity;


import com.Mafunzo.Mafunzo.Model.Activities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * StrengthActivity is a class that represents a strength activity.
 *
 * @author Kevin Nordkvist & Kasper Svenlin
 */
public class StrengthActivity implements Activities {
    private List<Exercise> exerciseList;
    private double duration;
    private String description;
    private String caption;
    private LocalDateTime timeStamp;



    public StrengthActivity() {
        exerciseList = new ArrayList<>();
        Exercise temp = new Exercise();
        temp.setExerciseNumber(exerciseList.size() + 1);
        exerciseList.add(temp);
    }
    

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    @Override
    public String getName() {
        return "Styrketräning";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double getDuration() {
        return duration;
    }

    @Override
    public void setDuration(double duration) {
        this.duration = duration;
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
                "\n" + "Tid: " + getDuration() + " minuter";
    }
}

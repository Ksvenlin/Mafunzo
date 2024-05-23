package com.Mafunzo.Mafunzo.Model.Activity;

import com.Mafunzo.Mafunzo.Model.Activities;
import com.Mafunzo.Mafunzo.Model.Day;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Class that represents an "other" activity
 *
 * @author Kevin Nordkvist & Kasper Svenlin
 */

public class OtherActivity implements Activities {

    private String description;
    private double duration;
    private String caption;
    private Day timeStamp;

    public OtherActivity() {
    }

    public void setDuration(double duration) {
        this.duration = duration;
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
        return "Övrig";
    }

    public double getDuration() {
        return duration;
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
        return "Aktivitet: " + getName() + "\n" + "Beskrivning: " + getDescription() +
                "\n" + "Tid: " + getDuration() + " minuter" + "\n";
    }
}

package com.Mafunzo.Mafunzo.Model.Activity;

import com.Mafunzo.Mafunzo.Model.Activities;
import com.Mafunzo.Mafunzo.Model.Day;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * YogaActivity is a class that represents a yoga activity.
 *
 * @author Isak Hakola, Kasper Svenlin & Kevin Nordkvist
 */

public class YogaActivity implements Activities {

    private String description;
    private double duration;
    private List<Exercise> exerciseList;
    private String caption;
    private Day timeStamp;





    public YogaActivity() {
        exerciseList = new ArrayList<>();
        Exercise temp = new Exercise();
        temp.setExerciseNumber(exerciseList.size() + 1);
        exerciseList.add(temp);
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
        return "Yoga";
    }

    public double getDuration() {
        return duration;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
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
    public String printInfo() {
        return timeStamp.getDay().toString() + " «» " + getName() + " «» Duration: " + getDuration() + " Exercise: " + exerciseList.size();

    }
}

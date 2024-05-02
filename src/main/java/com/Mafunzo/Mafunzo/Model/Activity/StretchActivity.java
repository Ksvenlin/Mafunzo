package com.Mafunzo.Mafunzo.Model.Activity;

import com.Mafunzo.Mafunzo.Model.Activities;

import java.util.ArrayList;
import java.util.List;

public class StretchActivity implements Activities {

    private String description;
    private double duration;

    private List<Exercise> exerciseList;

    public StretchActivity(){
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
        return "Stretching";
    }

    public double getDuration() {
        return duration;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    @Override
    public String printInfo(){
        return "Aktivitet: " + getName() + "\n" + "Beskrivning: " + getDescription() +
                "\n" + "Tid: " + getDuration() + " minuter";
    }
}

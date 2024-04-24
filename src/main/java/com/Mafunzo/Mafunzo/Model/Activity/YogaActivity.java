package com.Mafunzo.Mafunzo.Model.Activity;

import com.Mafunzo.Mafunzo.Model.Activities;

public class YogaActivity implements Activities {

    private String description;
    private double duration;



    public YogaActivity(){
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




    @Override
    public String printInfo(){
        return "Aktivitet: " + getName() + "\n" + "Beskrivning: " + getDescription() +
                "\n" + "Tid: " + getDuration() + " minuter";
    }
}

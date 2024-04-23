package com.Mafunzo.Mafunzo.Model.Activity;

import com.Mafunzo.Mafunzo.Model.Activities;

public class SwimActivity implements Activities {

    private double duration;
    private double distance;


    public SwimActivity(){

    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String getDescpriction() {
        return "Min första simtur!";
    }

    @Override
    public String getName() {
        return "Simning";
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
}

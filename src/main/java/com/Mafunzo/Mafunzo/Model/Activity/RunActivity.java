package com.Mafunzo.Mafunzo.Model.Activity;

import com.Mafunzo.Mafunzo.Model.Activities;

public class RunActivity implements Activities {

    private double duration;
    private double distance;


    public RunActivity(){

    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String getDescpriction() {
        return "Min första löprunda!";
    }

    @Override
    public String getName() {
        return "Löpning";
    }

    public double getDuration() {
        return duration;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String printInfo() {
        return null;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}

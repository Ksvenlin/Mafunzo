package com.Mafunzo.Mafunzo.Model.Activity;

import com.Mafunzo.Mafunzo.Model.Activities;

public class BikeActivity implements Activities {

    private double duration;
    private double distance;


    public BikeActivity(){

    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String getDescpriction() {
        return "Min första cykeltur!";
    }

    @Override
    public String getName() {
        return "Bike Activity";
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

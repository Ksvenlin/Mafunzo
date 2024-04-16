package com.Mafunzo.Mafunzo.Model;

import java.time.Duration;
import java.time.LocalDateTime;

public class WalkActivity implements  Activities{

    private double duration;
    private double distance;


    public WalkActivity(){

    }

    public void setDuration(double duration) {
        this.duration = duration;
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

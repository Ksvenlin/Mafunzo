package com.Mafunzo.Mafunzo.Model;

import com.Mafunzo.Mafunzo.Model.Activity.Exercise;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface for activities
 *
 * @author Kevin Nordkvist, Kasper Svenlin, Adam Mheisen & Isak Hakola
 */
public interface Activities {

    String getName();

    String getDescription();

    void setDescription(String description);

    double getDuration();

    void setDuration(double duration);

    LocalDateTime getTimeStamp();

    String printInfo();

    void setTimeStamp(LocalDateTime timeStamp);

    List<Exercise> getExerciseList();

}

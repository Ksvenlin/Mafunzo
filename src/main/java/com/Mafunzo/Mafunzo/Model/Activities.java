package com.Mafunzo.Mafunzo.Model;

import java.time.LocalDateTime;

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

}

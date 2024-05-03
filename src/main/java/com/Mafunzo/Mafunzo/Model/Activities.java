package com.Mafunzo.Mafunzo.Model;

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

    String printInfo();

}

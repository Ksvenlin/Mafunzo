package com.Mafunzo.Mafunzo.Model;

import java.time.LocalDate;

/**
 * Class which represents a date stored in the database.
 * The date is later used to compare with the date of acitivties to see if the user has been inactive or not
 *
 * @Author William Starå
 */

public class Day {
    private LocalDate day;
    private int id;

    public Day(LocalDate day, int id) {
        this.id = id;
        this.day = day;
    }

    public LocalDate getDay() {
        return day;
    }

    public Day setDay(LocalDate day) {
        this.day = day;
        return this;
    }
}

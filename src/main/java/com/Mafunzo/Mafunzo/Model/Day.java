package com.Mafunzo.Mafunzo.Model;

import java.time.LocalDate;
import java.util.Date;

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

package com.Mafunzo.Mafunzo.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class DayService {
    @Autowired
    DayRepo dayRepo;

    @Transactional
    public Day makeDate () {
        ZonedDateTime cestDate = ZonedDateTime.now(ZoneId.of("CET"));
        LocalDate localDate = cestDate.toLocalDate();
        Day d = new Day(localDate, 1);
        return dayRepo.save(d);
    }

    public Day getDay() {
        return dayRepo.findAll().get(0);
    }

    @Transactional
    public Day updateDate() {
        Day current = getDay();
        current.setDay(this.getDay().getDay().plusDays(1));
        return dayRepo.save(current);
    }
}
package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dayHandler {
    @Autowired
    DayService dayService;

    @PostMapping("/createNewDay")
    public void makeDate() {
        dayService.makeDate();
    }

    @PostMapping("/updateDay")
    public void updateDate() {
        dayService.updateDate();
    }
}

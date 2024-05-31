package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The dayHandler class is a RestController that handles the operations
 * related to the day object stored in the database.
 * it uses the DayService class to interact with the database
 * and the TimeHandler class to check for inactive days.
 * @author William stara, Adam Mheisen, Kasper Svenlin, Isak hakola & Kevin Nordkvist
 */

@RestController
public class dayHandler {
    @Autowired
    DayService dayService;
    @Autowired
    TimeHandler handler;

    /**
     * This method updates the date in the database.
     * It also checks for inactive days for all users.
     */
    @PostMapping("/updateDay")
    public void updateDate() {
        dayService.updateDate();
        handler.checkInactiveDaysForAllUsers();
    }
}

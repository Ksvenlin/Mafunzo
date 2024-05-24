package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * This class is responsible for checking the inactive days of all users and updating their streaks accordingly.
 */

@Component
public class TimeHandler {
    @Autowired
    private UserService userService;

    /**
     * Default constructor for TimeHandler.
     */
    public TimeHandler() {}

    /**
     * This method checks the inactive days of all users and updates their streaks accordingly.
     * If a user has been inactive for 3 days or more, their streak will be reset to 0.
     * @author Kasper Svenlin, Adam Mheisen & William Starå
     */
    public void checkInactiveDaysForAllUsers() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            XpHandler xpHandler = user.getXpSystem();
            if (!user.getStreakIsUpdated()) {
                xpHandler.setInactiveDays(xpHandler.getInactiveDays() + 1);
            }
            int inactiveDays = xpHandler.getInactiveDays();
            if (inactiveDays >= 3) {
                xpHandler.setStreak(0);
            }
            user.setStreakIsUpdated(false);
            userService.saveUser(user);

        }
    }
}
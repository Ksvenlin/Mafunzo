package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class TimeHandler {
    @Autowired
    private UserService userService;

    public TimeHandler() {
    }

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
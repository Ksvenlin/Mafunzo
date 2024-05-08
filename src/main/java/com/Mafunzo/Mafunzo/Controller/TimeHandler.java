package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.User;
import com.Mafunzo.Mafunzo.Model.UserService;
import com.Mafunzo.Mafunzo.Model.XpSystem;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class TimeHandler {
    @Autowired
    UserService userService;

    public TimeHandler() {
    }

    @PostConstruct
    public void initialize() {
        dailyStreakCheck();
    }

    public void dailyStreakCheck() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                checkInactiveDaysForAllUsers();
            }
        };
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 45);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date firstTime = calendar.getTime();
        if (firstTime.before(new Date())) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            firstTime = calendar.getTime();
        }

        long period = 24 * 60 * 60 * 1000;
        timer.scheduleAtFixedRate(timerTask, firstTime, period);
    }

    public void checkInactiveDaysForAllUsers() {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            XpSystem xpSystem = user.getXpSystem();
            if (!user.getStreakIsUpdated()) {
                xpSystem.setInactiveDays(xpSystem.getInactiveDays() + 1);
            }
            int inactiveDays = xpSystem.getInactiveDays();
            if (inactiveDays >= 3) {
                xpSystem.setStreak(0);
            }
            user.setStreakIsUpdated(false);
        }
    }
}
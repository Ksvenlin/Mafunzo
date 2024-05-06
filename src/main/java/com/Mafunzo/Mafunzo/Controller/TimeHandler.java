package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.*;
import java.util.*;

public class TimeHandler {
    private UserService userService;
    private User user;

    public TimeHandler(UserService userService) {
        this.userService = userService;
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
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        long period = 24 * 60 * 60 * 1000;
        timer.schedule(timerTask, calendar.getTime(), period);
    }

    public void checkInactiveDaysForAllUsers(){
        List<User> users = userService.getAllUsers();
        for(User user: users){
            if(!user.getStreakIsUpdated()){
                user.getXpSystem().setInactiveDays(user.getXpSystem().getInactiveDays() + 1);
            }
            XpSystem xpSystem = user.getXpSystem();
            int inactiveDays = xpSystem.getInactiveDays();
            if(inactiveDays >= 3){
                xpSystem.setStreak(0);
            }
            user.setStreakIsUpdated(false);
        }
    }
}

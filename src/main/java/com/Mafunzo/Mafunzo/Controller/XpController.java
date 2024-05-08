package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activities;
import com.Mafunzo.Mafunzo.Model.User;

import java.time.Clock;
import java.time.LocalDate;

public class XpController {

    public double calculateXPIncrease(User user) {
        int streak = user.getXpSystem().getStreak();
        double baseMultiplier = 10;

        if (streak == 14) {
            baseMultiplier = (7 * streak) + 2;
        } else if (streak >= 1 && streak <= 6) {
            baseMultiplier = (7 * streak);
        } else if (streak >= 7 && streak <= 13) {
            baseMultiplier = (streak) + 2;
        } else if (streak > 14) {
            baseMultiplier = 200;
        }
        if (streak == 0) {
            return 10;
        }
        return ((10 * baseMultiplier) / 100) + 10;
    }

    public User calculateUserEvaluationXpGain(User user) {
        if (user.getEvaluationScore() <= 8) {
            if (checkDailyDuration(user) >= 30 && !user.getStreakIsUpdated()) {
                double xpIncrease = calculateXPIncrease(user);
                user.getXpSystem().setXp(user.getXpSystem().getXp() + xpIncrease);
                user.setStreakIsUpdated(true);
                user.getXpSystem().setStreak(user.getXpSystem().getStreak() + 1);
            }
        }
        if (user.getEvaluationScore() >= 9 && user.getEvaluationScore() <= 16) {
            if (checkDailyDuration(user) >= 45 && !user.getStreakIsUpdated()) {
                double xpIncrease = calculateXPIncrease(user);
                user.getXpSystem().setXp(user.getXpSystem().getXp() + xpIncrease);
                user.setStreakIsUpdated(true);
                user.getXpSystem().setStreak(user.getXpSystem().getStreak() + 1);
            }
        }
        if (user.getEvaluationScore() >= 17 && user.getEvaluationScore() <= 20) {
            if (checkDailyDuration(user) >= 60 && !user.getStreakIsUpdated()) {
                double xpIncrease = calculateXPIncrease(user);
                user.getXpSystem().setXp(user.getXpSystem().getXp() + xpIncrease);
                user.setStreakIsUpdated(true);
                user.getXpSystem().setStreak(user.getXpSystem().getStreak() + 1);
            }
        }
        return user;
    }


    public double checkDailyDuration(User user) {
        double totalDailyDuration = 0;
        LocalDate todaysDate = LocalDate.now(Clock.systemDefaultZone());
        for (Activities activity : user.getActivitiesList()) {
            LocalDate tempDate = activity.getTimeStamp().toLocalDate();
            if (tempDate.equals(todaysDate)) {
                totalDailyDuration += activity.getDuration();
            } else {
                break;
            }
        }
        return totalDailyDuration;
    }

    public User checkIfLvlUp(User user) {
        if (user.getXpSystem().getXp() >= user.getXpToLevel() && user.getLvl() < 100) {
            user.getXpSystem().setLvl(user.getXpSystem().getLvl() + 1);
            user.getXpSystem().setXp(user.getXpSystem().getXp() - user.getXpToLevel());
            user.getXpSystem().setXpToLevel((int) (user.getXpToLevel() + user.getLvl() * 10));
        }
        return user;
    }

    public User xpHandler(User user) {
        user = calculateUserEvaluationXpGain(user);
        user = checkIfLvlUp(user);

        return user;
    }
}

package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.Activities;
import com.Mafunzo.Mafunzo.Model.User;

import java.time.Clock;
import java.time.LocalDate;

/**
 * This class handles the XP system for the users.
 * It calculates the XP increase, the XP gain from evaluations and the XP gain from activities.
 *
 * @author William Starå, Adam Mheisen, Kasper Svenlin, Isak Hakola, Kevin Nordkvist
 */
public class XpController {

    /**
     * This method calculates the XP increase for the user based on their streak.
     * There is a base xp gain of 10 XP, and then the streak is calculated into the XP gain.
     *
     * @param user parameter for the user
     * @return double returns the XP increase as a double
     */
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

    /**
     * This method calculates the XP gain for the user based on their evaluation score.
     * The user gets XP based on their evaluation score and the duration of their activities.
     * Beginners need 30 minutes of duration to gain xp, intermediate need 45 minutes and advanced need 60 minutes.
     *
     * @param user parameter for the user
     * @return User returns the user with updated XP
     */
    public User evaluationCheckForXpGain(User user) {
        if (user.getEvaluationScore() <= 8) {
            if (checkDailyDuration(user) >= 30 && !user.getStreakIsUpdated()) {
                updateXpAndStreak(user);
            }
        }
        if (user.getEvaluationScore() >= 9 && user.getEvaluationScore() <= 16) {
            if (checkDailyDuration(user) >= 45 && !user.getStreakIsUpdated()) {
                updateXpAndStreak(user);
            }
        }
        if (user.getEvaluationScore() >= 17 && user.getEvaluationScore() <= 20) {
            if (checkDailyDuration(user) >= 60 && !user.getStreakIsUpdated()) {
                updateXpAndStreak(user);
            }
        }
        return checkIfLvlUp(user);
    }

    /**
     * This method checks the daily duration of the user's activities.
     * It calculates the total daily duration of the user's activities.
     * This is used to check if the user is eligible to gain more xp during the day.
     *
     * @param user parameter for the user
     * @return double returns the total daily duration as a double
     */
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

    /**
     * This method checks if the user has enough XP to level up.
     * If the user has enough XP, the user will level up and the XP will be reset.
     * The XP threshold to level up will increase for each level.
     *
     * @param user parameter for the user
     * @return User returns the user with updated XP
     */
    public User checkIfLvlUp(User user) {
        if (user.getXpSystem().getXp() >= user.getXpToLevel() && user.getLvl() < 100) {
            user.getXpSystem().setLvl(user.getXpSystem().getLvl() + 1);
            user.getXpSystem().setXp(user.getXpSystem().getXp() - user.getXpToLevel());
            user.getXpSystem().setXpToLevel((int) (user.getXpToLevel() + user.getLvl() * 10));
        }
        return user;
    }

    /**
     * This method registers the XP gain for the user.
     * It checks if the user is eligible to gain XP and then updates the user's XP and streak.
     *
     * @param user parameter for the user
     * @return User returns the user with updated XP
     */
    public User registerXpToUser(User user) {
        return evaluationCheckForXpGain(user);
    }

    /**
     * This method updates the user's XP and streak.
     * It increases the user's XP and streak by the calculated XP increase.
     *
     * @param user parameter for the user
     * @author Adam Mheisen, Kasper Svenlin
     */
    public void updateXpAndStreak(User user) {
        double xpIncrease = calculateXPIncrease(user);
        user.getXpSystem().setXp(user.getXpSystem().getXp() + xpIncrease);
        user.setStreakIsUpdated(true);
        user.getXpSystem().setStreak(user.getXpSystem().getStreak() + 1);
    }
}

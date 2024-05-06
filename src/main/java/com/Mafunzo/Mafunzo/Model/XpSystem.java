package com.Mafunzo.Mafunzo.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class that represents the xp system of a user
 *
 * @author Adam Mheisen
 */

public class XpSystem implements Serializable {

    private double xp;
    private int lvl = 1;
    private static final int maxLvl = 100;
    private double xpToLevel = 100;
    private int streak;
    private int inactiveDays;
    private Activities activities;

    public XpSystem(double xp, int lvl, int streak, int inactiveDays, double xpToLevel) {
        this.xp = xp;
        this.lvl = lvl;
        this.streak = streak;
        this.inactiveDays = inactiveDays;
        this.xpToLevel = xpToLevel;
    }

    public double calculateXPIncrease() {
        int streak = getStreak();
        double baseMultiplier = 1.0;

        if (streak == 7 || streak == 14) {
            baseMultiplier = 1.08;
        } else if (streak >= 1 && streak <= 6 || (streak >= 8 && streak <= 13)) {
            baseMultiplier = 1.07;
        } else if (streak > 14) {
            baseMultiplier = 1;
        }
        double streakMultiplier = baseMultiplier * streak;
        double levelBonus = 1 + (getLvl() - 1) * 0.01;
        return streakMultiplier * levelBonus;
    }

    public void calculateUserEvaluationXpGain(User user) {
        if (user.getEvaluationScore() <= 8) {
            if (checkDailyDuration(user) >= 30 && !user.getStreakIsUpdated()) {
                double xpIncrease = calculateXPIncrease();
                setXp(getXp() + xpIncrease);
                user.setStreakIsUpdated(true);
            }
            if (user.getEvaluationScore() >= 9 && user.getEvaluationScore() <= 16) {
                if (checkDailyDuration(user) >= 45 && !user.getStreakIsUpdated()) {
                    double xpIncrease = calculateXPIncrease();
                    setXp(getXp() + xpIncrease);
                    user.setStreakIsUpdated(true);
                }
            }
            if (user.getEvaluationScore() >= 17 && user.getEvaluationScore() <= 20) {
                if (checkDailyDuration(user) >= 60 && !user.getStreakIsUpdated()) {
                    double xpIncrease = calculateXPIncrease();
                    setXp(getXp() + xpIncrease);
                    user.setStreakIsUpdated(true);
                }
            }
        }
    }

    public double checkDailyDuration(User user){
        double totalDailyDuration = 0;
        LocalDate todaysDate = LocalDate.now();
        for(Activities activity: user.getActivitiesList()){
            LocalDate tempDate = activity.getTimeStamp().toLocalDate();
            if(tempDate.equals(todaysDate)){
                totalDailyDuration += activity.getDuration();
            }else{
                break;
            }
        }
        return totalDailyDuration;
    }


    public void checkIfLvlUp(){
        if(getXp() >= getXpToLevel() && getLvl() < 100) {
            setLvl(getLvl() + 1);
            setXp(getXp() - getXpToLevel());
            setXpToLevel((int) (getXpToLevel() + getLvl() * 10));
        }
    }


    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public int getInactiveDays() {
        return inactiveDays;
    }

    public void setInactiveDays(int inactiveDays) {
        this.inactiveDays = inactiveDays;
    }

    public static int getMaxLvl() {
        return maxLvl;
    }

    public double getXpToLevel() {
        return xpToLevel;
    }

    public void setXpToLevel(int xpToLevel) {
        this.xpToLevel = xpToLevel;
    }
}

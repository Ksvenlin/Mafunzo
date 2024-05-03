package com.Mafunzo.Mafunzo.Model;

import java.io.Serializable;

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

    public XpSystem(double xp, int lvl, int streak, int inactiveDays, double xpToLevel) {
        this.xp = xp;
        this.lvl = lvl;
        this.streak = streak;
        this.inactiveDays = inactiveDays;
        this.xpToLevel = xpToLevel;
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

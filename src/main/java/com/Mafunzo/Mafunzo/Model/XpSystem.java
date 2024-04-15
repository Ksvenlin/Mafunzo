package com.Mafunzo.Mafunzo.Model;

public class XpSystem {

    private double xp;
    private int lvl = 1;
    private static final int maxLvl = 100;
    private int xpToLevel = 100;
    private int streak;
    private int inactiveDays;


    public XpSystem(double xp, int lvl, int streak, int inactiveDays, int xpToLevel) {
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

    public int getXpToLevel() {
        return xpToLevel;
    }

    public void setXpToLevel(int xpToLevel) {
        this.xpToLevel = xpToLevel;
    }
}

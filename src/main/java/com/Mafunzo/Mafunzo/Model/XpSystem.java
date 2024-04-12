package com.Mafunzo.Mafunzo.Model;

public class XpSystem {

    private double xp;
    private int lvl = 1;
    private static final int maxLvl = 100;
    private static final int baseXPtoLevel = 100;
    private int streak;

    public XpSystem(double xp, int lvl, int streak) {
        this.xp = xp;
        this.lvl = lvl;
        this.streak = streak;
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

}

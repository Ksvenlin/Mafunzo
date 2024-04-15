package com.Mafunzo.Mafunzo.Model;

public class XpSystem {

    private double xp;
    private int lvl = 1;
    private static final int maxLvl = 100;
    private static int xpToLevel = 100;
    private int streak;
    private int inactiveDays;


    public XpSystem(double xp, int lvl, int streak) {
        this.xp = xp;
        this.lvl = lvl;
        this.streak = streak;
    }

    /**
     * Räknar ut hur xp ökar beroende på level och streak
     */
    public double calculateXPIncrease() {
        double xpIncrease = 1.0;
        if (streak >= 7 && streak <= 14) {
        xpIncrease = (streak == 7 || streak == 14) ? 1.08 : 1.07;
        }return xpIncrease * (1 + (lvl - 1) * 0.01);
    }

    /**
     * Räknar ut hur mycket xp som behövs för att levla upp
     */
    public void checkLvlUp() {
       while(xp >= xpToLevel && lvl < maxLvl){
            lvl++;
            xp -= xpToLevel;
            xpToLevel += lvl * 10;
       }
    }

    public void resetStreak(){
        streak = 0;
    }

    public void inactiveDays(){
        if(inactiveDays >= 3){
            resetStreak();
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

}

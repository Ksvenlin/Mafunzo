package com.Mafunzo.Mafunzo.Controller;

import com.Mafunzo.Mafunzo.Model.XpSystem;

public class XpLogicController {
    private XpSystem xpSystem;

    public XpLogicController() {

    }

    /**
     * Calculates the increase in xp based on the current streak and level
     */
    public double calculateXPIncrease() {
        double xpIncrease = 1.0;
        if (xpSystem.getStreak() >= 7 && xpSystem.getStreak() <= 14) {
            xpIncrease = (xpSystem.getStreak() == 7 || xpSystem.getStreak() == 14) ? 1.08 : 1.07;
        }
        return xpIncrease * (1 + (xpSystem.getLvl() - 1) * 0.01);
    }

    /**
     * Checks if the user has enough xp to level up, and if so, increases the threshold for the next level, also increases the level
     */
    public void checkLvlUp(int lvl) {
        while (xpSystem.getXp() >= xpSystem.getXpToLevel() && xpSystem.getLvl() < xpSystem.getMaxLvl()) {
            xpSystem.setLvl(xpSystem.getLvl() + 1);
            xpSystem.setXp(xpSystem.getXp() - xpSystem.getXpToLevel());
            xpSystem.setXpToLevel((int) (xpSystem.getXpToLevel() + xpSystem.getLvl() * 10));
        }
    }

    /**
     * Method to reset the streak
     */
    public void resetStreak() {
        xpSystem.setStreak(0);
    }

    /**
     * Method that resets the streaks after 3 inactive days
     */
    public void inactiveDaysReset() {
        if (xpSystem.getInactiveDays() >= 3) {
            resetStreak();
        }
    }
}

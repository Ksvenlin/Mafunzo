package com.Mafunzo.Mafunzo.Controller;
import com.Mafunzo.Mafunzo.Model.XpSystem;

public class XpLogicController {
    private XpSystem xpSystem;

    public XpLogicController(){

    }

    /**
     * Räknar ut hur xp ökar beroende på level och streak
     */
    public double calculateXPIncrease() {
        double xpIncrease = 1.0;
        if (xpSystem.getStreak() >= 7 && xpSystem.getStreak() <= 14) {
            xpIncrease = (xpSystem.getStreak() == 7 || xpSystem.getStreak() == 14) ? 1.08 : 1.07;
        }return xpIncrease * (1 + (xpSystem.getLvl() - 1) * 0.01);
    }

    /**
     * Räknar ut ifall man har tillräckligt med xp för att levla och levlar upp en, samt ökar
     * gränsen för nästa levels levelökning
     */
    public void checkLvlUp(int lvl) {
        while(xpSystem.getXp() >= xpSystem.getXpToLevel() && xpSystem.getLvl() < xpSystem.getMaxLvl()){
            xpSystem.setLvl(xpSystem.getLvl()+1);
            xpSystem.setXp(xpSystem.getXp() - xpSystem.getXpToLevel());
            xpSystem.setXpToLevel(xpSystem.getXpToLevel() + xpSystem.getLvl() * 10);
        }
    }

    /**
     * Metod som återställer streak till 0
     */
    public void resetStreak(){
        xpSystem.setStreak(0);
    }

    /**
     * Metod som återställer streaken om inaktiva dagar är 3 eller mer
     */
    public void inactiveDaysReset(){
        if(xpSystem.getInactiveDays() >= 3){
            resetStreak();
        }
    }
}

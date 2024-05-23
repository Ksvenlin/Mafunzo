package com.Mafunzo.Mafunzo.Model.Activity;

import com.Mafunzo.Mafunzo.Model.Activities;
import com.Mafunzo.Mafunzo.Model.Day;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * GolfActivity is a class that represents a golf activity.
 *
 * @author Isak Hakola & Kasper Svenlin
 */
public class GolfActivity implements Activities {

    private String description;
    private double duration;
    private List<Hole> scoreCard;
    private String caption;
    private Day timeStamp;




    public GolfActivity() {
        scoreCard = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            scoreCard.add(new Hole(0, 0, i + 1));
        }
    }

    public List<Hole> getScoreCard() {
        return scoreCard;
    }

    public void setScoreCard(List<Hole> scoreCard) {
        this.scoreCard = scoreCard;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return "Golf";
    }

    public double getDuration() {
        return duration;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Day getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Day timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public List<Exercise> getExerciseList() {
        return null;
    }

    @Override
    public String printInfo() {
        int totalPoints = 0;
        int totalStrokes = 0;
        for (Hole hole : scoreCard) {
            totalPoints += hole.getPoints();
            totalStrokes += hole.getStrokes();
        }
        return "Aktivitet: " + getName() + "\n" + "Beskrivning: " + getDescription() +
                "\n" + "Tid: " + getDuration() + " minuter" + "\n" +
                "Slag: " + totalStrokes + " Poäng: " + totalPoints;
    }

    public static class Hole {
        private int strokes;
        private int points;
        private int holeNumber;

        public Hole(int strokes, int points, int holeNumber) {
            this.holeNumber = holeNumber;
            this.strokes = strokes;
            this.points = points;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public int getStrokes() {
            return strokes;
        }

        public void setStrokes(int strokes) {
            this.strokes = strokes;
        }

        public int getHoleNumber() {
            return holeNumber;
        }

    }
}

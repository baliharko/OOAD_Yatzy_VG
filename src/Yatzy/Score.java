package Yatzy;

import java.time.LocalDate;

public class Score {

    private String playerName;
    private int score;
    private LocalDate date;


    public Score() {

    }

    public Score(String playerName) {
        this.playerName = playerName;
    }

    public void calculateScore(int tempScore) {
        if (tempScore >= 42)
            tempScore += 30;

        this.score += tempScore;
    }

    public String finalScore() {
        this.date = LocalDate.now();
        return playerName +
                "\nPoäng: " + this.score +
                "\nDatum: " + this.date;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public static void main(String[] args) {
        Score points = new Score("asdf");

        points.calculateScore(100);
        points.calculateScore(100);

        System.out.println(points.finalScore());
    }
}

package Yatzy;

import java.time.LocalDate;

public class Score {

    //private String playerName;
    private int score;
    private LocalDate date;


    public void calculateScore(int tempScore) {
        if (tempScore >= 42)
            tempScore += 30;

        this.score += tempScore;
    }

    public String finalScore() {
        this.date = LocalDate.now();
        return "Poäng: " + score +
                "\nDatum: " + date;
    }

    public static void main(String[] args) {
        Score points = new Score();

        points.calculateScore(100);
        points.calculateScore(100);

        System.out.println(points.finalScore());
    }
}

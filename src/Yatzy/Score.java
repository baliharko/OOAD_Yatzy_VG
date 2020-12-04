package Yatzy;

import java.time.LocalDate;

public class Score {

    //private String playerName;
    private int score;
    private LocalDate date;

    public Score(int score) {
        this.score = score;
        this.date = LocalDate.now();

        calculateScore();
    }

    public void calculateScore() {
        if (this.score >= 42)
            this.score += 30;
    }

    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                ", date=" + date +
                '}';
    }

    public static void main(String[] args) {
        Score points = new Score(100);

        System.out.println(points.toString());
    }
}

package Score;

import java.time.LocalDate;

/**
 * Created by Oscar Norman <br>
 * Date: 2020-11-24   <br>
 * Time: 14:42   <br>
 * Project: JAVA20-OOAD-Projektarbete-Grupp-10 <br>
 */
public class Score {

    private int score;
    private Player player;
    private LocalDate date;

    public Score(int score, Player player) {
        this.player = player;
        this.score = score;
        this.date = LocalDate.now();
        calculateScore();
    }

    public void calculateScore() {
        if (this.score >= 42) {this.score += 35;}
    }

    public static void main(String[] args) {
        Score score = new Score(41, new Player());
        System.out.println(score.getScore());
        System.out.println(score.getDate());
    }

    public int getScore() {
        return score;
    }


    public LocalDate getDate() {
        return date;
    }
}

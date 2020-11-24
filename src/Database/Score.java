package Database;

import java.time.LocalDateTime;

public class Score {

    private String playerName;
    private int score;
    private LocalDateTime time;

    public Score(String playerName, int score, LocalDateTime time) {
        this.playerName = playerName;
        this.score = score;
        this.time = time;
    }
}

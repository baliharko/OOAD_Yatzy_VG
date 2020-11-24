package Database;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final String FILEPATH = ""; // Temp
    private List<Score> listofScores;

    public Database() {
        this.listofScores = new ArrayList<>();
    }

    public void addScore(Score score) {
        // Sort before
        this.listofScores.add(score);
    }

    public void loadData() {
        // Loads data from .ser file.
    }

    public void saveData() {
        // Saves data to .ser file.
    }
}


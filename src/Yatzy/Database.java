package Database;

import Yatzy.Score;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static Database single_instance = null;
    private static final String FILEPATH = ""; // Temp
    private List<Score> listOfScores;

    private Database() {
        this.listOfScores = new ArrayList<>();
        Database.single_instance = this;
        System.out.println("Database object created.");
    }

    public static Database getInstance() {
        return single_instance == null ? new Database() : null;
    }

    public void addScore(Score score) {
        // Sort before
        this.listOfScores.add(score);
    }

    public void loadData() {
        // Loads data from .ser file.
    }

    public void saveData() {
        // Saves data to .ser file.
    }

}
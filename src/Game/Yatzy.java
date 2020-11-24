package Game;

import Database.Database;

/**
 * Created by Oscar Norman <br>
 * Date: 2020-11-24   <br>
 * Time: 13:59   <br>
 * Project: JAVA20-OOAD-Projektarbete-Grupp-10 <br>
 */
public class Yatzy {
    boolean playAgain = true;
    Database database = Database.getInstance();

    Yatzy(){
        while(playAgain){
            new Game();
        }
    }

    public void quit(){
        playAgain = false;
    }

    public Database getDatabase(){
        return database;
    }
}

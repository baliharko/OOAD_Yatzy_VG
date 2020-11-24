package Game;

import java.lang.reflect.Array;

/**
 * Created by Hanna Edlund
 * Date: 2020-11-24
 * Time: 14:44
 * Project: Mini-Yatzy
 */
public class Game {

    private Player player;
    private int score;
    Dice[] dices = new Array[5];

    Game(Player player){
        this.player = player;
    }
}

package Game;

import java.util.Random;

/**
 * Created by Viktor Kodet <br>
 * Date: 2020-11-24 <br>
 * Time: 14:40 <br>
 * Project: IntelliJ IDEA <br>
 */
public class Dice {
    Random random = new Random();

    private int value;

    public Dice(){
        roll();
    }

    public void roll(){
        value = random.nextInt(6) + 1;
    }

    public int getValue(){
        return value;
    }
}

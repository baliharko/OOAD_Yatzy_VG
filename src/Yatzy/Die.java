package Yatzy;

import java.util.Random;

public class Die {
    Random random = new Random();

    private int value;

    public Die(){
        roll();
    }

    public void roll(){
        value = random.nextInt(6) + 1;
    }

    public int getValue(){
        return value;
    }
}

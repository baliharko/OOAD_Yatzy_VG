package Game;

/**
 * Created by Hanna Edlund
 * Date: 2020-11-24
 * Time: 14:44
 * Project: JAVA20-OOAD-Projektarbete-Grupp-10
 */
public class Game {

//    private Player player;
    private int score;
    Dice[] dices = new Dice[5];

    Game(){
        createDices();
        System.out.println("RULLA TÄRNINGARNA");
        for (int i = 0; i < dices.length; i++) {
            dices[i].roll();
            System.out.println("Tärning " + (i+1) + ": " + dices[i].getValue());
        }
    }

    public void createDices(){
        for (int i = 0; i < dices.length; i++) {
            dices[i] = new Dice();
            System.out.println("Tärning " + (i+1) + ": " + dices[i].getValue());
        }
    }

    public static void main(String[] args) {
        Game g = new Game();
    }
}

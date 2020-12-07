package Yatzy;

import javax.swing.*;
import java.awt.*;

public abstract class Game {

    protected Color gameColor;
    private Controller controller;

    private String player;
    private int currentScore;
    Die[] dice = new Die[5];
    private int currentThrow;
    Database database;

    public Game(Controller controller) {
        this.controller = controller;
        createDice();
    }

    public Die[] rollDice() {
        JToggleButton[] toggleButtons = controller.getDiceButtons();
        for (int i = 0; i < dice.length; i++) {
            if (!toggleButtons[i].isSelected()) {
                dice[i].roll();
//                toggleButtons[i].setText("" + dice[i].getValue());
                System.out.println("Dice " + i + " : " + dice[i].getValue());
            }
        }
        return dice;
    }

    public void createDice() {
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die();
            System.out.println("Tärning " + (i + 1) + ": " + dice[i].getValue());
        }
    }

    public Color getGameColor() {
        return this.gameColor;
    }
}

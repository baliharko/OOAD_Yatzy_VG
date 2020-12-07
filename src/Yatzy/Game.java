package Yatzy;

import javax.swing.*;
import java.awt.*;

public abstract class Game {

    protected Color gameColor;
    private Controller controller;
    private static final int THROWS_AMOUNT = 3;

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
        addThrow();
        JToggleButton[] toggleButtons = controller.getDiceButtons();
        for (int i = 0; i < dice.length; i++) {
            if (!toggleButtons[i].isSelected()) {
                dice[i].roll();
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

    public void addThrow() {
        this.currentThrow = (this.currentThrow + 1) % THROWS_AMOUNT;
    }
}

package Yatzy;

import javax.swing.*;
import java.awt.*;

public abstract class Game {

    private static final int THROWS_AMOUNT = 3;
    private static final int ROUNDS_AMOUNT = 6;

    Database database;
    protected Color gameColor;
    private Controller controller;
    private String playerName;
    private int currentScore;
    Die[] dice = new Die[5];
    private int currentThrow;
    private int currentRound;

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

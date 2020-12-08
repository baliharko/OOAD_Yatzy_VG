package Yatzy;

import javax.swing.*;
import java.awt.*;

public class Controller {

    private YatzyWindow window;
    public Game game;

    public Controller() {
        this.window = new YatzyWindow();
        setUpStartButtonListener();

        window.getYatzyPanel().roll.addActionListener(l -> {
            setRoundColors();
            Die[] dice = game.rollDice();
            JToggleButton[] toggleButtons = getDiceButtons();
            for (int i = 0; i < dice.length; i++) {
                if (!toggleButtons[i].isSelected()) {
                    toggleButtons[i].setText("" + dice[i].getValue());
                }
            }
        });

        window.getYatzyPanel().show.addActionListener(l -> {
            new HighScoreWindow();
        });

        for (JToggleButton diceButton : window.getYatzyPanel().diceButtons) {
            diceButton.addActionListener(l -> {
                if (diceButton.isSelected())
                    diceButton.setBackground(new Color(184,207,229));
                else
                    diceButton.setBackground(game.gameColor);
            });
        }

//        if(window.getYatzyPanel().roundLabels.get(game.getCurrentRound()).getText().equals(""+game.getCurrentRound())){
//            window.getYatzyPanel().roundLabels.get(game.getCurrentRound()).setBackground(game.getGameColor());
//        }
//        else{
//            window.getYatzyPanel().roundLabels.get(game.getCurrentRound()).setBackground(Color.white);
//        }
    }

    public void setUpStartButtonListener() {
        window.getStartPanel().getStartGameButton().addActionListener(l -> {
            if (window.getStartPanel().getNotRankedGameButton().isSelected()) {
                window.setTitle("Just playing for fun... loser");
                startUnrankedGame();
                window.changePanelTo(window.getYatzyPanel());
            } else if (window.getStartPanel().getRankedGameButton().isSelected()) {
                if (window.getStartPanel().getNameField().getText().length() > 2) {
                    this.window.setTitle("Name: " + window.getStartPanel().getNameField().getText());
                    startRankedGame();
                    window.changePanelTo(window.getYatzyPanel());
                } else System.out.println("Du måste ange ett namn/alias med minst 3 tecken.");
            }
        });
    }

    public void startUnrankedGame() {
        this.game = new UnrankedGame(this);
        this.window.getYatzyPanel().setColor(game.getGameColor());
    }

    public void startRankedGame() {
        this.game = new RankedGame(this);
        this.window.getYatzyPanel().setColor(game.getGameColor());
    }

    public JToggleButton[] getDiceButtons() {
        return window.getYatzyPanel().diceButtons;
    }

    public void setRoundColors(){
        if(game.getCurrentRound() < Game.ROUNDS_AMOUNT){
            if(Integer.parseInt(window.getYatzyPanel().roundLabels.get(game.getCurrentRound()).getText())-1 == game.getCurrentRound()){
                window.getYatzyPanel().roundLabels.get(game.getCurrentRound()).setBackground(game.getGameColor());
            }
            else{
                window.getYatzyPanel().roundLabels.get(game.getCurrentRound()).setBackground(Color.white);
            }
        }
        else{
            System.out.println("Beräkna saker");
        }

    }
}

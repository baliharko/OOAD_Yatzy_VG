package Yatzy;

import javax.swing.*;
import java.awt.*;

public class Controller {

    private YatzyWindow window;
    public Game game;

    public Controller() {
        this.window = new YatzyWindow();
        setUpStartButtonListener();

        setUpRollButtonListener();

        setUpHighscoreButtonListener();

        setUpSelectedDieColor();
    }

    public void setUpRollButtonListener(){
        window.getYatzyPanel().rollButton.addActionListener(l -> {
            changeButtonStates(true);
            Die[] dice = game.rollDice();
            JToggleButton[] toggleButtons = getDiceButtons();
            for (int i = 0; i < dice.length; i++) {
                if (!toggleButtons[i].isSelected()) {
                    toggleButtons[i].setText("" + dice[i].getValue());
                }
            }
            window.getYatzyPanel().rollButton.setText("Kasta");

            if(game.getCurrentThrow() == 2){
                for (JToggleButton diceButton: window.getYatzyPanel().diceButtons) {
                    diceButton.setSelected(false);
                    diceButton.setBackground(game.getGameColor());
                }
                changeButtonStates(false);

                int roundScore = game.calculateRoundScore();
                window.getYatzyPanel().scoreLabels.get(game.getCurrentRound()).setText(String.valueOf(roundScore));
            }

            setRoundColors();

            if (game.getCurrentRound() == Game.ROUNDS_AMOUNT-1 && game.getCurrentThrow() == Game.THROWS_AMOUNT-1){
                setFinalScore();
            }
        });
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
//                    game.setPlayerName(window.getStartPanel().getNameField().getText());
                    startRankedGame();
                    window.changePanelTo(window.getYatzyPanel());
                } else System.out.println("Du måste ange ett namn/alias med minst 3 tecken.");
            }
        });
    }

    public void setUpHighscoreButtonListener(){
        window.getYatzyPanel().showScoreButton.addActionListener(l -> {
            new HighScoreWindow(game.database.getListOfScores());
        });
    }

    public void setUpSelectedDieColor(){
        for (JToggleButton diceButton : window.getYatzyPanel().diceButtons) {
            diceButton.addActionListener(l -> {
                if (diceButton.isSelected())
                    diceButton.setBackground(new Color(184,207,229));
                else
                    diceButton.setBackground(game.gameColor);
            });
        }
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
    }

    public void changeButtonStates(Boolean state){
        for(var button : window.getYatzyPanel().diceButtons){
            button.setEnabled(state);
        }
        if (!state) setUpNewRound();
    }

    public void setUpNewRound(){
        window.getYatzyPanel().rollButton.setText("Nästa omgång");
    }

    public void setFinalScore(){
        if(game.isBonusQualified()){
            window.getYatzyPanel().scoreLabels.get(6).setText("35");
        }
        else window.getYatzyPanel().scoreLabels.get(6).setText("0");
        window.getYatzyPanel().scoreLabels.get(7).setText(String.valueOf(game.getCurrentScore()));

        if(game instanceof RankedGame){
            game.database.addScore(new Score(game.getPlayerName(), game.getCurrentScore()));
            game.database.saveData();
        }
    }
}

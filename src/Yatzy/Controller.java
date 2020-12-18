package Yatzy;

import javax.swing.*;
import java.awt.*;

public class Controller {

    private YatzyWindow window;
    private HighScoreWindow highScoreWindow;
    private Game game;

    public Controller() {
        this.window = new YatzyWindow();
        setUpStartPanelListener();
        setUpStartButtonListener();
        setUpRollButtonListener();
        setUpHighscoreButtonListener();
        setUpSelectedDieColorListener();
    }

    public void setUpStartPanelListener() {
        window.getStartPanel().getRankedGameButton().addActionListener(l -> {
            if (window.getStartPanel().getRankedGameButton().isSelected()) {
                window.getStartPanel().getUnrankedGameButton().setSelected(false);
                window.getStartPanel().getNameField().setVisible(true);
                window.getStartPanel().getStartGameButton().setEnabled(true);
                window.getStartPanel().getRankedGameButton().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 30));
                window.getStartPanel().getUnrankedGameButton().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 30));
                window.getStartPanel().setBackground(Color.LIGHT_GRAY);
                window.getStartPanel().getNameLabel().setVisible(true);
                window.getStartPanel().repaintTextField();
            } else if (!window.getStartPanel().getRankedGameButton().isSelected()) {
                window.getStartPanel().getNameField().setVisible(false);
                window.getStartPanel().getNameLabel().setVisible(false);
                window.getStartPanel().getRankedGameButton().setBorder(BorderFactory.createLineBorder(
                        window.getStartPanel().getColor(), 30));
                window.getStartPanel().getUnrankedGameButton().setBorder(BorderFactory.createLineBorder(
                        window.getStartPanel().getColor(), 30));
                window.getStartPanel().setBackground(window.getStartPanel().getColor());
                window.getStartPanel().getStartGameButton().setEnabled(false);
                window.getStartPanel().repaintTextField();
            }
        });
        window.getStartPanel().getUnrankedGameButton().addActionListener(l -> {
            if (window.getStartPanel().getUnrankedGameButton().isSelected()) {
                window.getStartPanel().getRankedGameButton().setSelected(false);
                window.getStartPanel().getNameField().setVisible(false);
                window.getStartPanel().getNameLabel().setVisible(false);
                window.getStartPanel().getUnrankedGameButton().setBorder(BorderFactory.createLineBorder(Color.PINK, 30));
                window.getStartPanel().getRankedGameButton().setBorder(BorderFactory.createLineBorder(Color.PINK, 30));
                window.getStartPanel().setBackground(Color.PINK);
                window.getStartPanel().getStartGameButton().setEnabled(true);
                window.getStartPanel().repaintTextField();
            } else if (!window.getStartPanel().getUnrankedGameButton().isSelected()) {
                window.getStartPanel().getStartGameButton().setEnabled(false);
                window.getStartPanel().getRankedGameButton().setBorder(BorderFactory.createLineBorder(
                        window.getStartPanel().getColor(), 30));
                window.getStartPanel().getUnrankedGameButton().setBorder(BorderFactory.createLineBorder(
                        window.getStartPanel().getColor(), 30));
                window.getStartPanel().setBackground(
                        window.getStartPanel().getColor());
            }
        });
    }

    public void setUpRollButtonListener() {
        window.getYatzyPanel().getRollButton().addActionListener(l -> {
            changeButtonStates(true);
            if (window.getYatzyPanel().getRollButton().getText().equals("Avsluta")) {
                showExitOrNewGamePrompt();
            }
            Die[] dice = game.rollDice();
            JToggleButton[] toggleButtons = getDiceButtons();
            for (int i = 0; i < dice.length; i++) {
                if (!toggleButtons[i].isSelected()) {
                    toggleButtons[i].setText("" + dice[i].getValue());
                }
            }
            window.getYatzyPanel().getRollButton().setText("Kasta");

            if (game.getCurrentThrow() == 2) {
                for (JToggleButton diceButton : window.getYatzyPanel().getDiceButtons()) {
                    diceButton.setSelected(false);
                    diceButton.setBackground(game.getGameColor());
                }
                changeButtonStates(false);

                int roundScore = game.calculateRoundScore();
                window.getYatzyPanel().getScoreLabels().get(game.getCurrentRound()).setText(String.valueOf(roundScore));
            }

            setRoundColors();

            if (game.getCurrentRound() == Game.ROUNDS_AMOUNT - 1 && game.getCurrentThrow() == Game.THROWS_AMOUNT - 1) {
                setFinalScore();
            }
        });
    }

    public void setUpStartButtonListener() {
        window.getStartPanel().getStartGameButton().addActionListener(l -> {
            if (window.getStartPanel().getUnrankedGameButton().isSelected()) {
                window.setTitle("(UNRANKED GAME) - YATZY");
                startUnrankedGame();
                window.changePanelTo(window.getYatzyPanel());
            } else if (window.getStartPanel().getRankedGameButton().isSelected()) {
                if (!window.getStartPanel().getNameField().getText().isBlank()
                        && window.getStartPanel().getNameField().getText().length() < 11) {
                    String name = window.getStartPanel().getNameField().getText();
                    this.window.setTitle("(RANKED GAME) - Name: " + name);
                    startRankedGame();
                    game.setPlayerName(name);
                    window.changePanelTo(window.getYatzyPanel());
                } else System.out.println("Ange namn mellan 1 och 10.");
            }
        });
    }

    public void setUpHighscoreButtonListener() {
        window.getYatzyPanel().getShowScoreButton().addActionListener(l -> {
            if (highScoreWindow != null)
                highScoreWindow.dispose();

            highScoreWindow = new HighScoreWindow(game.database.getListOfScores());
            setUpHighScoreResetButton();
        });
    }

    // (added) TODO setUpHighScoreResetButton
    public void setUpHighScoreResetButton() {
        highScoreWindow.resetButton.addActionListener(listener -> {
            if (JOptionPane.showConfirmDialog(null, "Är du säker på att du vill radera alla sparade scores?",
                    "Radera sparade scores?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                game.database.resetScoreBoard();
                JOptionPane.showMessageDialog(null, "Alla scores raderade.", "Alla scores raderade.", JOptionPane.INFORMATION_MESSAGE);
                highScoreWindow.dispose();
                highScoreWindow = new HighScoreWindow(game.database.getListOfScores());
            }
        });
    }

    public void setUpSelectedDieColorListener() {
        for (JToggleButton diceButton : window.getYatzyPanel().getDiceButtons()) {
            diceButton.addActionListener(l -> {
                if (diceButton.isSelected())
                    diceButton.setBackground(new Color(184, 207, 229));
                else
                    diceButton.setBackground(game.gameColor);
            });
        }
    }

    public void startUnrankedGame() {
        this.game = new UnrankedGame(this);
        this.window.getYatzyPanel().setDieColor(game.getGameColor());
    }

    public void startRankedGame() {
        this.game = new RankedGame(this);
        this.window.getYatzyPanel().setDieColor(game.getGameColor());
    }

    public JToggleButton[] getDiceButtons() {
        return window.getYatzyPanel().getDiceButtons();
    }

    public void setRoundColors() {
        if (game.getCurrentRound() < Game.ROUNDS_AMOUNT) {
            if (Integer.parseInt(window.getYatzyPanel().getRoundLabels().get(game.getCurrentRound()).getText()) - 1 == game.getCurrentRound()) {
                window.getYatzyPanel().getRoundLabels().get(game.getCurrentRound()).setBackground(game.getGameColor());
            } else {
                window.getYatzyPanel().getRoundLabels().get(game.getCurrentRound()).setBackground(Color.white);
            }
        }
    }

    public void changeButtonStates(Boolean state) {
        for (var button : window.getYatzyPanel().getDiceButtons()) {
            button.setEnabled(state);
        }
        if (!state) setUpNewRound();
    }

    public void setUpNewRound() {
        window.getYatzyPanel().getRollButton().setText("Nästa omgång");
    }

    public void setFinalScore() {
        if (game.isBonusQualified()) {
            window.getYatzyPanel().getScoreLabels().get(6).setText("35");
        } else window.getYatzyPanel().getScoreLabels().get(6).setText("0");
        window.getYatzyPanel().getScoreLabels().get(7).setText(String.valueOf(game.getCurrentScore()));

        if (game instanceof RankedGame) {
            game.database.addScore(new Score(game.getPlayerName(), game.getCurrentScore()));
            game.database.saveData();
        }

        window.getYatzyPanel().getRollButton().setText("Avsluta");
    }

    // (added) TODO showExitOrNewGamePrompt
    private void showExitOrNewGamePrompt() {
        if (JOptionPane.showConfirmDialog(null,
                "Vill du spela igen?", "Spela igen?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            this.window.dispose();
            this.window = new YatzyWindow();
            setUpStartPanelListener();
            setUpStartButtonListener();
            setUpRollButtonListener();
            setUpHighscoreButtonListener();
            setUpSelectedDieColorListener();
        } else
            System.exit(0);
    }
}

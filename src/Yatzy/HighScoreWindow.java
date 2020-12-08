package Yatzy;

import javax.swing.*;
import java.awt.*;

public class HighScoreWindow extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JPanel topPanel = new JPanel();
    private JLabel header = new JLabel("Scoreboard");
    private JTextArea scoreArea = new JTextArea();
    private JScrollPane sp = new JScrollPane(scoreArea);

    public HighScoreWindow(){
        setUpScoreBoardLabel();
        setUpScoreBoard();
        setUpJFrame();
    }

    public void setUpScoreBoardLabel(){
        header.setFont(new Font("SansSerif", Font.PLAIN,24));
        topPanel.add(header);
        mainPanel.add(topPanel);
    }

    public void setUpScoreBoard(){
        this.add(mainPanel);
        scoreArea.setEditable(false);
        scoreArea.setForeground(Color.BLACK);
        scoreArea.setPreferredSize(new Dimension(280,430));
        scoreArea.setFont(new Font("SansSerif", Font.PLAIN,14));
        scoreArea.append("1. First score (test)\n"); // Test
        scoreArea.append("2. Second score (test)\n"); // Test
        mainPanel.add(sp);
    }

    public void setUpJFrame(){
        this.setLocation(1000,150);
        this.setSize(300,500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new HighScoreWindow();
    }

}

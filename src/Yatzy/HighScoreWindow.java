package Yatzy;

import javax.swing.*;
import java.awt.*;

public class HighScoreWindow extends JFrame {

    private JPanel topPanel = new JPanel();
    private JLabel header = new JLabel("Scoreboard");
    private JTextArea scoreArea = new JTextArea();
    private JScrollPane sp = new JScrollPane(scoreArea);

    public HighScoreWindow(){
        setUpScoreBoardLabel();
        setUpScoreBoard();
        testMethodForAddingNamesToScoreboard("Orvar Karlsson",120);
        setUpJFrame();
    }

    public void setUpScoreBoardLabel(){
        this.setLayout(new BorderLayout());
        header.setFont(new Font("SansSerif", Font.PLAIN,24));
        topPanel.add(header);
        add(topPanel,BorderLayout.NORTH);
    }

    public void setUpScoreBoard(){
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scoreArea.setEditable(false);
        sp.setPreferredSize(new Dimension(260,390));
        scoreArea.setFont(new Font("SansSerif", Font.PLAIN,14));
        add(sp,BorderLayout.CENTER);
    }

    public void testMethodForAddingNamesToScoreboard(String name, int loops){
        for(int i = 1; i < loops; i++){
            String temp = String.format("%3d. %s",i,name);
            scoreArea.append(temp + "\n");
        }
    }

    public void setUpJFrame(){
        this.setLocation(1000,150);
        this.setSize(300,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new HighScoreWindow();
    }

}

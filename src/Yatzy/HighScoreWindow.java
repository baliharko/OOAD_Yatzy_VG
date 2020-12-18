package Yatzy;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HighScoreWindow extends JFrame {

    private JPanel topPanel = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JLabel header = new JLabel("Scoreboard");
    private JTextArea scoreArea = new JTextArea();
    private JScrollPane sp = new JScrollPane(scoreArea);
    private List<Score> list;
    public JButton resetButton = new JButton("Reset Scoreboard");

    public HighScoreWindow(List<Score> list){
        this.list = list;
        setUpScoreBoardLabel();
        setUpScoreBoard();
        setUpBottomPanel();
        printToScoreboard();
        setUpJFrame();
    }

    public void setUpScoreBoardLabel(){
        this.setLayout(new BorderLayout());
        header.setFont(new Font("MonoSpaced", Font.PLAIN,24));
        topPanel.add(header);
        add(topPanel,BorderLayout.NORTH);
    }

    public void setUpScoreBoard(){
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scoreArea.setEditable(false);
        sp.setPreferredSize(new Dimension(280,390));
        scoreArea.setFont(new Font("MonoSpaced", Font.PLAIN,14));
        add(sp,BorderLayout.CENTER);
    }

    // (added) TODO setUpBottomPanel
    public void setUpBottomPanel() {
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(resetButton, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public void printToScoreboard(){
        for(int i = 0; i < list.size(); i++){
            String nr = String.format("%-4d",(i+1));
            String line = nr + list.get(i).toString() + "\n";
            scoreArea.append(line);
        }
    }

    public void setUpJFrame(){
        this.setLocation(1000,150);
        this.setSize(320,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}

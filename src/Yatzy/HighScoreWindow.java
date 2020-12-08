package Yatzy;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HighScoreWindow extends JFrame {

    private JPanel topPanel = new JPanel();
    private JLabel header = new JLabel("Scoreboard");
    private JTextArea scoreArea = new JTextArea();
    private JScrollPane sp = new JScrollPane(scoreArea);
    private List<Score> list;

    public HighScoreWindow(List<Score> list){
        this.list = list;
        setUpScoreBoardLabel();
        setUpScoreBoard();
        printToScoreboard();
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

    public void printToScoreboard(){
        for(int i = 1; i < list.size(); i++){
            scoreArea.append(i + " " + list.get(i-1).toString() + "\n");
        }
    }

    public void setUpJFrame(){
        this.setLocation(1000,150);
        this.setSize(300,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}

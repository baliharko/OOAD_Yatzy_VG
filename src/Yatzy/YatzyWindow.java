package Yatzy;

import javax.swing.*;

public class YatzyWindow extends JFrame {

    JPanel mainPanel = new JPanel();
    StartPanel startPanel = new StartPanel();
    YatzyPanel yatzyPanel = new YatzyPanel();

    public YatzyWindow(){
        setUpJFrame();
        changePanelTo(startPanel);
        setUpStartButtonListener();
    }

    public void setUpJFrame(){
        add(mainPanel);
        this.setLocation(300,150);
        this.setSize(530,530);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void changePanelTo(JPanel panel) {
        mainPanel.removeAll();
        mainPanel.add(panel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void setUpStartButtonListener(){
        startPanel.getStartGameButton().addActionListener(l -> {
            if (startPanel.getNotRankedGameButton().isSelected()){
                this.setTitle("Just playing for fun... loser");
                changePanelTo(yatzyPanel);
            }
            else if (startPanel.getRankedGameButton().isSelected()){
                if (startPanel.getNameField().getText().length() > 2){
                    this.setTitle("Name: " + startPanel.getNameField().getText());
                    changePanelTo(yatzyPanel);
                }
                else System.out.println("Du måste ange ett namn/alias med minst 3 tecken.");
            }
        });
    }

    public static void main(String[] args) {
        new YatzyWindow(); // Bara här nu för test syfte
    }

}

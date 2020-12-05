package Yatzy;

import javax.swing.*;

public class YatzyWindow extends JFrame {

    JPanel mainPanel = new JPanel();
    StartPanel startPanel = new StartPanel();
    YatzyPanel yatzyPanel = new YatzyPanel();
    JButton startButton;
    JToggleButton rankedGame; //

    public YatzyWindow(){
        startButton = startPanel.startGameButton;
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
        startButton.addActionListener(l -> {
            if(startPanel.getNameField().getText().length() > 2){
                System.out.println("Välkommen: " + startPanel.getNameField().getText());
                changePanelTo(yatzyPanel);
            }
            else System.out.println("Du måste ange ett namn/alias med minst 3 tecken.");
        });
    }

    public static void main(String[] args) {
        new YatzyWindow(); // Bara här nu för test syfte
    }

}

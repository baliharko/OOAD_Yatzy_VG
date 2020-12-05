package Yatzy;

import javax.swing.*;

public class YatzyWindow extends JFrame {

    JPanel mainPanel = new JPanel();
    YatzyPanel yatzyPanel = new YatzyPanel();
    StartPanel startPanel = new StartPanel();

    public YatzyWindow(){
        setUpJFrame();
        changePanelTo(startPanel);
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

    public static void main(String[] args) {
        new YatzyWindow(); // Bara här nu för test syfte
    }

}

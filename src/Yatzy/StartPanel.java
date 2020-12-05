package Yatzy;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {

    /*****************************************************************
     * Färger på alla paneler finns just nu bara så att man lätt ska kunna se skillnad mellan panelers avstånd mm. // TD
     */

    // Backgroundcolor
    Color color = Color.GREEN;

    // Panels
    JPanel topPanel = new JPanel(new GridLayout(1,2,10,10));
    JPanel middlePanel = new JPanel();
    JPanel bottomPanel = new JPanel(); // new GridLayout(1,1)

    // Buttons
    JToggleButton rankedGameButton = new JToggleButton("Ranked Game");
    JToggleButton notRankedGameButton = new JToggleButton("Not ranked Game");
    JButton startGame = new JButton("Start Game");

    // Textfield
    JTextField nameField = new JTextField(14);

    public StartPanel(){
        setUpThisJPanel();
        setUpJPanels();
        setUpAndAddToggleButtons();
        setUpAndAddTextfield();
        setUpAndAddStartGameButton();

        this.revalidate();
        this.repaint();
    }

    public void setUpThisJPanel(){
        this.setBackground(color);  // TestFärg
        this.setLayout(new GridLayout(3,1,10,10));
        this.setPreferredSize(new Dimension(500, 480));
    }

    public void setUpJPanels(){
        topPanel.setOpaque(false);
        middlePanel.setOpaque(false);
        bottomPanel.setOpaque(false);
        this.add(topPanel);
        this.add(middlePanel);
        this.add(bottomPanel);
    }

    public void setUpAndAddToggleButtons(){
        rankedGameButton.setOpaque(true);
        rankedGameButton.setBorder(BorderFactory.createLineBorder(color,40));
        rankedGameButton.setFont(new Font("SansSerif", Font.BOLD,20));
        notRankedGameButton.setOpaque(true);
        notRankedGameButton.setBorder(BorderFactory.createLineBorder(color,40));
        notRankedGameButton.setFont(new Font("SansSerif", Font.BOLD,20));
        topPanel.add(rankedGameButton);
        topPanel.add(notRankedGameButton);
    }

    public void setUpAndAddTextfield(){
        nameField.setHorizontalAlignment(SwingConstants.CENTER);
        nameField.setFont(new Font("SansSerif",Font.ITALIC,25));
        middlePanel.add(nameField, CENTER_ALIGNMENT);
    }

    public void setUpAndAddStartGameButton(){
        startGame.setFont(new Font("SansSerif", Font.BOLD,20));
        bottomPanel.add(startGame);
    }

}

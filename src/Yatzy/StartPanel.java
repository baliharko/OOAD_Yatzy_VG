package Yatzy;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class StartPanel extends JPanel {

    /*****************************************************************
     * Färger på alla paneler finns just nu bara så att man lätt ska kunna se skillnad mellan panelers avstånd mm. // TD
     */

    // Backgroundcolor
    Color color = Color.GREEN; // Test Färg

    // Panels
    JPanel topPanel = new JPanel(new GridLayout(1,2,10,10));
    JPanel middlePanel = new JPanel();
    JPanel bottomPanel = new JPanel(); // new GridLayout(1,1)

    // Buttons
    JToggleButton rankedGameButton = new JToggleButton("Ranked Game");
    JToggleButton notRankedGameButton = new JToggleButton("Not ranked Game");
    JButton startGameButton = new JButton("Start Game");

    // Textfield
    JTextField nameField = new JTextField("",14);

    // Label
    JLabel nameLabel = new JLabel("Enter your name: ");

    public StartPanel(){
        setUpThisJPanel();
        setUpJPanels();
        setUpAndAddToggleButtons();
        setUpAndAddLabel();
        setUpAndAddTextfield();
        setUpAndAddStartGameButton();
        setUpToggleListener();

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
        rankedGameButton.setBorder(BorderFactory.createLineBorder(color,30));
        rankedGameButton.setFont(new Font("SansSerif", Font.BOLD,20));
        notRankedGameButton.setOpaque(true);
        notRankedGameButton.setBorder(BorderFactory.createLineBorder(color,30));
        notRankedGameButton.setFont(new Font("SansSerif", Font.BOLD,20));
        topPanel.add(rankedGameButton);
        topPanel.add(notRankedGameButton);
    }

    public void setUpAndAddLabel(){
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 25));
        nameLabel.setVisible(false);
        middlePanel.add(nameLabel, CENTER_ALIGNMENT);
    }

    public void setUpAndAddTextfield(){
        nameField.setHorizontalAlignment(SwingConstants.CENTER);
        nameField.setFont(new Font("SansSerif",Font.ITALIC,25));
        nameField.setVisible(false);
        middlePanel.add(nameField, CENTER_ALIGNMENT);
    }

    public void setUpAndAddStartGameButton(){
        startGameButton.setFont(new Font("SansSerif", Font.BOLD,20));
        startGameButton.setEnabled(false);
        bottomPanel.add(startGameButton);
    }

    public void setUpToggleListener(){
        rankedGameButton.addActionListener(l -> {
            if(rankedGameButton.isSelected()){
                notRankedGameButton.setSelected(false);
                nameField.setVisible(true);
                startGameButton.setEnabled(true);
                rankedGameButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 30));
                notRankedGameButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,30));
                this.setBackground(Color.LIGHT_GRAY);
                nameLabel.setVisible(true);
                repaintTextField();
            }
            else if(!rankedGameButton.isSelected()){
                nameField.setVisible(false);
                nameLabel.setVisible(false);
                rankedGameButton.setBorder(BorderFactory.createLineBorder(color, 30));
                notRankedGameButton.setBorder(BorderFactory.createLineBorder(color,30));
                this.setBackground(color);
                startGameButton.setEnabled(false);
                repaintTextField();
            }
        });
        notRankedGameButton.addActionListener(l -> {
            if(notRankedGameButton.isSelected()){
                rankedGameButton.setSelected(false);
                nameField.setVisible(false);
                nameLabel.setVisible(false);
                notRankedGameButton.setBorder(BorderFactory.createLineBorder(Color.PINK,30));
                rankedGameButton.setBorder(BorderFactory.createLineBorder(Color.PINK, 30));
                this.setBackground(Color.PINK);
                startGameButton.setEnabled(true);
                repaintTextField();
            }
            else if(!notRankedGameButton.isSelected()){
                startGameButton.setEnabled(false);
                rankedGameButton.setBorder(BorderFactory.createLineBorder(color, 30));
                notRankedGameButton.setBorder(BorderFactory.createLineBorder(color,30));
                this.setBackground(color);
            }
        });
    }

    private void repaintTextField(){
        middlePanel.revalidate();
        middlePanel.repaint();
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JToggleButton getRankedGameButton() {
        return rankedGameButton;
    }

    public JToggleButton getNotRankedGameButton() {
        return notRankedGameButton;
    }

    public JButton getStartGameButton() {
        return startGameButton;
    }
}

package Window;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Window extends JFrame {

    JTable table = new JTable(8, 2);
    JPanel panel = new JPanel(new GridLayout(1, 3));
    JPanel tablePanel = new JPanel(new BorderLayout());
    JLabel label1 = new JLabel("Omgång          Poäng");
    JPanel buttonPanel = new JPanel();
    JToggleButton[] dice;
    Random rng = new Random();



    public Window() {
        this.setLayout(new BorderLayout());
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table.setRowHeight(51);
        table.setGridColor(Color.BLACK);

        panel.add(new JButton("Kasta"));
        panel.add(new JButton("Spara highscore"));
        panel.add(new JButton("Se highscore"));
        tablePanel.add(label1, BorderLayout.NORTH);
        tablePanel.add(table, BorderLayout.CENTER);

        dice = toggleButtons();

        this.add(panel, BorderLayout.SOUTH);
        this.add(tablePanel, BorderLayout.EAST);

        this.setSize(new Dimension(400, 480));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public JToggleButton[] toggleButtons() {
        JToggleButton[] out = new JToggleButton[5];

        for (int i = 0; i < 5; i++) {
            out[i] = new JToggleButton("" + rng.nextInt(5) + 1);

        }
        return out;
    }

    public static void main(String[] args) {
        new Window();
    }
}
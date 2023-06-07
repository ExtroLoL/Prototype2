package cafe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageFrame extends JFrame {
    public HomePageFrame() {
        setTitle("Kopitiam Maju");
        setSize(300, 200);
        setLayout(new BorderLayout());

        JPanel textPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to Kopitiam Maju Bossku!");
        textPanel.add(welcomeLabel);

        JPanel buttonPanel = new JPanel();
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame menuFrame = new MenuFrame();
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.setVisible(true);
            }
        });
        buttonPanel.add(enterButton);

        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}

/**
 * the frame for the home page
 *
 * @author iqmalsukeri
 */

package cafe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageFrame extends JFrame {
    public HomePageFrame() {
        setTitle("Cafe Home");
        setSize(300, 200);
        setLayout(new BorderLayout());

        // Panel to hold the welcome text
        JPanel textPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to the Cafe!");
        textPanel.add(welcomeLabel);

        // Panel to hold the Enter button
        JPanel buttonPanel = new JPanel();
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dispose the Home Page frame and display the enu frame
                dispose();
                JFrame menuFrame = new MenuFrame();
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.setVisible(true);
            }
        });
        buttonPanel.add(enterButton);

        // add panels to the frame
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}

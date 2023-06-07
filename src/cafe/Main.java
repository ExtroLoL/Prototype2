package cafe;

import javax.swing.*;

// Run the Code on this class

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame homePageFrame = new HomePageFrame();
                homePageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                homePageFrame.setVisible(true);
            }
        });
    }
}

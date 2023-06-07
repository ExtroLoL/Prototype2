package cafe;

import javax.swing.*;

// Run the code here
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // displaying the home page
                JFrame homePageFrame = new HomePageFrame();
                homePageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                homePageFrame.setVisible(true);
            }
        });
    }
}

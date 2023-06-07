/**
 * the main class that launches the cafe application
 * it displays the home page
 * @author iqmalsukeri
 */

package cafe;

import javax.swing.*;

public class CafeKiosk {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame homeFrame = new cafe.HomePageFrame();
            homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            homeFrame.setVisible(true);
        });
    }
}

package cafe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MenuFrame extends JFrame {
    private JLabel totalLabel;
    private double totalAmount;
    private Map<String, Integer> orderItems;

    public MenuFrame() {
        setTitle("Cafe Menu");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel(new GridLayout(4, 2));

        JPanel beveragesPanel = new JPanel(new GridLayout(0, 1));
        JLabel beveragesLabel = new JLabel("Beverages");
        beveragesPanel.add(beveragesLabel);

        String[] beverageItems = {"Coffee", "Tea", "Juice"};
        for (String item : beverageItems) {
            JButton button = new JButton(item + " - RM" + MenuItems.getPrice(item));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String selectedItem = button.getText();
                    String itemName = selectedItem.substring(0, selectedItem.indexOf(" - "));
                    double itemPrice = MenuItems.getPrice(itemName);

                    String quantityString = JOptionPane.showInputDialog(null, "Enter quantity for " + itemName + ":");
                    if (quantityString != null && !quantityString.isEmpty()) {
                        try {
                            int quantity = Integer.parseInt(quantityString);
                            totalAmount += itemPrice * quantity;
                            totalLabel.setText("Total: RM" + String.format("%.2f", totalAmount));
                            orderItems.put(itemName, quantity);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid quantity entered!");
                        }
                    }
                }
            });
            beveragesPanel.add(button);
        }
        menuPanel.add(beveragesPanel);

        JPanel foodsPanel = new JPanel(new GridLayout(0, 1));
        JLabel foodsLabel = new JLabel("Foods");
        foodsPanel.add(foodsLabel);

        String[] foodItems = {"Sandwich", "Cake", "Salad"};
        for (String item : foodItems) {
            JButton button = new JButton(item + " - RM" + MenuItems.getPrice(item));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String selectedItem = button.getText();
                    String itemName = selectedItem.substring(0, selectedItem.indexOf(" - "));
                    double itemPrice = MenuItems.getPrice(itemName);

                    String quantityString = JOptionPane.showInputDialog(null, "Enter quantity for " + itemName + ":");
                    if (quantityString != null && !quantityString.isEmpty()) {
                        try {
                            int quantity = Integer.parseInt(quantityString);
                            totalAmount += itemPrice * quantity;
                            totalLabel.setText("Total: RM" + String.format("%.2f", totalAmount));
                            orderItems.put(itemName, quantity);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid quantity entered!");
                        }
                    }
                }
            });
            foodsPanel.add(button);
        }
        menuPanel.add(foodsPanel);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                double totalAmountWithTax = calculateTotalAmountWithTax(totalAmount);
                JFrame checkoutFrame = new cafe.CheckoutFrame(totalAmountWithTax, orderItems);
                checkoutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                checkoutFrame.setVisible(true);
            }
        });

        totalLabel = new JLabel("Total: RM0.00");
        orderItems = new HashMap<>();

        add(menuPanel, BorderLayout.CENTER);
        add(totalLabel, BorderLayout.SOUTH);
        add(checkoutButton, BorderLayout.EAST);
    }

    private double calculateTotalAmountWithTax(double totalAmount) {
        double serviceTaxRate = 0.06; // GST 6%
        double serviceTax = totalAmount * serviceTaxRate;
        return totalAmount + serviceTax;
    }
}

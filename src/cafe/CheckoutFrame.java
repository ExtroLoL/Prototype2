package cafe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class CheckoutFrame extends JFrame {
    private JLabel totalLabel;
    private JLabel serviceTaxLabel;
    private JLabel finalTotalLabel;
    private JComboBox<String> paymentComboBox;
    private JButton repeatButton;

    public CheckoutFrame(double totalAmount, Map<String, Integer> orderItems) {
        setTitle("Checkout");
        setSize(300, 250);
        setLayout(new BorderLayout());

        // Panel for payment method selection
        JPanel paymentPanel = new JPanel();
        JLabel paymentLabel = new JLabel("Payment Method:");
        String[] paymentOptions = {"Credit Card", "Cash", "Mobile Payment"};
        paymentComboBox = new JComboBox<>(paymentOptions);
        paymentPanel.add(paymentLabel);
        paymentPanel.add(paymentComboBox);

        // Panel for order details
        JPanel orderPanel = new JPanel(new BorderLayout());
        JTextArea orderTextArea = new JTextArea();
        orderTextArea.setEditable(false);
        for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            orderTextArea.append("- " + itemName + " x" + quantity + "\n");
        }
        JScrollPane scrollPane = new JScrollPane(orderTextArea);
        orderPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel for total, service tax, and final total
        JPanel totalPanel = new JPanel(new GridLayout(3, 2));
        totalLabel = new JLabel("Total: RM" + String.format("%.2f", totalAmount));
        serviceTaxLabel = new JLabel("Service Tax (6%): RM" + String.format("%.2f", calculateServiceTax(totalAmount)));
        finalTotalLabel = new JLabel("Final Total: RM" + String.format("%.2f", calculateFinalTotal(totalAmount)));
        totalPanel.add(new JLabel(""));
        totalPanel.add(new JLabel(""));
        totalPanel.add(totalLabel);
        totalPanel.add(serviceTaxLabel);
        totalPanel.add(finalTotalLabel);
        totalPanel.add(new JLabel(""));

        // Panel for repeat and confirm buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        repeatButton = new JButton("Repeat Order");
        repeatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Dispose the Checkout frame and display the Menu frame again
                dispose();
                JFrame menuFrame = new MenuFrame();
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.setVisible(true);
            }
        });
        JButton confirmButton = new JButton("Confirm Payment");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle confirm button click event
                String paymentMethod = (String) paymentComboBox.getSelectedItem();


                // display payment confirmed message
                JOptionPane.showMessageDialog(null, "Payment confirmed!");

                // dispose checkout frame
                dispose();
            }
        });
        buttonPanel.add(repeatButton);
        buttonPanel.add(confirmButton);

        // Add panels to the frame
        add(paymentPanel, BorderLayout.NORTH);
        add(orderPanel, BorderLayout.CENTER);
        add(totalPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private double calculateServiceTax(double totalAmount) {
        double serviceTaxRate = 0.06; // GST 6%
        return totalAmount * serviceTaxRate;
    }

    private double calculateFinalTotal(double totalAmount) {
        double serviceTax = calculateServiceTax(totalAmount);
        return totalAmount + serviceTax;
    }
}

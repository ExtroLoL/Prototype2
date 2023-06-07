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

        JPanel paymentPanel = new JPanel();
        JLabel paymentLabel = new JLabel("Payment Method:");
        String[] paymentOptions = {"Credit Card", "Cash", "Mobile Payment"};
        paymentComboBox = new JComboBox<>(paymentOptions);
        paymentPanel.add(paymentLabel);
        paymentPanel.add(paymentComboBox);

        JPanel totalPanel = new JPanel(new GridLayout(3, 2));
        JLabel totalTitleLabel = new JLabel("Total:");
        totalLabel = new JLabel("RM" + String.format("%.2f", totalAmount));
        JLabel serviceTaxTitleLabel = new JLabel("Service Tax (6%):");
        double serviceTaxAmount = calculateServiceTax(totalAmount);
        serviceTaxLabel = new JLabel("RM" + String.format("%.2f", serviceTaxAmount));
        JLabel finalTotalTitleLabel = new JLabel("Final Total:");
        double finalTotalAmount = totalAmount + serviceTaxAmount;
        finalTotalLabel = new JLabel("RM" + String.format("%.2f", finalTotalAmount));
        totalPanel.add(totalTitleLabel);
        totalPanel.add(totalLabel);
        totalPanel.add(serviceTaxTitleLabel);
        totalPanel.add(serviceTaxLabel);
        totalPanel.add(finalTotalTitleLabel);
        totalPanel.add(finalTotalLabel);

        repeatButton = new JButton("Repeat Order");
        repeatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame menuFrame = new cafe.MenuFrame();
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.setVisible(true);
            }
        });

        JButton confirmButton = new JButton("Confirm Payment");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String paymentMethod = (String) paymentComboBox.getSelectedItem();

                // Perform the necessary actions based on the selected payment method
                // ...

                // Display a confirmation message
                JOptionPane.showMessageDialog(null, "Payment confirmed! Thank you for your order!");

                dispose();
            }
        });

        add(paymentPanel, BorderLayout.NORTH);
        add(totalPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(repeatButton);
        buttonPanel.add(confirmButton);
        add(buttonPanel, BorderLayout.SOUTH);

        JTextArea orderTextArea = new JTextArea();
        orderTextArea.setEditable(false);
        for (Map.Entry<String, Integer> entry : orderItems.entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            orderTextArea.append("- " + itemName + " x" + quantity + "\n");
        }
        JScrollPane scrollPane = new JScrollPane(orderTextArea);
        add(scrollPane, BorderLayout.WEST);
    }

    private double calculateServiceTax(double totalAmount) {
        double serviceTaxRate = 0.06; // GST 6%
        return totalAmount * serviceTaxRate;
    }
}

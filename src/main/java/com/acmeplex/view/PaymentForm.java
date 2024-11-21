package com.acmeplex.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class PaymentForm extends JFrame {

    public PaymentForm(String movie, String theatre, String showtime, String seat) {
        // Set up JFrame properties
        setTitle("Payment - AcmePlex");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose only this form, keep main form running
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Payment Confirmation", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(titleLabel);

        // Details Label
        JLabel detailsLabel = new JLabel("<html>Movie: " + movie + "<br>Theatre: " + theatre + 
                                         "<br>Showtime: " + showtime + "<br>Seat: " + seat + "</html>");
        detailsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(detailsLabel);

        // Spacer
        add(Box.createRigidArea(new Dimension(0, 20)));

        // Card Details Input
        JLabel cardLabel = new JLabel("Enter Card Details:");
        cardLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextField cardField = new JTextField();
        cardField.setMaximumSize(new Dimension(300, 30));
        cardField.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(cardLabel);
        add(cardField);

        // Spacer
        add(Box.createRigidArea(new Dimension(0, 20)));

        // Confirm Payment Button
        JButton confirmButton = new JButton("Confirm Payment");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmButton.addActionListener(e -> {
            if (cardField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter card details!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Payment Successful! Thank you for your purchase.", "Success", JOptionPane.INFORMATION_MESSAGE);
                dispose(); // Close this form
            }
        });

        add(confirmButton);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Test the PaymentForm independently
        SwingUtilities.invokeLater(() -> new PaymentForm("Example Movie", "Example Theatre", "7:00 PM", "Seat A1"));
    }
}

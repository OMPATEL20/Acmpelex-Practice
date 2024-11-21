package com.acmeplex.view;

import com.acmeplex.util.ApiClient;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupForm extends JFrame {
    private JTextField usernameField, nameField, addressField;
    private JPasswordField passwordField;
    private JButton signupButton;
    private JButton goToLoginButton;

    public SignupForm() {
        setTitle("Signup - AcmePlex");
        setSize(350, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Set the background color of the main frame
        getContentPane().setBackground(new Color(34, 139, 34)); // Forest Green background

        // Configure labels
        JLabel nameLabel = createLabel("Full Name:", 20, 20);
        JLabel usernameLabel = createLabel("Username:", 20, 50);
        JLabel passwordLabel = createLabel("Password:", 20, 80);
        JLabel addressLabel = createLabel("Address:", 20, 110);

        // Configure text fields
        nameField = createTextField(120, 20);
        usernameField = createTextField(120, 50);
        passwordField = new JPasswordField(20);
        passwordField.setBounds(120, 80, 160, 25);
        addressField = createTextField(120, 110);

        // Signup button
        signupButton = createButton("Signup", 120, 150, Color.DARK_GRAY);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String address = addressField.getText();

                try {
                    String response = ApiClient.signup(username, password, name, address, "ORDINARY");
                    JOptionPane.showMessageDialog(SignupForm.this, "Sign-up successful!");

                    // Redirect to Login Form after successful signup
                    new LoginForm();
                    dispose(); // Close the Signup Form
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SignupForm.this, "Error: " + ex.getMessage());
                }
            }
        });

        // Go to Login button
        goToLoginButton = createButton("Go to Login", 120, 190, Color.DARK_GRAY);

        goToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginForm(); // Open Login Form
                dispose(); // Close Signup Form
            }
        });

        // Adding components to the frame
        add(nameLabel);
        add(usernameLabel);
        add(passwordLabel);
        add(addressLabel);
        add(nameField);
        add(usernameField);
        add(passwordField);
        add(addressField);
        add(signupButton);
        add(goToLoginButton);

        setVisible(true);
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 100, 25);
        label.setForeground(Color.WHITE); // White text for better readability on green
        return label;
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField(20);
        textField.setBounds(x, y, 160, 25);
        textField.setBackground(Color.WHITE); // White background for readability
        textField.setForeground(Color.BLACK); // Black text color
        return textField;
    }

    private JButton createButton(String text, int x, int y, Color color) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 120, 25);
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SignupForm::new);
    }
}

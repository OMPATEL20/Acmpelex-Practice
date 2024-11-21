package com.acmeplex.view;
//
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Cursor;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.BorderFactory;
//import javax.swing.Box;
//import javax.swing.BoxLayout;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//import javax.swing.SwingUtilities;
//
//import com.acmeplex.util.ApiClient;
//
//public class LoginForm extends JFrame {
//    private JTextField usernameField;
//    private JPasswordField passwordField;
//    private JButton loginButton;
//    private JButton signupButton;
//
//    public LoginForm() {
//        setTitle("AcmePlex - Login");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        
//        // Set up the main panel with padding and layout
//        JPanel mainPanel = new JPanel();
//        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//        mainPanel.setBackground(new Color(60, 63, 65));
//
//        // Title Label
//        JLabel titleLabel = new JLabel("Welcome to AcmePlex");
//        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
//        titleLabel.setForeground(new Color(187, 187, 187));
//        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        mainPanel.add(titleLabel);
//        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
//
//        // Username Label and Field
//        JLabel usernameLabel = new JLabel("Username:");
//        usernameLabel.setForeground(Color.WHITE);
//        usernameField = new JTextField(20);
//        styleTextField(usernameField);
//        
//        // Password Label and Field
//        JLabel passwordLabel = new JLabel("Password:");
//        passwordLabel.setForeground(Color.WHITE);
//        passwordField = new JPasswordField(20);
//        styleTextField(passwordField);
//
//        // Button Panel
//        JPanel buttonPanel = new JPanel();
//        buttonPanel.setBackground(new Color(60, 63, 65));
//        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
//        
//        // Login Button
//        loginButton = new JButton("Login");
//        styleButton(loginButton, new Color(0, 153, 76));
//        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String username = usernameField.getText();
//                String password = new String(passwordField.getPassword());
//                try {
//                    String response = ApiClient.login(username, password);
//                    JOptionPane.showMessageDialog(LoginForm.this, response);
//                    if (response.contains("Login successful")) {
//                        dispose();
//                        // Open MainApplicationForm here
//                    }
//                } catch (Exception ex) {
//                    JOptionPane.showMessageDialog(LoginForm.this, "Error: " + ex.getMessage());
//                }
//            }
//        });
//
//        // Signup Button
//        signupButton = new JButton("Signup");
//        styleButton(signupButton, new Color(0, 102, 204));
//        signupButton.addActionListener(e -> {
//            new SignupForm();
//            dispose();
//        });
//
//        // Add Components to Panel
//        mainPanel.add(usernameLabel);
//        mainPanel.add(usernameField);
//        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
//        mainPanel.add(passwordLabel);
//        mainPanel.add(passwordField);
//        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
//
//        buttonPanel.add(loginButton);
//        buttonPanel.add(signupButton);
//        mainPanel.add(buttonPanel);
//
//        add(mainPanel);
//        setVisible(true);
//    }
//
//    private void styleTextField(JTextField textField) {
//        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height));
//        textField.setFont(new Font("SansSerif", Font.PLAIN, 16));
//        textField.setBackground(new Color(43, 43, 43));
//        textField.setForeground(Color.WHITE);
//        textField.setCaretColor(Color.WHITE);
//        textField.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createLineBorder(new Color(70, 73, 75)), 
//                BorderFactory.createEmptyBorder(5, 5, 5, 5)
//        ));
//    }
//
//    private void styleButton(JButton button, Color color) {
//        button.setBackground(color);
//        button.setForeground(Color.WHITE);
//        button.setFocusPainted(false);
//        button.setFont(new Font("SansSerif", Font.BOLD, 14));
//        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
//        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(LoginForm::new);
//    }
//}


//
//
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JTextField;
//import javax.swing.SwingUtilities;
//
//import com.acmeplex.util.ApiClient;
//
//public class LoginForm extends JFrame {
//
//    private JTextField usernameField;
//    private JPasswordField passwordField;
//    private JButton loginButton;
//
//    public LoginForm() {
//        setTitle("Login - AcmePlex");
//        setSize(300, 200);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        // UI components
//        usernameField = new JTextField(15);
//        passwordField = new JPasswordField(15);
//        loginButton = new JButton("Login");
//
//        JPanel panel = new JPanel();
//        panel.add(new JLabel("Username:"));
//        panel.add(usernameField);
//        panel.add(new JLabel("Password:"));
//        panel.add(passwordField);
//        panel.add(loginButton);
//
//        add(panel);
//
//        // Login button action
//        loginButton.addActionListener(e -> login());
//    }
//
//    private void login() {
//        String username = usernameField.getText();
//        String password = new String(passwordField.getPassword());
//
//        try {
//            // Call ApiClient to perform login
//            String response = ApiClient.login(username, password);
//
//            // Assuming "success" is returned on successful login
//            if (response.contains("Login successful")) {
//                JOptionPane.showMessageDialog(this, "Login successful!");
//
//                // Open Movie Selection Form after successful login
//                new MovieSelectionForm();  // Open the movie selection form (assumed to be another JFrame or activity)
//                dispose();  // Close the login form
//            } else {
//                JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.");
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Login failed. Please try again.");
//        }
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            new LoginForm().setVisible(true);
//        });
//    }
//}

import javax.swing.*;

import com.acmeplex.util.ApiClient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;

    public LoginForm() {
        // Set up the frame
        setTitle("AcmePlex - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up the main panel with padding and layout
        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(60, 63, 65));

        // Title Label
        JLabel titleLabel = new JLabel("Welcome to AcmePlex");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        titleLabel.setForeground(new Color(187, 187, 187));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer

        // Username Label and Field
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        usernameField = new JTextField(20);
        styleTextField(usernameField);

        // Password Label and Field
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordField = new JPasswordField(20);
        styleTextField(passwordField);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(60, 63, 65));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Login Button
        loginButton = new JButton("Login");
        styleButton(loginButton, new Color(0, 153, 76));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                try {
                    // Replace with actual login API request
                    String response = ApiClient.login(username, password);
                    JOptionPane.showMessageDialog(LoginForm.this, response);
                    if (response.contains("Login successful")) {
                        dispose();
                        // Open MainApplicationForm here
                        
                        new MovieSelectionForm();  // Open the movie selection form (assumed to be another JFrame or activity)
      dispose();
                     
                        
                        
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Error: " + ex.getMessage());
                }
            }
        });

        // Signup Button
        signupButton = new JButton("Signup");
        styleButton(signupButton, new Color(0, 102, 204));
        signupButton.addActionListener(e -> {
            new SignupForm();
            dispose();
        });

        // Add Components to Panel
        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        buttonPanel.add(loginButton);
        buttonPanel.add(signupButton);
        mainPanel.add(buttonPanel);

        add(mainPanel);
        setVisible(true);
    }

    private void styleTextField(JTextField textField) {
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getPreferredSize().height));
        textField.setFont(new Font("SansSerif", Font.PLAIN, 16));
        textField.setBackground(new Color(43, 43, 43));
        textField.setForeground(Color.WHITE);
        textField.setCaretColor(Color.WHITE);
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70, 73, 75)), 
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
    }

    private void styleButton(JButton button, Color color) {
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginForm::new);
    }
}

//package com.acmeplex.view;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//
//public class MovieSelectionForm extends JFrame {
//    private JPanel mainPanel;
//    private JComboBox<String> movieSelectorComboBox;
//    private JComboBox<String> theatreSelectionComboBox;
//    private JComboBox<String> showtimeSelectorComboBox;
//    private JPanel seatPanel;
//    private JLabel screenLabel;
//    private JButton purchaseButton;
//    private JButton showLoginFormButton;
//    private JButton signUpNavButton;
//    private JButton cancelPreviousTicketButton;
//
//    private JPanel movieSelectionPanel;
//    private JPanel loginFormPanel;
//    private JPanel signUpFormPanel;
//    private JButton[][] seats;
//    
//    
//    private String selectedSeat = ""; 
//    
//    
//    private int selectedSeatCount = 0;
//    private ArrayList<String> availableShowtimes;
//
//    public MovieSelectionForm() {
//        setTitle("Movie Selection Menu");
//        setSize(900, 700);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        movieSelectionPanel = createMovieSelectionPanel();
//       // loginFormPanel = createLoginFormPanel();
//        //signUpFormPanel = createSignUpFormPanel();
//
//        setContentPane(movieSelectionPanel);
//        setVisible(true);
//    }
//
//    private JPanel createMovieSelectionPanel() {
//        JPanel panel = new JPanel();
//        panel.setLayout(new BorderLayout());
//
//        JPanel dropdownPanel = new JPanel(new GridLayout(1, 6));
//        movieSelectorComboBox = new JComboBox<>(new String[]{"BOL BACCHAN", "GHAYAL", "OH MY GOD"});
//        theatreSelectionComboBox = new JComboBox<>(new String[]{"RAJHANSH", "DRIVIN CINEMA", "CITIPLEX"});
//        showtimeSelectorComboBox = new JComboBox<>();
//        dropdownPanel.add(new JLabel("Movie"));
//        dropdownPanel.add(movieSelectorComboBox);
//        dropdownPanel.add(new JLabel("Theatre"));
//        dropdownPanel.add(theatreSelectionComboBox);
//        dropdownPanel.add(new JLabel("Showtime"));
//        dropdownPanel.add(showtimeSelectorComboBox);
//
//        panel.add(dropdownPanel, BorderLayout.NORTH);
//
//        seatPanel = new JPanel();
//        seatPanel.setLayout(new GridLayout(10, 10, 5, 5));
//        seats = new JButton[10][10];
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                JButton seatButton = new JButton(String.format("%c%d", (char) ('A' + i), j));
//                seatButton.setPreferredSize(new Dimension(60, 60));
//                seatButton.setEnabled(false);
//                seatButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        JButton button = (JButton) e.getSource();
//                        if (button.getBackground() == Color.GREEN) {
//                            button.setBackground(null);
//                            selectedSeatCount--;
//                        } else {
//                            button.setBackground(Color.GREEN);
//                            selectedSeatCount++;
//                        }
//                        purchaseButton.setEnabled(selectedSeatCount > 0);
//                    }
//                });
//                seats[i][j] = seatButton;
//                seatPanel.add(seatButton);
//            }
//        }
//
//        screenLabel = new JLabel("Screen", JLabel.CENTER);
//        panel.add(screenLabel, BorderLayout.CENTER);
//        panel.add(seatPanel, BorderLayout.CENTER);
//
//        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
//        purchaseButton = new JButton("Purchase");
//        
//        
//        purchaseButton.addActionListener(e -> {
//            String selectedMovie = (String) movieSelectorComboBox.getSelectedItem();
//            String selectedTheatre = (String) theatreSelectionComboBox.getSelectedItem();
//            String selectedShowtime = (String) showtimeSelectorComboBox.getSelectedItem();
//           
//            
//            
//            
//            
//          
//            if (selectedSeat.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please select a seat before purchasing!", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//
//            // Redirect to PaymentForm
//            new PaymentForm(selectedMovie, selectedTheatre, selectedShowtime, selectedSeat);
//        });
//        
//        
//        
//        
//        
//        showLoginFormButton = new JButton("Show Log In Form");
//        signUpNavButton = new JButton("Sign Up");
//        cancelPreviousTicketButton = new JButton("Cancel A Ticket");
//
//        showLoginFormButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                dispose();  // Close MovieSelectionForm
//                new LoginForm(); // Open LoginForm
//            }
//        });
//
//        // Redirect "Sign Up" to LoginForm
//        signUpNavButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();  // Close current form
//                new LoginForm(); // Open LoginForm
//            }
//        });
//
//        movieSelectorComboBox.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                updateShowtimes();
//            }
//        });
//
//        theatreSelectionComboBox.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                updateShowtimes();
//            }
//        });
//
//        buttonPanel.add(purchaseButton);
//        buttonPanel.add(showLoginFormButton);
//        buttonPanel.add(signUpNavButton);
//        buttonPanel.add(cancelPreviousTicketButton);
//
//        panel.add(buttonPanel, BorderLayout.SOUTH);
//
//        return panel;
//    }
//
//    private void updateShowtimes() {
//        String selectedMovie = (String) movieSelectorComboBox.getSelectedItem();
//        String selectedTheatre = (String) theatreSelectionComboBox.getSelectedItem();
//        availableShowtimes = new ArrayList<>();
//
//        if (selectedMovie != null && selectedTheatre != null) {
//            availableShowtimes.add("7:00 AM");
//        	availableShowtimes.add("10:00 AM");
//            availableShowtimes.add("1:00 PM");
//            availableShowtimes.add("4:00 PM");
//            availableShowtimes.add("7:00 PM");
//            availableShowtimes.add("10:00 PM");
//            availableShowtimes.add("1:00 AM");
//    
//        }
//
//        showtimeSelectorComboBox.removeAllItems();
//        for (String showtime : availableShowtimes) {
//            showtimeSelectorComboBox.addItem(showtime);
//        }
//
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                seats[i][j].setEnabled(true);
//            }
//        }
//    }
//
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
////    private JPanel createLoginFormPanel() {
////        JPanel panel = new JPanel();
////        panel.setLayout(new GridLayout(3, 2, 10, 10));
////
////        JLabel usernameLabel = new JLabel("Username:");
////        JTextField usernameField = new JTextField();
////        JLabel passwordLabel = new JLabel("Password:");
////        JPasswordField passwordField = new JPasswordField();
////        JButton loginButton = new JButton("Login");
////
////        loginButton.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                System.out.println("Logging in...");
////                setContentPane(movieSelectionPanel);
////                revalidate();
////                repaint();
////            }
////        });
//
////        panel.add(usernameLabel);
////        panel.add(usernameField);
////        panel.add(passwordLabel);
////        panel.add(passwordField);
////        panel.add(loginButton);
////
////        return panel;
////    }
//
////    private JPanel createSignUpFormPanel() {
////        JPanel panel = new JPanel();
////        panel.setLayout(new GridLayout(3, 2, 10, 10));
////
////        JLabel emailLabel = new JLabel("Email:");
////        JTextField emailField = new JTextField();
////        JLabel passwordLabel = new JLabel("Password:");
////        JPasswordField passwordField = new JPasswordField();
////        JButton signUpButton = new JButton("Sign Up");
////
////        signUpButton.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                System.out.println("Signing up...");
////                setContentPane(movieSelectionPanel);
////                revalidate();
////                repaint();
////            }
////        });
////
////        panel.add(emailLabel);
////        panel.add(emailField);
////        panel.add(passwordLabel);
////        panel.add(passwordField);
////        panel.add(signUpButton);
////
////        return panel;
////    }
//
//    public static void main(String[] args) {
//        new MovieSelectionForm();
//    }
//}
//
//
//
//
//
////import java.awt.BorderLayout;
////import java.awt.Color;
////import java.awt.Dimension;
////import java.awt.GridLayout;
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////import java.util.ArrayList;
////
////import javax.swing.JButton;
////import javax.swing.JComboBox;
////import javax.swing.JFrame;
////import javax.swing.JLabel;
////import javax.swing.JPanel;
////
////public class MovieSelectionForm extends JFrame {
////    private JPanel mainPanel;
////    private JComboBox<String> movieSelectorComboBox;
////    private JComboBox<String> theatreSelectionComboBox;
////    private JComboBox<String> showtimeSelectorComboBox;
////    private JPanel seatPanel;
////    private JLabel screenLabel;
////    private JButton purchaseButton;
////    private JButton showLoginFormButton;
////    private JButton signUpNavButton;
////    private JButton cancelPreviousTicketButton;
////
////    private JPanel movieSelectionPanel;
////    private JPanel loginFormPanel;
////    private JPanel signUpFormPanel;
////    private JButton[][] seats;
////
////    private int selectedSeatCount = 0;
////    private ArrayList<String> availableShowtimes;
////
////    public MovieSelectionForm() {
////        setTitle("Movie Selection Menu");
////        setSize(900, 700);
////        setDefaultCloseOperation(EXIT_ON_CLOSE);
////        setLayout(new BorderLayout());
////
////        movieSelectionPanel = createMovieSelectionPanel();
////       // loginFormPanel = createLoginFormPanel();
////        //signUpFormPanel = createSignUpFormPanel();
////
////        setContentPane(movieSelectionPanel);
////        setVisible(true);
////    }
////
////    private JPanel createMovieSelectionPanel() {
////        JPanel panel = new JPanel();
////        panel.setLayout(new BorderLayout());
////
////        JPanel dropdownPanel = new JPanel(new GridLayout(1, 6));
////        movieSelectorComboBox = new JComboBox<>(new String[]{"BOL BACCHAN", "GHAYAL", "OH MY GOD"});
////        theatreSelectionComboBox = new JComboBox<>(new String[]{"RAJHANSH", "DRIVIN CINEMA", "CITIPLEX"});
////        showtimeSelectorComboBox = new JComboBox<>();
////        dropdownPanel.add(new JLabel("Movie"));
////        dropdownPanel.add(movieSelectorComboBox);
////        dropdownPanel.add(new JLabel("Theatre"));
////        dropdownPanel.add(theatreSelectionComboBox);
////        dropdownPanel.add(new JLabel("Showtime"));
////        dropdownPanel.add(showtimeSelectorComboBox);
////
////        panel.add(dropdownPanel, BorderLayout.NORTH);
////
////        seatPanel = new JPanel();
////        seatPanel.setLayout(new GridLayout(10, 10, 5, 5));
////        seats = new JButton[10][10];
////        for (int i = 0; i < 10; i++) {
////            for (int j = 0; j < 10; j++) {
////                JButton seatButton = new JButton(String.format("%c%d", (char) ('A' + i), j));
////                seatButton.setPreferredSize(new Dimension(60, 60));
////                seatButton.setEnabled(false);
////                seatButton.addActionListener(new ActionListener() {
////                    @Override
////                    public void actionPerformed(ActionEvent e) {
////                        JButton button = (JButton) e.getSource();
////                        if (button.getBackground() == Color.GREEN) {
////                            button.setBackground(null);
////                            selectedSeatCount--;
////                        } else {
////                            button.setBackground(Color.GREEN);
////                            selectedSeatCount++;
////                        }
////                        purchaseButton.setEnabled(selectedSeatCount > 0);
////                    }
////                });
////                seats[i][j] = seatButton;
////                seatPanel.add(seatButton);
////            }
////        }
////
////        screenLabel = new JLabel("Screen", JLabel.CENTER);
////        panel.add(screenLabel, BorderLayout.CENTER);
////        panel.add(seatPanel, BorderLayout.CENTER); 
////
////        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
////        purchaseButton = new JButton("Purchase");
////        
////        
////        
////        
////        showLoginFormButton = new JButton("Show Log In Form");
////        signUpNavButton = new JButton("Sign Up");
////        cancelPreviousTicketButton = new JButton("Cancel A Ticket");
////
////        showLoginFormButton.addActionListener(new ActionListener() {
////            public void actionPerformed(ActionEvent e) {
////                dispose();  // Close MovieSelectionForm
////                new LoginForm(); // Open LoginForm
////            }
////        });
////
////        // Redirect "Sign Up" to LoginForm
////        signUpNavButton.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                dispose();  // Close current form
////                new LoginForm(); // Open LoginForm
////            }
////        });
////
////        movieSelectorComboBox.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                updateShowtimes();
////            }
////        });
////
////        theatreSelectionComboBox.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                updateShowtimes();
////            }
////        });
////
////        buttonPanel.add(purchaseButton);
////        buttonPanel.add(showLoginFormButton);
////        buttonPanel.add(signUpNavButton);
////        buttonPanel.add(cancelPreviousTicketButton);
////
////        panel.add(buttonPanel, BorderLayout.SOUTH);
////
////        return panel;
////    }
////
////    private void updateShowtimes() {
////        String selectedMovie = (String) movieSelectorComboBox.getSelectedItem();
////        String selectedTheatre = (String) theatreSelectionComboBox.getSelectedItem();
////        availableShowtimes = new ArrayList<>();
////
////        if (selectedMovie != null && selectedTheatre != null) {
////            availableShowtimes.add("7:00 AM");
////        	availableShowtimes.add("10:00 AM");
////            availableShowtimes.add("1:00 PM");
////            availableShowtimes.add("4:00 PM");
////            availableShowtimes.add("7:00 PM");
////            availableShowtimes.add("10:00 PM");
////            availableShowtimes.add("1:00 AM");
////    
////        }
////
////        showtimeSelectorComboBox.removeAllItems();
////        for (String showtime : availableShowtimes) {
////            showtimeSelectorComboBox.addItem(showtime);
////        }
////
////        for (int i = 0; i < 10; i++) {
////            for (int j = 0; j < 10; j++) {
////                seats[i][j].setEnabled(true);
////            }
////        }
////    }
////}




package com.acmeplex.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MovieSelectionForm extends JFrame {
    private JPanel mainPanel;
    private JComboBox<String> movieSelectorComboBox;
    private JComboBox<String> theatreSelectionComboBox;
    private JComboBox<String> showtimeSelectorComboBox;
    private JPanel seatPanel;
    private JLabel screenLabel;
    private JButton purchaseButton;
    private JButton showLoginFormButton;
    private JButton signUpNavButton;
    private JButton cancelPreviousTicketButton;

    private JPanel movieSelectionPanel;
    private JButton[][] seats;

    private String selectedSeat = ""; // Tracks selected seat(s)
    private int selectedSeatCount = 0; // Count of selected seats
    private ArrayList<String> availableShowtimes;

    public MovieSelectionForm() {
        setTitle("Movie Selection Menu");
        setSize(900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        movieSelectionPanel = createMovieSelectionPanel();

        setContentPane(movieSelectionPanel);
        setVisible(true);
    }

    private JPanel createMovieSelectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Dropdowns for Movie, Theatre, and Showtime
        JPanel dropdownPanel = new JPanel(new GridLayout(1, 6));
        movieSelectorComboBox = new JComboBox<>(new String[]{"BOL BACCHAN", "GHAYAL", "OH MY GOD"});
        theatreSelectionComboBox = new JComboBox<>(new String[]{"RAJHANSH", "DRIVIN CINEMA", "CITIPLEX"});
        showtimeSelectorComboBox = new JComboBox<>();
        dropdownPanel.add(new JLabel("Movie"));
        dropdownPanel.add(movieSelectorComboBox);
        dropdownPanel.add(new JLabel("Theatre"));
        dropdownPanel.add(theatreSelectionComboBox);
        dropdownPanel.add(new JLabel("Showtime"));
        dropdownPanel.add(showtimeSelectorComboBox);

        panel.add(dropdownPanel, BorderLayout.NORTH);

        // Seat Selection Panel
        seatPanel = new JPanel();
        seatPanel.setLayout(new GridLayout(10, 10, 5, 5));
        seats = new JButton[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                JButton seatButton = new JButton(String.format("%c%d", (char) ('A' + i), j));
                seatButton.setPreferredSize(new Dimension(60, 60));
                seatButton.setEnabled(false); // Initially disabled
                seatButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        String seat = button.getText();

                        if (button.getBackground() == Color.GREEN) {
                            button.setBackground(null);
                            selectedSeatCount--;
                            selectedSeat = selectedSeat.replace(seat + ", ", ""); // Remove seat
                        } else {
                            button.setBackground(Color.GREEN);
                            selectedSeatCount++;
                            selectedSeat += seat + ", "; // Add seat
                        }

                        purchaseButton.setEnabled(selectedSeatCount > 0);
                    }
                });
                seats[i][j] = seatButton;
                seatPanel.add(seatButton);
            }
        }

        screenLabel = new JLabel("Screen", JLabel.CENTER);
        panel.add(screenLabel, BorderLayout.CENTER);
        panel.add(seatPanel, BorderLayout.CENTER);

        // Buttons for Actions
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        purchaseButton = new JButton("Purchase");
        purchaseButton.setEnabled(false); // Disabled initially

        purchaseButton.addActionListener(e -> {
            String selectedMovie = (String) movieSelectorComboBox.getSelectedItem();
            String selectedTheatre = (String) theatreSelectionComboBox.getSelectedItem();
            String selectedShowtime = (String) showtimeSelectorComboBox.getSelectedItem();

            // Remove trailing comma and space from selectedSeat
            if (!selectedSeat.isEmpty() && selectedSeat.endsWith(", ")) {
                selectedSeat = selectedSeat.substring(0, selectedSeat.length() - 2);
            }

            if (selectedSeat.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select a seat before purchasing!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this,
                "Movie: " + selectedMovie + "\nTheatre: " + selectedTheatre +
                "\nShowtime: " + selectedShowtime + "\nSeat(s): " + selectedSeat,
                "Purchase Confirmation",
                JOptionPane.INFORMATION_MESSAGE);

            // Example: Proceed to PaymentForm
            new PaymentForm(selectedMovie, selectedTheatre, selectedShowtime, selectedSeat);
        });

        // Other buttons
        showLoginFormButton = new JButton("Show Log In Form");
        showLoginFormButton.addActionListener(e -> {
            dispose();
            new LoginForm(); // Open Login Form
        });

        signUpNavButton = new JButton("Sign Up");
        signUpNavButton.addActionListener(e -> {
            dispose();
            new LoginForm(); // Redirect to LoginForm for simplicity
        });

        cancelPreviousTicketButton = new JButton("Cancel A Ticket");

        buttonPanel.add(purchaseButton);
        buttonPanel.add(showLoginFormButton);
        buttonPanel.add(signUpNavButton);
        buttonPanel.add(cancelPreviousTicketButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Update Showtimes on Dropdown Change
        movieSelectorComboBox.addActionListener(e -> updateShowtimes());
        theatreSelectionComboBox.addActionListener(e -> updateShowtimes());

        return panel;
    }

    private void updateShowtimes() {
        String selectedMovie = (String) movieSelectorComboBox.getSelectedItem();
        String selectedTheatre = (String) theatreSelectionComboBox.getSelectedItem();
        availableShowtimes = new ArrayList<>();

        if (selectedMovie != null && selectedTheatre != null) {
            availableShowtimes.add("7:00 AM");
            availableShowtimes.add("10:00 AM");
            availableShowtimes.add("1:00 PM");
            availableShowtimes.add("4:00 PM");
            availableShowtimes.add("7:00 PM");
            availableShowtimes.add("10:00 PM");
            availableShowtimes.add("1:00 AM");
        }

        showtimeSelectorComboBox.removeAllItems();
        for (String showtime : availableShowtimes) {
            showtimeSelectorComboBox.addItem(showtime);
        }

        // Enable all seat buttons
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                seats[i][j].setEnabled(true);
                seats[i][j].setBackground(null); // Reset seat colors
            }
        }

        // Reset selected seat details
        selectedSeat = "";
        selectedSeatCount = 0;
        purchaseButton.setEnabled(false);
    }

    public static void main(String[] args) {
        new MovieSelectionForm();
    }
}

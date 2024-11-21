package com.acmeplex.view;
//
//import java.awt.BorderLayout;
//import java.util.List;
//
//import javax.swing.DefaultListModel;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JList;
//import javax.swing.JOptionPane;
//import javax.swing.JScrollPane;
//
//import com.acmeplex.model.Showtime;
//import com.acmeplex.util.ApiClient;
//
//public class ShowtimeSelectionForm extends JFrame {
//
//    private JList<String> showtimeList;
//    private DefaultListModel<String> showtimeListModel;
//    private List<Showtime> showtimes;
//    private Long movieId;
//
//    public ShowtimeSelectionForm(Long movieId) {
//        this.movieId = movieId;
//        setTitle("Select a Showtime");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        showtimeListModel = new DefaultListModel<>();
//        showtimeList = new JList<>(showtimeListModel);
//        add(new JScrollPane(showtimeList), BorderLayout.CENTER);
//
//        JButton selectShowtimeButton = new JButton("Select Showtime");
//        selectShowtimeButton.addActionListener(e -> {
//            int selectedIndex = showtimeList.getSelectedIndex();
//            if (selectedIndex != -1) {
//                new SeatSelectionForm(showtimes.get(selectedIndex).getShowtimeId());
//                dispose();
//            }
//        });
//
//        add(selectShowtimeButton, BorderLayout.SOUTH);
//        loadShowtimes();
//        setVisible(true);
//    }
//
//    private void loadShowtimes() {
//        try {
//            showtimes = ApiClient.getShowtimes(movieId);
//            for (Showtime showtime : showtimes) {
//                showtimeListModel.addElement(showtime.getTime().toString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Failed to load showtimes.");
//        }
//    }
//}

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.acmeplex.model.Showtime;
import com.acmeplex.util.ApiClient;

public class ShowtimeSelectionForm extends JFrame {

    private JList<String> showtimeList;
    private DefaultListModel<String> showtimeListModel;
    private List<Showtime> showtimes;
    private Long movieId;

    public ShowtimeSelectionForm(Long movieId) {
        this.movieId = movieId;
        setTitle("Select a Showtime");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        showtimeListModel = new DefaultListModel<>();
        showtimeList = new JList<>(showtimeListModel);
        add(new JScrollPane(showtimeList), BorderLayout.CENTER);

        JButton selectShowtimeButton = new JButton("Select Showtime");
        selectShowtimeButton.addActionListener(e -> {
            int selectedIndex = showtimeList.getSelectedIndex();
            if (selectedIndex != -1) {
                // Open Seat Selection Form after selecting a showtime
                new SeatSelectionForm(showtimes.get(selectedIndex).getShowtimeId());
                dispose(); // Close the showtime selection form
            }
        });

        add(selectShowtimeButton, BorderLayout.SOUTH);
        loadShowtimes();
        setVisible(true);
    }

    private void loadShowtimes() {
        try {
            showtimes = ApiClient.getShowtimes(movieId);
            for (Showtime showtime : showtimes) {
                showtimeListModel.addElement(showtime.getTime().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load showtimes.");
        }
    }
}


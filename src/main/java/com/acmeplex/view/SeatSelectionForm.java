package com.acmeplex.view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import com.acmeplex.model.Seat;
import com.acmeplex.util.ApiClient;

public class SeatSelectionForm extends JFrame {

    private JList<String> seatList;
    private DefaultListModel<String> seatListModel;
    private List<Seat> seats;
    private Long showtimeId;

    public SeatSelectionForm(Long showtimeId) {
        this.showtimeId = showtimeId;
        setTitle("Select a Seat");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        seatListModel = new DefaultListModel<>();
        seatList = new JList<>(seatListModel);
        add(new JScrollPane(seatList), BorderLayout.CENTER);

        JButton reserveSeatButton = new JButton("Reserve Seat");
        reserveSeatButton.addActionListener(e -> {
            int selectedIndex = seatList.getSelectedIndex();
            if (selectedIndex != -1) {
                JOptionPane.showMessageDialog(this, "Seat reserved successfully.");
            }
        });

        add(reserveSeatButton, BorderLayout.SOUTH);
        loadSeats();
        setVisible(true);
    }

    private void loadSeats() {
        try {
            seats = ApiClient.getSeats(showtimeId);
            for (Seat seat : seats) {
                seatListModel.addElement("Row: " + seat.getRowNumber() + " Col: " + seat.getColNumber() + " Reserved: " + seat.isReserved());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load seats.");
        }
    }
}



// NOT IMP 

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
//import com.acmeplex.model.Seat;
//import com.acmeplex.util.ApiClient;
//
//public class SeatSelectionForm extends JFrame {
//
//    private JList<String> seatList;
//    private DefaultListModel<String> seatListModel;
//    private List<Seat> seats;
//    private Long showtimeId;
//
//    public SeatSelectionForm(Long showtimeId) {
//        this.showtimeId = showtimeId;
//        setTitle("Select a Seat");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        seatListModel = new DefaultListModel<>();
//        seatList = new JList<>(seatListModel);
//        add(new JScrollPane(seatList), BorderLayout.CENTER);
//
//        JButton reserveSeatButton = new JButton("Reserve Seat");
//        reserveSeatButton.addActionListener(e -> {
//            int selectedIndex = seatList.getSelectedIndex();
//            if (selectedIndex != -1) {
//                // Logic to reserve the seat
//                JOptionPane.showMessageDialog(this, "Seat reserved successfully.");
//            }
//        });
//
//        add(reserveSeatButton, BorderLayout.SOUTH);
//        loadSeats();
//        setVisible(true);
//    }
//
//    private void loadSeats() {
//        try {
//            seats = ApiClient.getSeats(showtimeId);
//            for (Seat seat : seats) {
//                seatListModel.addElement("Row: " + seat.getRowNumber() + " Col: " + seat.getColNumber() + " Reserved: " + seat.isReserved());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Failed to load seats.");
//        }
//    }
//}
//

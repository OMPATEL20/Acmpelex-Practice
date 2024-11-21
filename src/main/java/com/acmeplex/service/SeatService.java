package com.acmeplex.service;

import com.acmeplex.model.Seat;
import com.acmeplex.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    // Get all seats for a specific showtime
    public List<Seat> getSeatsByShowtimeId(Long showtimeId) {
        return seatRepository.findByShowtimeId(showtimeId);
    }

    // Reserve a seat
    public Seat reserveSeat(Seat seat) {
        seat.setReserved(true);
        return seatRepository.save(seat);
    }

    // Release a seat
    public Seat releaseSeat(Seat seat) {
        seat.setReserved(false);
        return seatRepository.save(seat);
    }

    // Find a seat by its ID
    public Optional<Seat> getSeatById(Long seatId) {
        return seatRepository.findById(seatId);
    }
}

package com.acmeplex.controller;

import com.acmeplex.model.Seat;
import com.acmeplex.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    @Autowired
    private SeatService seatService;

    // Get all seats for a specific showtime
    @GetMapping("/showtime/{showtimeId}")
    public List<Seat> getSeatsByShowtimeId(@PathVariable Long showtimeId) {
        return seatService.getSeatsByShowtimeId(showtimeId);
    }

    // Reserve a seat
    @PutMapping("/reserve")
    public Seat reserveSeat(@RequestBody Seat seat) {
        return seatService.reserveSeat(seat);
    }

    // Release a seat
    @PutMapping("/release")
    public Seat releaseSeat(@RequestBody Seat seat) {
        return seatService.releaseSeat(seat);
    }

    // Get a seat by ID
    @GetMapping("/{seatId}")
    public Optional<Seat> getSeatById(@PathVariable Long seatId) {
        return seatService.getSeatById(seatId);
    }
}

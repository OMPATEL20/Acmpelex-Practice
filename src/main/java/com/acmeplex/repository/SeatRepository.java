package com.acmeplex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmeplex.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    // Custom query to find all seats for a specific showtime
    List<Seat> findByShowtimeId(Long showtimeId);
}

package com.acmeplex.model;

 import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Seat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;  // Primary Key

    private int rowNumber;
    private int colNumber;
    private boolean reserved;

    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    private Showtime showtime;

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getColNumber() {
		return colNumber;
	}

	public void setColNumber(int colNumber) {
		this.colNumber = colNumber;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public Showtime getShowtime() {
		return showtime;
	}

	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}

	public Seat(Long seatId, int rowNumber, int colNumber, boolean reserved, Showtime showtime) {
		super();
		this.seatId = seatId;
		this.rowNumber = rowNumber;
		this.colNumber = colNumber;
		this.reserved = reserved;
		this.showtime = showtime;
	}

    // Constructors, getters, and setters
}

package org.cleartrip.model;

import java.util.List;
import java.util.UUID;

public class Booking {
    private UUID bookingId;
    private String userId;
    private String flightNumber;
    private int departureDate;
    private int departureTime;
    private String fareId;
    private List<String> seats;

    public Booking(BookingRequest request) {
        this.bookingId = UUID.randomUUID();
        this.userId = request.getUserId();
        this.flightNumber = request.getFlightNumber();
        this.departureDate = request.getDepartureDate();
        this.departureTime = request.getDepartureTime();
        this.fareId = request.getFareType();
        this.seats = request.getSeats();
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public String getUserId() {
        return userId;
    }
}

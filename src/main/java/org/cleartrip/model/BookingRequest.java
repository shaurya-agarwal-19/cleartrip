package org.cleartrip.model;

import java.util.List;

public class BookingRequest {

    private String userId;
    private String flightNumber;
    private int departureDate;
    private int departureTime;
    private String fareType;
    List<String> seats;

    public String getUserId() {
        return userId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getDepartureDate() {
        return departureDate;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public String getFareType() {
        return fareType;
    }

    public List<String> getSeats() {
        return seats;
    }
}

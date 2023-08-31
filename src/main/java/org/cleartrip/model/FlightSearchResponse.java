package org.cleartrip.model;

import java.util.List;

public class FlightSearchResponse {
    private String flightNumber;
    private String airline;
    private String from;
    private String to;
    private int departureDate;
    private int departureTime;
    private int price;
    private String fareType;
    private List<String> seats;

    public FlightSearchResponse(Flight flight, FareSeatData fareSeatData) {
        flightNumber = flight.getFlightNumber();
        airline = flight.getAirline();
        from = flight.getFrom();
        to = flight.getTo();
        departureDate = flight.getDepartureDate();
        departureTime = flight.getDepartureTime();
        price = fareSeatData.getPrice();
        fareType = fareSeatData.getFareId();
        seats.addAll(fareSeatData.getSeats());
    }
}

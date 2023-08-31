package org.cleartrip.model;

import java.util.Map;

public class Flight {

    private String flightNumber;
    private String airline;
    private String from;
    private String to;
    private int availableSeats;
    private int departureDate;
    private int departureTime;
    private int arrivalTime;
    private Map<String, FareSeatData> fareSeatDataList;

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getDepartureDate() {
        return departureDate;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public Map<String, FareSeatData> getFareSeatDataMap() {
        return fareSeatDataList;
    }
}

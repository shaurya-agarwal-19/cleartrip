package org.cleartrip.model;

public class FlightSearchRequest {

    private int from;
    private int to;
    private int departureDate;
    private int paxCount;

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getDepartureDate() {
        return departureDate;
    }

    public int getPaxCount() {
        return paxCount;
    }
}

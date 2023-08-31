package org.cleartrip.datastore;

import org.cleartrip.model.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FlightRegistry {

    private static final Map<String, Flight> FLIGHT_DIRECTORY = new HashMap<>();

    private FlightRegistry() {

    }

    public static void addFlight(Flight flight) {
        FLIGHT_DIRECTORY.put(flight.getFlightNumber(), flight);
    }

    public static Map<String, Flight> getFlightDirectory() {
        return FLIGHT_DIRECTORY;
    }
}

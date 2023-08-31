package org.cleartrip.service;

import org.cleartrip.datastore.FlightRegistry;
import org.cleartrip.model.FareSeatData;
import org.cleartrip.model.Flight;
import org.cleartrip.model.FlightSearchRequest;
import org.cleartrip.model.FlightSearchResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FlightService {

    public List<FlightSearchResponse> getFlight(FlightSearchRequest request) {
        List<FlightSearchResponse> flights = new ArrayList<>();

        Map<String, Flight> FLIGHT_DIRECTORY = FlightRegistry.getFlightDirectory();

        for(String flightNumber: FLIGHT_DIRECTORY.keySet()) {
            if(FLIGHT_DIRECTORY.get(flightNumber).getFrom().equals(request.getFrom())
                && FLIGHT_DIRECTORY.get(flightNumber).getTo().equals(request.getTo())
                && FLIGHT_DIRECTORY.get(flightNumber).getDepartureDate() == request.getDepartureDate()) {
                Map<String, FareSeatData> fareSeatDataMap = FLIGHT_DIRECTORY.get(flightNumber).getFareSeatDataMap();

                for(String fareId: fareSeatDataMap.keySet()) {
                    if(fareSeatDataMap.get(fareId).getSeats().size() >= request.getPaxCount()) {
                        flights.add(new FlightSearchResponse(FLIGHT_DIRECTORY.get(flightNumber), fareSeatDataMap.get(fareId)));
                    }
                }
            }
        }

        return flights;
    }
}

package org.cleartrip.controller;

import org.cleartrip.model.FlightSearchRequest;
import org.cleartrip.model.FlightSearchResponse;
import org.cleartrip.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/flight")
public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/")
    public ResponseEntity getFlight(FlightSearchRequest request) {
        List<FlightSearchResponse> flights = flightService.getFlight(request);
        return new ResponseEntity(flights, HttpStatus.OK);
    }


}

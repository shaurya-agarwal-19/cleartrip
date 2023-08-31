package org.cleartrip.controller;

import org.cleartrip.model.Booking;
import org.cleartrip.model.BookingRequest;
import org.cleartrip.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController("/booking")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/")
    public ResponseEntity addBooking(BookingRequest bookingRequest) {
        Booking booking = bookingService.addBooking(bookingRequest);
        return new ResponseEntity(booking.getBookingId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteBooking(String userId, UUID bookingId) {
        Booking booking = bookingService.deleteBooking(userId, bookingId);
        return new ResponseEntity(booking, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity getBooking(String userId) {
        List<Booking> bookings = bookingService.getBookings(userId);
        return new ResponseEntity(HttpStatus.OK);
    }
}

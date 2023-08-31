package org.cleartrip.service;

import org.cleartrip.datastore.BookingRegistry;
import org.cleartrip.datastore.FlightRegistry;
import org.cleartrip.datastore.UserRegistry;
import org.cleartrip.exception.InvalidBookingException;
import org.cleartrip.exception.InsufficientFundsException;
import org.cleartrip.exception.InsufficientSeatsException;
import org.cleartrip.model.Booking;
import org.cleartrip.model.BookingRequest;
import org.cleartrip.model.FareSeatData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BookingService {

    public Booking addBooking(BookingRequest bookingRequest) {
        int availableFunds = UserRegistry.getUserDirectory().get(bookingRequest.getUserId()).getFunds();
        Map<String, FareSeatData> fareSeatDataMap = FlightRegistry.getFlightDirectory().get(bookingRequest.getFlightNumber()).getFareSeatDataMap();
        int requiredFunds = fareSeatDataMap.get(bookingRequest.getFareType()).getPrice() * bookingRequest.getSeats().size();

        if(availableFunds < requiredFunds) {
            throw new InsufficientFundsException(availableFunds, requiredFunds);
        }

        int availableSeats = FlightRegistry.getFlightDirectory().get(bookingRequest.getFlightNumber())
                .getFareSeatDataMap().get(bookingRequest.getFareType()).getSeats().size();
        int demandedSeats = bookingRequest.getSeats().size();

        if(availableSeats < demandedSeats) {
            throw new InsufficientSeatsException(availableSeats, demandedSeats);
        }

        UserRegistry.updateUserWallet(bookingRequest.getUserId(), UserRegistry.getUserDirectory().get(bookingRequest.getUserId()).getFunds() - requiredFunds);
        Booking booking = new Booking(bookingRequest);
        BookingRegistry.addBooking(booking);
        return booking;
    }

    public Booking deleteBooking(String userId, UUID bookingId) {
        Booking booking = BookingRegistry.getBokkingDirectory().get(bookingId);
        if(booking == null) {
            throw new InvalidBookingException("The booking does not exist");
        }
        if(!booking.getUserId().equals(userId)) {
            throw new InvalidBookingException("The booking does not exist with this user");
        }

        BookingRegistry.deleteBooking(bookingId);
        return booking;
    }

    public List<Booking> getBookings(String userId) {
        List<Booking> bookings = new ArrayList<>();
        return bookings;
    }
}

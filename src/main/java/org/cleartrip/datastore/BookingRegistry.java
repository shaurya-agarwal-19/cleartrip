package org.cleartrip.datastore;

import org.cleartrip.model.Booking;

import java.util.*;

public final class BookingRegistry {

    private static final Map<UUID, Booking> BOKKING_DIRECTORY = new HashMap<>();

    private BookingRegistry() {

    }

    public static void addBooking(Booking booking) {
        BOKKING_DIRECTORY.put(booking.getBookingId(), booking);
    }

    public static Map<UUID, Booking> getBokkingDirectory() {
        return BOKKING_DIRECTORY;
    }

    public static void deleteBooking(UUID bookingId) {
        BOKKING_DIRECTORY.remove(bookingId);
    }
}

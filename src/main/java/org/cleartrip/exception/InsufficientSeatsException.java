package org.cleartrip.exception;

public class InsufficientSeatsException extends RuntimeException{

    public InsufficientSeatsException(int availableSeats, int demandedSeats) {
        super("The available seats are " + availableSeats + " whereas demanded seats are " + demandedSeats);
    }
}

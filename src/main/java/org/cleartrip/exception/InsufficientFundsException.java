package org.cleartrip.exception;

public class InsufficientFundsException extends RuntimeException{

    public InsufficientFundsException(int availableFunds, int requiredFunds) {
        super("The available funds are " + availableFunds + " whereas required amount is " + requiredFunds);
    }
}

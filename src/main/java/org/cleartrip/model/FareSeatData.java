package org.cleartrip.model;

import java.util.List;

public class FareSeatData {

    private String fareId;
    private int price;
    private List<String> seats;

    public String getFareId() {
        return fareId;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getSeats() {
        return seats;
    }
}

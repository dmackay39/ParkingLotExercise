package com.example.parkinglotexercise;

import java.util.List;

public interface IParkingLot {

    List<Integer> getCharge();
    void feeCalculator(Ticket ticket);

    String getRules();
}

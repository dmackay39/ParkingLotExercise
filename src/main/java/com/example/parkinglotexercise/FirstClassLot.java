package com.example.parkinglotexercise;

import java.util.ArrayList;
import java.util.List;

public class FirstClassLot implements IParkingLot{

    private int hourlyRate = 100;
    private int maximumChargePerDay = 1200;
    private List<Integer> charge;

    private String rules;

    {rules = "1. Parking costs $100 per hour\n" + "2. The max cost per day is $1200\n"
    + "3. Minutes are rounded up\n" + "4. Penalty charge of $5000/day for staying more than a week";}

    @Override
    public List<Integer> getCharge() {
        return charge;
    }

    @Override
    public void feeCalculator(Ticket ticket) {
        charge = new ArrayList<>();
        int days = ticket.getDuration()[0];
        int hours = ticket.getDuration()[1];
        int minutes = ticket.getDuration()[2];

        if (((hours > 0) && (minutes % (hours*60) > 30))
                || (hours == 0 && minutes > 30)){
            hours++;
        }

        if (minutes == 0){
            charge.add(0);
        } else if (days < 7){
            for (int i=0; i<days;i++){
                charge.add(maximumChargePerDay);
            }

            if ((days > 0) && (hours % (days*24) < 12)){
                charge.add(hourlyRate*(hours%(days*24)));
            } else if (days ==0 && (hours < 12)) {
                charge.add(hourlyRate*hours);
            } else {
                charge.add(maximumChargePerDay);
            }
        }
        else{
            for (int i=0; i<7;i++){
                charge.add(maximumChargePerDay);
            }

            for (int i=7; i<days;i++){
                charge.add(maximumChargePerDay + 5000);
            }

            if ((hours % (days*24) < 12)){
                charge.add(hourlyRate*(hours%(days*24)) + 5000);
            } else {
                charge.add(maximumChargePerDay + 5000);
            }
        }

    }

    @Override
    public String getRules() {
        return rules;
    }
}

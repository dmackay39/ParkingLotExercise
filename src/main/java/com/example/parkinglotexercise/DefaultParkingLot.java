package com.example.parkinglotexercise;

import java.util.ArrayList;
import java.util.List;

public class DefaultParkingLot implements IParkingLot {

    private int hourlyRate = 2;
    private int maximumChargePerDay = 15;
    private List<Integer> charge;

    private String rules;

    {
        rules = """
                1.  $2 per hour
                2.  Always round up (even 1 minute rounds up to the next hour!)
                3. Maximum charge per day is $15.
                4.  On the first day, if you leave within half an hour of arriving there is no charge""";
    }

    @Override
    public String getRules(){
        return rules;
    }

    @Override
    public List<Integer> getCharge() {
        return charge;
    }
    @Override
    public void feeCalculator(Ticket ticket){
        charge = new ArrayList<>();
        int days = ticket.getDuration()[0];
        int hours = ticket.getDuration()[1];
        int minutes = ticket.getDuration()[2];

        if (((hours > 0) && (minutes % (hours*60) > 30))
        || (hours == 0 && minutes > 30)){
            hours++;
        }

        if (minutes <= 30){
            charge.add(0);
        } else{
            for (int i=0; i<days;i++){
                charge.add(maximumChargePerDay);
            }

            if ((days > 0) && (hours % (days*24) < 8)){
                charge.add(hourlyRate*(hours%(days*24)));
            } else if (days ==0 && (hours < 8)) {
                charge.add(hourlyRate*hours);
            } else {
                charge.add(maximumChargePerDay);
            }
        }
    }
}

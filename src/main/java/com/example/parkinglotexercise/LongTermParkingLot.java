package com.example.parkinglotexercise;

import java.util.ArrayList;
import java.util.List;

public class LongTermParkingLot implements IParkingLot {
    private List<Integer> charge;
    private String rules;

    {rules = "1. Costs $1 per hour \n" + "2. Maximum charge per day is $18.\n"
    + "3. Penalty charge $20 if go within 6 hours\n" + "4. This lot doesn't care about minutes.";}
    private int hourlyRate = 1;

    private int dailyMax = 18;


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

        if (hours < 6){
            charge.add(20);
        } else{
            for (int i=0; i<days;i++){
                charge.add(dailyMax);
            }

            if ((days > 0) && (hours % (days*24) < 18)){
                charge.add(hourlyRate*(hours%(days*24)));
            } else if (days ==0 && (hours < 18)) {
                charge.add(hourlyRate*hours);
            } else {
                charge.add(dailyMax);
            }
        }
    }

    @Override
    public String getRules() {
        return rules;
    }
}

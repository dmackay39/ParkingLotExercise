package com.example.parkinglotexercise;

public class ParkingLotFactory {
    public IParkingLot createLot(ParkingLotType choice){
        switch (choice){
            case LONGTERM:
                return new LongTermParkingLot();

            case DEFAULT:
                return new DefaultParkingLot();

            case FIRSTCLASS:
                return new FirstClassLot();

            default:
                return new DefaultParkingLot();
        }
    }
}

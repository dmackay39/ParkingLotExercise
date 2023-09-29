package com.example.parkinglotexercise;

public class ParkingLotFactory {
    public IParkingLot createLot(ParkingLotType choice){
        return switch (choice) {
            case LONGTERM -> new LongTermParkingLot();
            case DEFAULT -> new DefaultParkingLot();
            case FIRSTCLASS -> new FirstClassLot();
        };
    }
}

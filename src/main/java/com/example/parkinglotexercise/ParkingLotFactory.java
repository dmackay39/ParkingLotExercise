package com.example.parkinglotexercise;

public class ParkingLotFactory {
    public static IParkingLot createLot(ParkingLotType choice){
        return switch (choice) {
            case LONGTERM -> new LongTermParkingLot();
            case DEFAULT -> new DefaultParkingLot();
            case FIRSTCLASS -> new FirstClassLot();
        };
    }
}

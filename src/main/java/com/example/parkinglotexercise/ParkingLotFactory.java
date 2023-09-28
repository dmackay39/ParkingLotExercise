package com.example.parkinglotexercise;

public class ParkingLotFactory {
    public IParkingLot createLot(String choice){
        switch (choice.toLowerCase()){
            case "2":
                return new LongTermParkingLot();

            case "1":
                return new DefaultParkingLot();

            case "3":
                return new FirstClassLot();

            default:
                return new DefaultParkingLot();
        }
    }
}

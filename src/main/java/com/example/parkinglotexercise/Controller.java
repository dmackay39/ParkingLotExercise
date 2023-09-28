package com.example.parkinglotexercise;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Controller {

    private ParkingLotFactory parkingLotFactory = new ParkingLotFactory();
    private IParkingLot activeParkingLot = parkingLotFactory.createLot("1");
    private ParkingLotView parkingView;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Controller(ParkingLotView parkingView){
        this.parkingView = parkingView;
        parkingView.getRules().setText(activeParkingLot.getRules());
        createCalculateButton();
    }

    private void createCalculateButton(){

        parkingView.getCalculateButton().setOnAction((event) -> {
            try {
                LocalDateTime entryTime = LocalDateTime.parse(parkingView.getEntryTime(),formatter);
                LocalDateTime exitTime = LocalDateTime.parse(parkingView.getExitTime(),formatter);

                Ticket ticket = new Ticket(entryTime,exitTime);
                activeParkingLot.feeCalculator(ticket);

                String charge = "";
                int totalCharge = 0;

                for (int i = 0; i < activeParkingLot.getCharge().size(); i++){
                    charge += "Charge for day " + (i+1) + ": " + activeParkingLot.getCharge().get(i) + "\n";
                    totalCharge += activeParkingLot.getCharge().get(i);
                }
                charge += "Total charge: " + totalCharge;

                parkingView.displayCharge(charge);
            } catch (Exception e){
                parkingView.displayCharge("Invalid input:\n Please enter correct time format.");
            }
        });
        parkingView.getDefaultLot().setOnAction(e-> {activeParkingLot = parkingLotFactory.createLot("1");
        parkingView.getRules().setText(activeParkingLot.getRules());} );
        parkingView.getLongTermLot().setOnAction(e->{activeParkingLot = parkingLotFactory.createLot("2");
            parkingView.getRules().setText(activeParkingLot.getRules());});
        parkingView.getFirstClassLot().setOnAction(e->{activeParkingLot = parkingLotFactory.createLot("3");
            parkingView.getRules().setText(activeParkingLot.getRules());});
    }
}
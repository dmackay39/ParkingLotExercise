package com.example.parkinglotexercise;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class ParkingLotApp extends Application {
    private Controller controller;
    @Override
    public void start(Stage stage) throws IOException {
        ParkingLotView parkingLotView = new ParkingLotView(stage);
        controller = new Controller(parkingLotView);
    }

    public static void main(String[] args) {
        launch();
    }
}
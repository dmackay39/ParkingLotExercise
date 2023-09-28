package com.example.parkinglotexercise;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ParkingLotView {

    private TextField entryTime;
    private TextField exitTime;
    private Button calculateButton;
    private final ToggleGroup toggleGroup = new ToggleGroup();
    private RadioButton defaultLot;
    private RadioButton longTermLot;
    private RadioButton firstClassLot;
    private Text chargeResult;
    private Label entryLabel;
    private Label exitLabel;

    private Text rules;

    public ParkingLotView(Stage stage){
        initialiseUIComponents();
        initialiseLayout(stage);
    }

    private void initialiseUIComponents(){
        entryTime = new TextField();
        exitTime = new TextField();
        chargeResult = new Text();
        entryLabel = new Label("Please enter the time of entry (Format: dd-MM-yyyy HH:mm:ss)");
        exitLabel = new Label("Please enter the time of exit (Format: dd-MM-yyyy HH:mm:ss)");
        calculateButton = new Button("Calculate charge");
        rules = new Text();
        defaultLot = new RadioButton("Default lot");
        defaultLot.setToggleGroup(toggleGroup);
        defaultLot.setSelected(true);
        longTermLot = new RadioButton("Long term lot");
        longTermLot.setToggleGroup(toggleGroup);
        firstClassLot = new RadioButton("First class lot");
        firstClassLot.setToggleGroup(toggleGroup);
    }

    private void initialiseLayout(Stage stage){
        VBox entryWindow = new VBox(10,entryLabel,entryTime,exitLabel,exitTime,defaultLot,longTermLot,firstClassLot,calculateButton,rules);
        VBox resultWindow = new VBox(chargeResult);
        HBox landscape = new HBox(100, entryWindow, resultWindow);
        Scene scene = new Scene(landscape, 750,400);

        stage.setTitle("Parking lot charge");
        stage.setScene(scene);
        stage.show();
    }

    public String getEntryTime(){return entryTime.getText().trim();}
    public String getExitTime(){return exitTime.getText().trim();}

    public Button getCalculateButton(){return calculateButton;}
    public void displayCharge(String result){
        chargeResult.setText(result);
    }

    public RadioButton getDefaultLot() {
        return defaultLot;
    }

    public RadioButton getLongTermLot() {
        return longTermLot;
    }
    public RadioButton getFirstClassLot() {
        return firstClassLot;
    }

    public Text getRules(){
        return rules;
    }
}

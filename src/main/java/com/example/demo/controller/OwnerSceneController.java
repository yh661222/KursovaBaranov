package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OwnerSceneController {

    @FXML
    private Button RegButt;

    @FXML
    private Button OwnerBack;

    @FXML
    private Button OwnerAddCoffee;

    @FXML
    private Label OwnerSceneHello;

    @FXML
    private Button ShowOwnerCoffee;

    @FXML
    protected void initialize() {
        SceneController scenes = new SceneController();

        RegButt.setOnAction(Event -> scenes.SwitchToReg(RegButt));
        OwnerBack.setOnAction(Event -> scenes.SwitchToLogScene(OwnerBack));
        OwnerAddCoffee.setOnAction(Event -> scenes.SwitchToAddCoffeeScene(OwnerAddCoffee));
        ShowOwnerCoffee.setOnAction(Event -> scenes.SwitchToOwnerShowCoffeeScene(ShowOwnerCoffee));

    }

    public void Hello(String Login){
        OwnerSceneHello.setText("Вітаю, "+ Login+", оберіть наступну дію");
    }




}

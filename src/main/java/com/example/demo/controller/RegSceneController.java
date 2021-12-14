package com.example.demo.controller;

import com.example.demo.User;
import database.ConnectDB;
import database.UserRepository;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class RegSceneController {

    @FXML
    private TextField RgLogin;

    @FXML
    private PasswordField RgPass;

    @FXML
    private PasswordField RgPassCheck;


    @FXML
    private Label RgErr;

    @FXML
    private Button RgButt;

    @FXML
    private Button RgBack;

    @FXML
    protected void initialize() {
        SceneController scenes = new SceneController();

        RgButt.setOnAction(Event -> {
            try {
                RegEmployee(RgLogin.getText(),RgPass.getText(),RgPassCheck.getText());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        RgBack.setOnAction(Event -> scenes.SwitchToOwnerScene(RgBack));
    }

    protected void RegEmployee(String Login,String Password,String PasswordCheck) throws SQLException {

        UserRepository DbDriver = new UserRepository(ConnectDB.DATABASE_URL);
        if(!Password.equals(PasswordCheck)  ||Password.trim().isEmpty() || Login.trim().isEmpty())
            return;

        System.out.println("KNOPKA NAJATA");

        User Emp = new User(Login,Password);
        if(DbDriver.setupCredentials(Emp))
            RgErr.setText("VDALO!");
        else
            RgErr.setText("Такий ID або логін вже зайнято!");

    }



}

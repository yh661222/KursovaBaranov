package com.example.demo.controller;

import com.example.demo.*;
import database.ConnectDB;
import database.UserRepository;
import javafx.fxml.FXML;
import javafx.scene.control.*;




public class LoginController {

    @FXML
    private Label LogError;

    @FXML
    private TextField Login;

    @FXML
    private PasswordField Password;

    @FXML
    private Button LoginButton;

    @FXML
    protected void initialize() {

       LoginButton.setOnAction(Event -> loginUser(Login.getText(),Password.getText()));
    }



    public void loginUser(String login,String password) {
        User Emp = new User(login,password);
        SceneController scenes = new SceneController();
        UserRepository UserDriver = new UserRepository(ConnectDB.DATABASE_URL);
        int n = UserDriver.loginUser(Emp);
        if (n == 0) {
            LogError.setText("Неправильний логін чи пароль!");
            return;
        }
        if (n == 1) {
            scenes.SwitchToShowCoffeeScene(LoginButton);
        } else {
            scenes.SwitchToOwnerScene(LoginButton);
        }
    }
}

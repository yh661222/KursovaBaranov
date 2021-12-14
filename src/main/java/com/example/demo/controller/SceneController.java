package com.example.demo.controller;

import com.example.demo.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneController {
    private Scene scene;
    FXMLLoader fxmlLoader;

    public void SwitchToLogScene(Button back){
        back.getScene().getWindow().hide();
        fxmlLoader = new FXMLLoader(Main.class.getResource("LoginScene.fxml"));
        try{
            scene = new Scene(fxmlLoader.load(), 400, 350);
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Cuppa Coffe");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public void SwitchToOwnerScene(Button login)  {
        login.getScene().getWindow().hide();
        fxmlLoader = new FXMLLoader(Main.class.getResource("OwnerScene.fxml"));
        try{
            scene = new Scene(fxmlLoader.load(), 500, 400);
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Cuppa Coffe");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void SwitchToReg(Button Reg)  {
        Reg.getScene().getWindow().hide();
        fxmlLoader = new FXMLLoader(Main.class.getResource("RegistrationScene.fxml"));
        try{
            scene = new Scene(fxmlLoader.load(), 559, 555);
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Cuppa Coffe");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void SwitchToAddCoffeeScene(Button AddCoffee){
        AddCoffee.getScene().getWindow().hide();
        fxmlLoader = new FXMLLoader(Main.class.getResource("AddCoffeeScene.fxml"));
        try{
            scene = new Scene(fxmlLoader.load(), 600, 500);
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Cuppa Coffe");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void SwitchToShowCoffeeScene(Button ShowCoffee){
        ShowCoffee.getScene().getWindow().hide();
        fxmlLoader = new FXMLLoader(Main.class.getResource("ShowCoffeeScene.fxml"));
        try{
            scene = new Scene(fxmlLoader.load(), 864, 746);
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Cuppa Coffe");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void SwitchToOwnerShowCoffeeScene(Button ShowOwnerCoffee){
        ShowOwnerCoffee.getScene().getWindow().hide();
        fxmlLoader = new FXMLLoader(Main.class.getResource("OwnerShowCoffeeScene.fxml"));
        try{
            scene = new Scene(fxmlLoader.load(), 864, 746);
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Cuppa Coffe");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public void SwitchToUpdateCoffeeScene(Button UpdateCoffee){
        UpdateCoffee.getScene().getWindow().hide();
        fxmlLoader = new FXMLLoader(Main.class.getResource("UpdateCoffeeScene.fxml"));
        try{
            scene = new Scene(fxmlLoader.load(), 864, 746);
        }catch (IOException e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("Cuppa Coffe");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }



}

package com.example.demo.controller;

import com.example.demo.Coffee;
import database.CoffeeRepository;
import javafx.fxml.FXML;
import javafx.scene.control.*;



public class AddCoffeSceneController {

    @FXML
    private ChoiceBox<String > AddFlavor;

    @FXML
    private ChoiceBox<String > AddQuality;

    @FXML
    private TextField AddAmount;

    @FXML
    private ChoiceBox<String > AddRoast;

    @FXML
    private TextField AddPrice;

    @FXML
    private TextField AddName;

    @FXML
    private ChoiceBox<String > AddType;

    @FXML
    private Button AddCoffeeButt;

    @FXML
    private Label AddErr;

    @FXML
    private Label AddFreeSpace;

    @FXML
    private Button AddCoffeeBack;

    @FXML
    private void initialize(){
        SceneController scenes = new SceneController();
        CoffeeRepository CoffeeDriver =  new CoffeeRepository();
        String[] Options = new String[]{"Низька","Середня","Висока","Преміум",null};
        AddQuality.getItems().addAll(Options);
        AddFlavor.getItems().addAll(Options);
        AddRoast.getItems().addAll(Options);
        Options = new String[]{"Зернова", "Мелена", "Розчинна",null};
        AddType.getItems().addAll(Options);
        int FreeSpace = CoffeeDriver.LeftSpaceInTruck();
        AddFreeSpace.setText("Вільного місця у фургоні лишилось: "+FreeSpace+" КГ!");

        AddCoffeeButt.setOnAction(Event -> AddCoffee());
        AddCoffeeBack.setOnAction(Event -> scenes.SwitchToOwnerScene(AddCoffeeBack));
    }

    private void AddCoffee(){
        CoffeeRepository CoffeeDriver =  new CoffeeRepository();
        int FreeSpace = CoffeeDriver.LeftSpaceInTruck();
        if(CheckFields(AddPrice.getText(), AddAmount.getText())){
            Coffee coffee = new Coffee(AddName.getText(),AddType.getValue(),AddFlavor.getValue(),
                    AddRoast.getValue(),AddQuality.getValue(),Integer.parseInt(AddPrice.getText()),Integer.parseInt(AddAmount.getText()));
            if(coffee.getAmount()>FreeSpace){
                AddErr.setText("Фургон переповнено!");
                return;
            }
            if(CoffeeDriver.SetCoffee(coffee))
                AddErr.setText("VDALO!");
            else
                AddErr.setText("Такий ID або логін вже зайнято!");
            FreeSpace = CoffeeDriver.LeftSpaceInTruck();
            AddFreeSpace.setText("Вільного місця у фургоні лишилось: "+FreeSpace+" КГ!");
        }

    }

    private boolean CheckFields(String Price , String Amount){

        if(AddName.getText().trim().isEmpty()){
            AddErr.setText("Неправильно введено назву кави");
            return false;
        }
        if(AddType.getValue()==null || AddQuality.getValue()==null || AddRoast.getValue()==null ||
                AddFlavor.getValue()==null){
            AddErr.setText("Неправильно вказані параметри якості!");
            return false;
        }
        if(Price.length() ==0|| Amount.length() == 0){
            AddErr.setText("Незаповнена кількість або ціна кави!");
            return false;
        }
        for(int i = 0;i<Price.length();i++) {
            if (!Character.isDigit(Price.charAt(i))) {
                AddErr.setText("Неправильно введено ціну!");
                return false;
            }
            System.out.println(Price.charAt(i));
        }
        for(int i = 0;i<Amount.length();i++) {
            if (!Character.isDigit(Amount.charAt(i))) {
                AddErr.setText("Неправильно введено кількість кави!");
                return false;
            }
        }
        return true;
    }



}

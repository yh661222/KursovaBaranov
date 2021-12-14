package com.example.demo.controller;

import database.CoffeeRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import com.example.demo.Coffee;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class OwnerShowCoffeeSceneController implements Initializable {

    @FXML
    private TableColumn<Coffee,String> OwnerShowCoffeeName;

    @FXML
    private TableColumn<Coffee,String> OwnerShowCoffeeType;

    @FXML
    private TableColumn<Coffee,String> OwnerShowCoffeeQuality;

    @FXML
    private TableColumn<Coffee,String> OwnerShowCoffeeRoast;

    @FXML
    private TableColumn<Coffee,String> OwnerShowCoffeeFlavor;

    @FXML
    private TableColumn<Coffee,Integer> OwnerShowCoffeePrice;

    @FXML
    private TableColumn<Coffee,Integer> OwnerShowCoffeeAmount;

    @FXML
    private ChoiceBox<String> OwnerTypeChoice;

    @FXML
    private ChoiceBox<String> OwnerQualityChoice;

    @FXML
    private ChoiceBox<String> OwnerRoastChoice;

    @FXML
    private ChoiceBox<String> OwnerFlavorChoice;

    @FXML
    private TableView<Coffee> OwnerShowCoffee;

    @FXML
    private Button OwnerShowBack;

    @FXML
    private Button OwnerUpdateCoffee;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SceneController scenes = new SceneController();
        ObservableList<Coffee> ObsList = FXCollections.observableArrayList();
        Coffee coffee = new Coffee();
        System.out.println(coffee.getQuality());
        CoffeeRepository CoffeDriver = new CoffeeRepository();
        List<Coffee> list = CoffeDriver.ShowCoffee(coffee);
        OwnerShowCoffeeName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        OwnerShowCoffeeType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        OwnerShowCoffeeQuality.setCellValueFactory(new PropertyValueFactory<>("Quality"));
        OwnerShowCoffeeRoast.setCellValueFactory(new PropertyValueFactory<>("Roast"));
        OwnerShowCoffeeFlavor.setCellValueFactory(new PropertyValueFactory<>("Flavor"));
        OwnerShowCoffeePrice.setCellValueFactory(new PropertyValueFactory<>("PricePerKg"));
        OwnerShowCoffeeAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        ObsList.addAll(list);
        String[] Options = new String[]{"Низька","Середня","Висока","Преміум",null};
        OwnerQualityChoice.getItems().addAll(Options);
        OwnerFlavorChoice.getItems().addAll(Options);
        OwnerRoastChoice.getItems().addAll(Options);
        Options = new String[]{"Зернова", "Мелена", "Розчинна",null};
        OwnerTypeChoice.getItems().addAll(Options);
        OwnerShowCoffee.setItems(ObsList);
        OwnerShowBack.setOnAction(Event ->scenes.SwitchToOwnerScene(OwnerShowBack));
        OwnerUpdateCoffee.setOnAction(Event -> scenes.SwitchToUpdateCoffeeScene(OwnerUpdateCoffee));
    }

    @FXML
    protected void FilterOwnerTable(){
        Coffee coffee = new Coffee();
        CoffeeRepository CoffeDriver = new CoffeeRepository();
        if(!(OwnerTypeChoice.getValue()==null))
            coffee.setType(OwnerTypeChoice.getValue());


        if(!(OwnerQualityChoice.getValue() == null))
            coffee.setQuality(OwnerQualityChoice.getValue());


        if(!(OwnerRoastChoice.getValue()==null))
            coffee.setRoast(OwnerRoastChoice.getValue());

        if(!(OwnerFlavorChoice.getValue()==null))
            coffee.setFlavor(OwnerFlavorChoice.getValue());

        ObservableList<Coffee> obsList = FXCollections.observableArrayList();
        List<Coffee> list = CoffeDriver.ShowCoffee(coffee);
        obsList.addAll(list);
        OwnerShowCoffee.setItems(obsList);
    }

    @FXML
    protected void DeleteCoffee(){
        Coffee coffee =  new Coffee();
        CoffeeRepository coffeeDriver = new CoffeeRepository();
        coffee = OwnerShowCoffee.getSelectionModel().getSelectedItem();
        OwnerShowCoffee.getItems().remove(coffee);
        coffeeDriver.DeleteCoffee(coffee);
    }

}

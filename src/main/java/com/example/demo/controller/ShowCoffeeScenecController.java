package com.example.demo.controller;

import com.example.demo.Coffee;
import database.CoffeeRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShowCoffeeScenecController implements Initializable {

    @FXML
    private TableColumn<Coffee,String> ShowCoffeeName;

    @FXML
    private TableColumn<Coffee,String> ShowCoffeeType;

    @FXML
    private TableColumn<Coffee,String> ShowCoffeeQuality;

    @FXML
    private TableColumn<Coffee,String> ShowCoffeeRoast;

    @FXML
    private TableColumn<Coffee,String> ShowCoffeeFlavor;

    @FXML
    private TableColumn<Coffee,Integer> ShowCoffeePrice;

    @FXML
    private TableColumn<Coffee,Integer> ShowCoffeeAmount;

    @FXML
    private ChoiceBox<String> ShowTypeChoice;

    @FXML
    private ChoiceBox<String> ShowQualityChoice;

    @FXML
    private ChoiceBox<String> ShowRoastChoice;

    @FXML
    private ChoiceBox<String> ShowFlavorChoice;

    @FXML
    private TableView<Coffee> ShowTableCoffee;

    @FXML
    private Button ShowBackButt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Coffee> obsList = FXCollections.observableArrayList();
        Coffee coffee = new Coffee();
        System.out.println(coffee.getQuality());
        CoffeeRepository CoffeDriver = new CoffeeRepository();
        List<Coffee> list = CoffeDriver.ShowCoffee(coffee);
        if(list.size() == 0)
            System.out.println("PUSTO");
        ShowCoffeeName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        ShowCoffeeType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        ShowCoffeeQuality.setCellValueFactory(new PropertyValueFactory<>("Quality"));
        ShowCoffeeRoast.setCellValueFactory(new PropertyValueFactory<>("Roast"));
        ShowCoffeeFlavor.setCellValueFactory(new PropertyValueFactory<>("Flavor"));
        ShowCoffeePrice.setCellValueFactory(new PropertyValueFactory<>("PricePerKg"));
        ShowCoffeeAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        obsList.addAll(list);
        String[] Options = new String[]{"Низька","Середня","Висока","Преміум",null};
        ShowQualityChoice.getItems().addAll(Options);
        ShowFlavorChoice.getItems().addAll(Options);
        ShowRoastChoice.getItems().addAll(Options);
        Options = new String[]{"Зернова", "Мелена", "Розчинна",null};
        ShowTypeChoice.getItems().addAll(Options);
        ShowTableCoffee.setItems(obsList);
    }

    @FXML
    protected void FilterTable(){
        Coffee coffee = new Coffee();
        CoffeeRepository CoffeDriver = new CoffeeRepository();
        if(!(ShowTypeChoice.getValue()==null))
            coffee.setType(ShowTypeChoice.getValue());


        if(!(ShowQualityChoice.getValue() == null))
            coffee.setQuality(ShowQualityChoice.getValue());


        if(!(ShowRoastChoice.getValue()==null))
            coffee.setRoast(ShowRoastChoice.getValue());

        if(!(ShowFlavorChoice.getValue()==null))
            coffee.setFlavor(ShowFlavorChoice.getValue());

        ObservableList<Coffee> obsList = FXCollections.observableArrayList();
        List<Coffee> list = CoffeDriver.ShowCoffee(coffee);
        obsList.addAll(list);
        ShowTableCoffee.setItems(obsList);
    }

    @FXML
    private void SwitchToLoginScene(){
        SceneController scenes = new SceneController();
        scenes.SwitchToLogScene(ShowBackButt);
    }

}

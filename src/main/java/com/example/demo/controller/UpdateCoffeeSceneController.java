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

public class UpdateCoffeeSceneController implements Initializable {

    @FXML
    private Label UpdateErr;

    @FXML
    private TextField UpdatePrice;

    @FXML
    private TextField UpdateAmount;

    @FXML
    private ChoiceBox<String> UpdateType;

    @FXML
    private ChoiceBox<String> UpdateRoast;

    @FXML
    private ChoiceBox<String > UpdateQuality;

    @FXML
    private ChoiceBox<String> UpdateFlavor;

    @FXML
    private TableColumn<Coffee,String> UpdateShowCoffeeName;

    @FXML
    private TableColumn<Coffee,String> UpdateShowCoffeeType;

    @FXML
    private TableColumn<Coffee,String> UpdateShowCoffeeQuality;

    @FXML
    private TableColumn<Coffee,String> UpdateShowCoffeeRoast;

    @FXML
    private TableColumn<Coffee,String> UpdateShowCoffeeFlavor;

    @FXML
    private TableColumn<Coffee,Integer> UpdateShowCoffeePrice;

    @FXML
    private TableColumn<Coffee,Integer> UpdateShowCoffeeAmount;

    @FXML
    private Button UpdateBackButton;

    @FXML
    private TableView<Coffee> UpdateTable;

    @FXML
    private Button UpdateApplyChanges;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SceneController scenes = new SceneController();
        ObservableList<Coffee> ObsList = FXCollections.observableArrayList();
        Coffee coffee = new Coffee();
        CoffeeRepository CoffeDriver = new CoffeeRepository();
        List<Coffee> list = CoffeDriver.ShowCoffee(coffee);
        UpdateShowCoffeeName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        UpdateShowCoffeeType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        UpdateShowCoffeeQuality.setCellValueFactory(new PropertyValueFactory<>("Quality"));
        UpdateShowCoffeeRoast.setCellValueFactory(new PropertyValueFactory<>("Roast"));
        UpdateShowCoffeeFlavor.setCellValueFactory(new PropertyValueFactory<>("Flavor"));
        UpdateShowCoffeePrice.setCellValueFactory(new PropertyValueFactory<>("PricePerKg"));
        UpdateShowCoffeeAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        ObsList.addAll(list);
        String[] Options = new String[]{"Низька","Середня","Висока","Преміум",null};
        UpdateQuality.getItems().addAll(Options);
        UpdateFlavor.getItems().addAll(Options);
        UpdateRoast.getItems().addAll(Options);
        Options = new String[]{"Зернова", "Мелена", "Розчинна",null};
        UpdateType.getItems().addAll(Options);
        UpdateTable.setItems(ObsList);
        UpdateBackButton.setOnAction(Event ->scenes.SwitchToOwnerShowCoffeeScene(UpdateBackButton));
        UpdateApplyChanges.setOnAction(Event -> UpdateCoffee(UpdateType,UpdateQuality,UpdateRoast,UpdateFlavor,UpdatePrice.getText(),UpdateAmount.getText()));
    }

    private void UpdateCoffee(ChoiceBox<String> UpdateType, ChoiceBox<String> UpdateQuality, ChoiceBox<String> UpdateRoast,
                              ChoiceBox<String> UpdateFlavor,String Price,String Amount) {

        Coffee coffee;
        CoffeeRepository CoffeeDriver = new CoffeeRepository();
        if(CheckFields(Price,Amount)){
            try {
                coffee = UpdateTable.getSelectionModel().getSelectedItem();
                if (!(UpdateType.getValue() == null))
                    coffee.setType(UpdateType.getValue());

                if (!(UpdateQuality.getValue() == null))
                    coffee.setQuality(UpdateQuality.getValue());

                if (!(UpdateRoast.getValue() == null))
                    coffee.setRoast(UpdateRoast.getValue());

                if (!(UpdateFlavor.getValue() == null))
                    coffee.setFlavor(UpdateFlavor.getValue());
                if(!Price.trim().isEmpty())
                    coffee.setPricePerKg(Integer.parseInt(Price));
                if(!Amount.trim().isEmpty())
                    coffee.setAmount(Integer.parseInt(Amount));
                CoffeeDriver.UpdateCoffee(coffee);
            }catch(NullPointerException e){
                e.printStackTrace();
            }
        }

    }


    private boolean CheckFields(String UpdatePrice, String UpdateAmount){
        for(int i = 0;i<UpdatePrice.length();i++) {
            if (!Character.isDigit(UpdatePrice.charAt(i))) {
                UpdateErr.setText("Неправильно введено ціну!");
                return false;
            }
            System.out.println(UpdatePrice.charAt(i));
        }
        for(int i = 0;i<UpdateAmount.length();i++) {
            if (!Character.isDigit(UpdateAmount.charAt(i))) {
                UpdateErr.setText("Неправильно введено кількість кави!");
                return false;
            }
        }
        return true;
    }




}

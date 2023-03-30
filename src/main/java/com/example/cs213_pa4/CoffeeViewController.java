package com.example.cs213_pa4;

import cafeapp.Coffee;
import cafeapp.Order;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.text.DecimalFormat;

public class CoffeeViewController {
    @FXML
    private Button home;
    @FXML
    private RadioButton small;
    @FXML
    private RadioButton tall;
    @FXML
    private RadioButton grande;
    @FXML
    private RadioButton venti;
    @FXML
    private CheckBox sweet_cream;
    @FXML
    private CheckBox french_vanilla;
    @FXML
    private CheckBox irish_cream;
    @FXML
    private CheckBox caramel;
    @FXML
    private CheckBox mocha;
    @FXML
    private ComboBox<String> quantity;
    @FXML
    private Label total;
    @FXML
    private TextField text_field;
    @FXML
    private ToggleGroup sizes = new ToggleGroup();
    @FXML
    private Button finalize;

    private Coffee coffee = new Coffee("Short");

    @FXML
    void changeSceneHome() throws IOException {
        CafeApplication.changeScene("cafeapp-view.fxml");
    }

    @FXML
    private void changeSize() {
        if(small.isSelected()) {
            coffee.changeSize("Short");
        }
        if(tall.isSelected()) {
            coffee.changeSize("Tall");
        }
        if(grande.isSelected()) {
            coffee.changeSize("Grande");
        }
        if(venti.isSelected()) {
            coffee.changeSize("Venti");
        }
        updatePrice();
    }

    @FXML
    private void updatePrice() {
        if(coffee.getQuantity() == 0) {
            total.setText("$0.00");
            return;
        }
        double price = coffee.itemPrice()*coffee.getQuantity();
        DecimalFormat f = new DecimalFormat("##.00");
        total.setText("$" + f.format(price));
    }
    @FXML
    private void choiceSweetCream() {
        if(sweet_cream.isSelected()) {
            coffee.addTopping("Sweet Cream");
        }
        else {
            coffee.removeTopping("Sweet Cream");
        }
        updatePrice();
    }
    @FXML
    private void choiceFrenchVanilla() {
        if(french_vanilla.isSelected()) {
            coffee.addTopping("French Vanilla");
        }
        else {
            coffee.removeTopping("French Vanilla");
        }
        updatePrice();
    }
    @FXML
    private void choiceIrishCream() {
        if(irish_cream.isSelected()) {
            coffee.addTopping("Irish Cream");
        }
        else {
            coffee.removeTopping("Irish Cream");
        }
        updatePrice();
    }
    @FXML
    private void choiceCaramel() {
        if(caramel.isSelected()) {
            coffee.addTopping("Caramel");
        }
        else {
            coffee.removeTopping("Caramel");
        }
        updatePrice();
    }
    @FXML
    private void choiceMocha() {
        if(mocha.isSelected()) {
            coffee.addTopping("Mocha");
        }
        else {
            coffee.removeTopping("Mocha");
        }
        updatePrice();
    }
    @FXML
    private void changeQuantity() {
        coffee.setQuantity(Integer.parseInt(quantity.getValue()));
        updatePrice();
    }
    @FXML
    private void initialize() {
        quantity.getItems().addAll("1", "2", "3", "4", "5");
    }
    @FXML
    private void addToOrder() throws IOException {
        if(coffee.getQuantity() > 0) {
            Order.addItem(coffee);
            CafeApplication.changeScene("order-view.fxml");
        }
        else{
            text_field.setText("Please select a quantity!");
        }
    }
}

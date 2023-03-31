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

    /**
     * Changes scene to the home view
     */
    @FXML
    void changeSceneHome() throws IOException {
        CafeApplication.changeScene("cafeapp-view.fxml");
    }

    /**
     * Changes size of coffee selected
     */
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

    /**
     * Updates what price is shown
     */
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

    /**
     * Initializes donut view
     */
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

    /**
     * Adds french vanilla topping and updates price
     */
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

    /**
     * Adds Irish cream topping and updates price
     */
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

    /**
     * Adds caramel topping and updates price
     */
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

    /**
     * Adds mocha topping and updates price
     */
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

    /**
     * Initializes donut view
     */
    @FXML
    private void initialize() {
        quantity.getItems().addAll("1", "2", "3", "4", "5");
    }

    /**
     * Adds selected drinks to current order
     */
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

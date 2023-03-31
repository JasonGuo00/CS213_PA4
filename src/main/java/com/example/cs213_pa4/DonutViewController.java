package com.example.cs213_pa4;

import cafeapp.Constants;
import cafeapp.Donut;
import cafeapp.Order;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DonutViewController {
    @FXML
    private Button home;
    @FXML
    private ListView<String> donut_flavors;
    @FXML
    private ComboBox<String> donut_types;
    @FXML
    private ImageView donut_img;
    @FXML
    private ComboBox<String> quantity;
    @FXML
    private Button add_donut;
    @FXML
    private ListView<Donut> selected_donuts;
    @FXML
    private Button remove_donut;
    @FXML
    private Label total;
    @FXML
    private Button finalize;
    @FXML
    private TextField text_field;

    private ArrayList<Donut> chosen_donuts = new ArrayList<>();

    /**
     * Changes scene to the home view
     */
    @FXML
    void changeSceneHome() throws IOException {
        CafeApplication.changeScene("cafeapp-view.fxml");
    }

    /**
     * Initializes donut view
     */
    @FXML
    void initialize() {
        donut_types.getItems().addAll(Constants.DONUT_YEAST, Constants.DONUT_CAKE, Constants.DONUT_HOLE);
        donut_flavors.setOpacity(0);
        quantity.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
    }

    /**
     * Changes whether the user has selected a yeast donut, cake donut, or donut hole
     */
    @FXML
    protected void changeCommand() {
        switch(donut_types.getValue()) {
            case Constants.DONUT_YEAST -> chooseYeast();
            case Constants.DONUT_CAKE -> chooseCake();
            case Constants.DONUT_HOLE -> chooseHole();
        }
    }

    /**
     * Sets flavors and images for a yeast donut
     */
    @FXML
    private void chooseYeast() {
        donut_flavors.getItems().clear();
        donut_flavors.getItems().addAll(Constants.YEAST_FLAVORS);
        donut_flavors.setOpacity(1);
        Image yeast_donut = new Image(Objects.requireNonNull(CafeApplication.class.getResourceAsStream
                ("/images/yeastdonut.png")));
        donut_img.setImage(yeast_donut);
    }

    /**
     * Sets flavors and images for a cake donut
     */
    @FXML
    private void chooseCake() {
        donut_flavors.getItems().clear();
        donut_flavors.getItems().addAll(Constants.CAKE_HOLE_FLAVORS);
        donut_flavors.setOpacity(1);
        Image donut_cake = new Image(Objects.requireNonNull(CafeApplication.class.getResourceAsStream
                ("/images/donutcake.png")));
        donut_img.setImage(donut_cake);
    }

    /**
     * Sets flavors and images for a donut hole
     */
    @FXML
    private void chooseHole() {
        donut_flavors.getItems().clear();
        donut_flavors.getItems().addAll(Constants.CAKE_HOLE_FLAVORS);
        donut_flavors.setOpacity(1);
        Image donut_hole = new Image(Objects.requireNonNull(CafeApplication.class.getResourceAsStream
                ("/images/donuthole.png")));
        donut_img.setImage(donut_hole);
    }

    /**
     * Updates what types of donuts are currently suggested
     */
    @FXML
    private void updateSelectedDonuts() {
        selected_donuts.getItems().clear();
        for(Donut d : chosen_donuts) {
            selected_donuts.getItems().add(d);
        }
    }

    /**
     * Updates what price is shown
     */
    @FXML
    private void updatePrice() {
        double price = 0;
        if(chosen_donuts.isEmpty()) {
            total.setText("Total: $0.00");
            return;
        }
        for(Donut d : chosen_donuts) {
            price += d.itemPrice()*d.getQuantity();
        }
        DecimalFormat f = new DecimalFormat("##.00");
        total.setText("Total: $" + f.format(price));
    }

    /**
     * Adds donut to the current list of chosen donuts, updates price, and outputs a message if user input is wrong
     */
    @FXML
    private void addDonut() {
        if(donut_types.getValue() != null && donut_flavors.getSelectionModel().getSelectedItem() != null && quantity.getValue() != null) {
            text_field.clear();
            Donut donut = new Donut(donut_types.getValue(), donut_flavors.getSelectionModel().getSelectedItem(), Integer.parseInt(quantity.getValue()));
            if(chosen_donuts.contains(donut)) {
                chosen_donuts.get(chosen_donuts.indexOf(donut)).addDonuts(donut.getQuantity());
            }
            else {
                chosen_donuts.add(donut);
            }
            updateSelectedDonuts();
            updatePrice();
        }
        else{
            if(donut_types.getValue() == null) {
                text_field.setText("Please select a donut type!");
            }
            else if(donut_flavors.getSelectionModel().getSelectedItem() == null) {
                text_field.setText("Please select a flavor!");
            }
            else if(quantity.getValue() == null) {
                text_field.setText("Please select a quantity!");
            }
        }
    }

    /**
     * Removes donuts from selected and updates price
     */
    @FXML
    private void removeDonut() {
        if(!chosen_donuts.isEmpty() && selected_donuts.getSelectionModel().getSelectedItem() != null) {
            text_field.setText("Donut removed!");
            chosen_donuts.remove(selected_donuts.getSelectionModel().getSelectedItem());
            updateSelectedDonuts();
            updatePrice();
        }
        else {
            text_field.setText("No donut selected for removal!");
        }
    }

    /**
     * Adds selected donuts to current order
     */
    @FXML
    private void addToOrder() throws IOException {
        if(!chosen_donuts.isEmpty()) {
            for(Donut donut : chosen_donuts) {
                Order.addItem(donut);
            }
            CafeApplication.changeScene("order-view.fxml");
        }
        else {
            text_field.setText("Please add some donuts!");
        }

    }
}

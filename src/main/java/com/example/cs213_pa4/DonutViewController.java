package com.example.cs213_pa4;

import cafeapp.Constants;
import cafeapp.Donut;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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

    private ArrayList<Donut> chosen_donuts = new ArrayList<>();

    @FXML
    void changeSceneHome() throws IOException {
        CafeApplication.changeScene("cafeapp-view.fxml");
    }

    @FXML
    void initialize() {
        donut_types.getItems().addAll(Constants.DONUT_YEAST, Constants.DONUT_CAKE, Constants.DONUT_HOLE);
        donut_flavors.setOpacity(0);
        quantity.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
    }

    @FXML
    protected void changeCommand() {
        switch(donut_types.getValue()) {
            case Constants.DONUT_YEAST -> chooseYeast();
            case Constants.DONUT_CAKE -> chooseCake();
            case Constants.DONUT_HOLE -> chooseHole();
        }
    }

    @FXML
    private void chooseYeast() {
        donut_flavors.getItems().clear();
        donut_flavors.getItems().addAll(Constants.YEAST_FLAVORS);
        donut_flavors.setOpacity(1);
        Image yeast_donut = new Image(Objects.requireNonNull(CafeApplication.class.getResourceAsStream
                ("/images/yeastdonut.png")));
        donut_img.setImage(yeast_donut);
    }
    @FXML
    private void chooseCake() {
        donut_flavors.getItems().clear();
        donut_flavors.getItems().addAll(Constants.CAKE_HOLE_FLAVORS);
        donut_flavors.setOpacity(1);
        Image donut_cake = new Image(Objects.requireNonNull(CafeApplication.class.getResourceAsStream
                ("/images/donutcake.png")));
        donut_img.setImage(donut_cake);
    }
    @FXML
    private void chooseHole() {
        donut_flavors.getItems().clear();
        donut_flavors.getItems().addAll(Constants.CAKE_HOLE_FLAVORS);
        donut_flavors.setOpacity(1);
        Image donut_hole = new Image(Objects.requireNonNull(CafeApplication.class.getResourceAsStream
                ("/images/donuthole.png")));
        donut_img.setImage(donut_hole);
    }

    @FXML
    private void updateSelectedDonuts() {
        selected_donuts.getItems().clear();
        for(Donut d : chosen_donuts) {
            selected_donuts.getItems().add(d);
        }
    }

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

    @FXML
    private void addDonut() {
        if(donut_types.getValue() != null && donut_flavors.getSelectionModel().getSelectedItem() != null && quantity.getValue() != null) {
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
    }

    @FXML
    private void removeDonut() {
        if(!chosen_donuts.isEmpty() && selected_donuts.getSelectionModel().getSelectedItem() != null) {
            chosen_donuts.remove(selected_donuts.getSelectionModel().getSelectedItem());
            updateSelectedDonuts();
            updatePrice();
        }
    }
}

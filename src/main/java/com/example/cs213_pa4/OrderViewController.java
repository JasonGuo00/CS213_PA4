package com.example.cs213_pa4;

import cafeapp.MenuItem;
import cafeapp.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;

public class OrderViewController {

    @FXML
    private ListView<MenuItem> order_list;
    @FXML
    private Button home;
    @FXML
    private Label order_label;

    private Order order = new Order();

    @FXML
    void changeSceneHome() throws IOException {
        CafeApplication.changeScene("cafeapp-view.fxml");
    }
    @FXML
    private void initialize(){
        order_label.setText("Order #" + order.getOrderNum());
        order_list.getItems().addAll(Order.getGlobal());
    }

}

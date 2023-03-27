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
    private Button place_order;
    @FXML
    private Button remove_item;
    @FXML
    private Label order_label;

    private Order order;

    @FXML
    void changeSceneHome() throws IOException {
        CafeApplication.changeScene("cafeapp-view.fxml");
    }
    @FXML
    private void initialize(){
        order_label.setText("Order #" + Order.getPosition());
        order_list.getItems().addAll(Order.getGlobal());
    }

    @FXML
    private void removeItem() {
        if(order_list.getSelectionModel().getSelectedItem() != null) {
            Order.removeItem(order_list.getSelectionModel().getSelectedItem());
            order_list.getItems().remove(order_list.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    private void finalizeOrder(){
        if(!order_list.getItems().isEmpty()) {
            order = new Order();
            order.finalizeOrder();
            ShoplistViewController.addOrder(order);
            order_list.getItems().clear();
        }
    }

}

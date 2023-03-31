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

    @FXML
    private Label total_label;

    private Order order;

    /**
     * Changes scene to the home view
     */
    @FXML
    void changeSceneHome() throws IOException {
        CafeApplication.changeScene("cafeapp-view.fxml");
    }

    /**
     * Initializes order view
     */
    @FXML
    private void initialize(){
        order_label.setText("Order #" + Order.getPosition());
        order_list.getItems().addAll(Order.getGlobal());
        changeTotals();
    }

    /**
     * Removes selected value from the list of items ordered
     */
    @FXML
    private void removeItem() {
        if(order_list.getSelectionModel().getSelectedItem() != null) {
            Order.removeItem(order_list.getSelectionModel().getSelectedItem());
            order_list.getItems().remove(order_list.getSelectionModel().getSelectedItem());
            changeTotals();
        }
    }

    /**
     * Finalizes order and adds it to list of orders, then returns to home view
     */
    @FXML
    private void finalizeOrder() throws IOException {
        if(!order_list.getItems().isEmpty()) {
            order = new Order();
            order.finalizeOrder();
            ShoplistViewController.addOrder(order);
            order_list.getItems().clear();
            try {
                changeSceneHome();
            }  catch (IOException ex) {

            }
        }
    }

    /**
     * Displays subtotal, tax, and total price of current order at the bottom
     */
    private void changeTotals() {
        String new_text = String.format("""
                $%,.2f
                $%,.2f
                $%,.2f""",
                Order.staticSubtotal(),
                Order.staticTax(),
                Order.staticTotalPrice());
        total_label.setText(new_text);
    }
}

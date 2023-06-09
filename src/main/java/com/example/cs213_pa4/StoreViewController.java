package com.example.cs213_pa4;

import cafeapp.MenuItem;
import cafeapp.Order;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StoreViewController {

    @FXML
    private ListView<Order> order_list;

    ArrayList<Order> shop_list;

    /**
     * Changes scene to the home view
     */
    @FXML
    void changeSceneHome() throws IOException {
        CafeApplication.changeScene("cafeapp-view.fxml");
    }

    /**
     * Initializes store view
     */
    @FXML
    private void initialize() {
        shop_list = ShoplistViewController.getOrderList();
        order_list.getItems().addAll(shop_list);
    }

    /**
     * Removes selected value from the list of orders
     */
    @FXML
    private void removeItem() {
        if (order_list.getSelectionModel().getSelectedItem() != null) {
            shop_list.remove(order_list.getSelectionModel().getSelectedItem());
            order_list.getItems().remove(order_list.getSelectionModel().getSelectedItem());
        }
    }

    /**
     * Exports orders to a .txt file, named with UNIX timestamp
     */
    @FXML
    private void exportOrders() {
        try {
            File file = new File("orders-" + System.currentTimeMillis() + ".txt");
            if (!file.exists()) {
                PrintWriter pw = new PrintWriter(file);
                for (Order order : shop_list) {
                    pw.println(order);
                    pw.println(" ");
                }
                pw.close();
            }
        } catch (FileNotFoundException ex) {

        }
    }
}

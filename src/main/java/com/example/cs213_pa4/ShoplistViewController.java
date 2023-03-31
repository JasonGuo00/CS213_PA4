package com.example.cs213_pa4;

import cafeapp.Order;
import cafeapp.ShopList;

import java.util.ArrayList;

public class ShoplistViewController {
    private static ShopList shopList = new ShopList();

    /**
     * Adds order to the static ShopList
     * @param order Order to add
     */
    public static void addOrder(Order order) {
        shopList.addOrder(order);
    }

    /**
     * Adds order to the static ShopList
     * @return ArrayList<Order> full of every order
     */
    public static ArrayList<Order> getOrderList() {
        return shopList.getOrderList();
    }
}

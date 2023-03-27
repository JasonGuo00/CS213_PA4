package com.example.cs213_pa4;

import cafeapp.Order;
import cafeapp.ShopList;

public class ShoplistViewController {
    private static ShopList shopList = new ShopList();

    public static void addOrder(Order order) {
        shopList.addOrder(order);
    }
}

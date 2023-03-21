package cafeapp;

import java.util.HashMap;

/**
 * Class representing the order of a customer.
 * @author Jason Guo, Russel Rivera
 */
public class Order {
    /**
     * Static variable position to provide unique order numbers.
     */
    private static int position = 1;
    /**
     * Number identifier for the order.
     */
    private int orderNum;
    /**
     * List of menu items in the order.  Contained in a hashmap that tracks quantity.
     */
    private HashMap<MenuItem, Integer> orderList;

    /**
     * Default constructor for the Order.  Assigns a unique order number and initializes orderList.
     */
    public Order() {
        orderNum = position;
        position++;
        orderList = new HashMap<>();
    }

    /**
     * Remove a menu item from the order, or decrease the quantity.
     * @param item Item to be removed / decreased
     * @param quantity
     */
    public void removeItem(MenuItem item, int quantity) {
        if(quantity >= orderList.get(item)) {
            orderList.remove(item);
        }
        else {
            orderList.replace(item, orderList.get(item) - quantity);
        }
    }

    /**
     * Add a menu item to the order, and increment if that item is already in there.
     * @param item Menu item to be added.
     * @param quantity Quantity of the menu item to add.
     */
    public void addItem(MenuItem item, int quantity) {
        if(orderList.get(item) == null) {
            orderList.put(item, quantity);
        }
        else {
            orderList.replace(item, orderList.get(item) + quantity);
        }
    }

    /**
     * Change the quantity of an item in the hashmap.
     * @param item Target menu item.
     * @param quantity Quantity to replace with.
     */
    public void changeQuantity(MenuItem item, int quantity) {
        orderList.replace(item, quantity);
    }

    /**
     * Obtain the subtotal of all the items in the order.
     * @return Subtotal of the order.
     */
    public double subtotal() {
        int price = 0;
        for(MenuItem item : orderList.keySet()) {
            price += (item.itemPrice() * orderList.get(item));
        }
        return price;
    }

    /**
     * Obtain the tax due based on the subtotal.
     * @return Tax due on the order.
     */
    public double tax() {
        return subtotal()*Constants.SALES_TAX_MULTIPLIER;
    }

    /**
     * Obtain the total price of the order by adding the subtotal and tax.
     * @return Total price of the order.
     */
    public double totalPrice() {
        return subtotal() + tax();
    }

    /**
     * Obtain the order number.
     * @return Order number.
     */
    public int getOrderNum() {return orderNum;}
}

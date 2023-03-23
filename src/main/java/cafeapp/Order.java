package cafeapp;

import java.util.ArrayList;

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
     * List of menu items in the order.  Accessible through public methods to allow MenuItems
     * to be added from the Coffee and Donut views.
     */
    private static ArrayList<MenuItem> globalOrderList = new ArrayList<>();

    /**
     * Finalized list of MenuItems tied to the current order.
     */
    private ArrayList<MenuItem> finalOrderList;

    /**
     * Default constructor for the Order.  Assigns a unique order number and initializes orderList.
     */
    public Order() {
        orderNum = position;
        position++;
        finalOrderList = new ArrayList<>();
    }

    /**
     * Remove a menu item from the order.
     * @param item Item to be removed
     */
    public void removeItem(MenuItem item) {
        globalOrderList.remove(item);
    }

    /**
     * Add a menu item to the order, and increment if that item is already in there.
     * Defined as a static method to allow access from the Coffee and Donut Controllers.
     * @param item Menu item to be added.
     */
    public static void addItem(MenuItem item) {
        if(!globalOrderList.contains(item)) {
            globalOrderList.add(item);
        }
        else {
            if(item instanceof  Donut) {
                ((Donut) globalOrderList.get(globalOrderList.indexOf(item))).addDonuts(item.getQuantity());
            }
            else {
                ((Coffee) globalOrderList.get(globalOrderList.indexOf(item))).setQuantity
                        (globalOrderList.get(globalOrderList.indexOf(item)).getQuantity() + item.getQuantity());
            }
        }
    }

    /**
     * Obtain the subtotal of all the items in the order.
     * @return Subtotal of the order.
     */
    public double subtotal() {
        int price = 0;
        for(MenuItem item : globalOrderList) {
            price += (item.itemPrice() * item.getQuantity());
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

    /**
     * Writes all the data form the globalOrderList to the instance's finalOrderList.
     * The globalOrderList is cleared afterwards.
     */
    public void finalizeOrder() {
        finalOrderList.addAll(globalOrderList);
        globalOrderList.clear();
    }
    public static ArrayList<MenuItem> getGlobal() {
        return new ArrayList<>(globalOrderList);
    }
}

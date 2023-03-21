package cafeapp;

import java.util.ArrayList;

/**
 * Class representing Coffee objects
 * @author Jason Guo, Russel Rivera
 */
public class Coffee extends MenuItem {
    /**
     * Size of the coffee
     */
    private int size;
    /**
     * List of add-ins for the coffee
     */
    private ArrayList<String> addInList;

    /**
     * Constructor for a coffee object, taking a size and initializing an empty add-in list
     * @param size Size of the coffee
     */
    public Coffee(int size) {
        addInList = new ArrayList<>();
        this.size = size;
    }

    /**
     * Setter method to change the size of the Coffee
     * @param size Size of the coffee to change to
     */
    public void changeSize(int size) {
        this.size = size;
    }

    /**
     * Obtain the price of the coffee, based on coffee size and number of add-ins
     * @return Price of the coffee
     */
    @Override
    public double itemPrice() {
        int price = 0;
        switch(size) {
            case Constants.COFFEE_VENTI:
                price += Constants.COFFEE_SIZE_INCREMENT;
            case Constants.COFFEE_GRANDE:
                price += Constants.COFFEE_SIZE_INCREMENT;
            case Constants.COFFEE_TALL:
                price += Constants.COFFEE_SIZE_INCREMENT;
            case Constants.COFFEE_SHORT:
                price += Constants.COFFEE_BASE_PRICE;
                break;
            default:
                price = -1;
                break;
        }
        price += addInList.size()*Constants.COFFEE_ADDIN;
        return price;
    }

    /**
     * Obtain the size of the coffee
     * @return Size of the coffee as an integer
     */
    public int getSize() {return size;}

    /**
     * Getter method to obtain the size of the coffee as a String
     * @return String representing the size of the coffee4
     */
    public String getSizeString() {
        switch(size) {
            case Constants.COFFEE_VENTI:
                return "Venti";
            case Constants.COFFEE_GRANDE:
                return "Grande";
            case Constants.COFFEE_TALL:
                return "Tall";
            case Constants.COFFEE_SHORT:
                return "Short";
            default:
                return "THIS COFFEE ISN'T REAL";
        }
    }

    /**
     * Add topping(s) to the add-in list
     * @param toppingsList The list of toppings to add to the coffee.  Can be a single add-in.
     */
    public void addTopping(String[] toppingsList) {
        for(String topping: toppingsList) {
            if(topping.equalsIgnoreCase("sweet cream") ||
                    topping.equalsIgnoreCase("french vanilla") ||
                    topping.equalsIgnoreCase("irish cream") ||
                    topping.equalsIgnoreCase("caramel") ||
                    topping.equalsIgnoreCase("mocha")) {

                addInList.add(topping);
            }
        }
    }

    /**
     * Remove topping(s) to the add-in list
     * @param toppingsList The list of toppings to remove from the coffee.  Can be a single add-in.
     */
    public void removeTopping(String[] toppingsList) {
        for(String topping: toppingsList) {
            addInList.remove(topping);
        }
    }
}

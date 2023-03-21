package cafeapp;

import java.util.ArrayList;

/**
 * Class representing Donut objects.
 * @author Jason Guo, Russel Rivera
 */
public class Donut extends MenuItem {
    /**
     * Type of the donut (yeast, cake, or hole).
     */
    private int donutType;

    /**
     * Flavor of the donut
     */
    private String donutFlavor;

    /**
     * Constructor for the donut with a given type, defaulting flavor to plain
     * @param type Type of the donut
     */
    public Donut(int type) {
        donutType = type;
        donutFlavor = "Plain";
    }

    /**
     * Constructor for the donut with a given type and flavor.
     * @param type Type of the donut.
     * @param donutFlavor Flavor of the donut.
     */
    public Donut(int type, String donutFlavor) {
        donutType = type;
        this.donutFlavor = donutFlavor;
    }

    /**
     * Set the donut type.
     * @param type Type of the donut to change to.
     */
    public void setDonutType(int type) {
        donutType = type;
    }

    /**
     * Get the donut type as a string.
     * @return String representing the donut type.
     */
    public String getDonutTypeString() {
        switch(donutType) {
            case Constants.DONUT_YEAST:
                return "Yeast Donut";
            case Constants.DONUT_CAKE:
                return "Cake Donut";
            case Constants.DONUT_HOLE:
                return "Donut Hole";
            default:
                return "THIS DONUT ISN'T REAL";
        }
    }

    /**
     * Return the type of the donut as an integer
     * @return
     */
    public int getDonutType() {
        return donutType;
    }

    /**
     * Set the donut flavor.
     * @param flavor Flavor of the donut to be set as.
     */
    public void setDonutFlavor(String flavor) {
        donutFlavor = flavor;
    }

    /**
     * Get the donut flavor.
     * @return Donut flavor as a String.
     */
    public String getDonutFlavor() {
        return donutFlavor;
    }

    /**
     * Obtain the price of the donut.
     * @return The price of the donut.
     */
    @Override
    public double itemPrice() {
        double price;
        switch(donutType) {
            case Constants.DONUT_YEAST:
                price = Constants.DONUT_YEAST_PRICE;
                break;
            case Constants.DONUT_CAKE:
                price = Constants.DONUT_CAKE_PRICE;
                break;
            case Constants.DONUT_HOLE:
                price = Constants.DONUT_HOLE_PRICE;
                break;
            default:
                price = -1;
                break;
        }
        return price;
    }

}

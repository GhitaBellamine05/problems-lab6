package problem1;
import java.text.NumberFormat;
public class Item
{
    private String name;
    private double price;
    private int quantity;
    // -------------------------------------------------------
    // Create a new item with the given attributes.
    // -------------------------------------------------------
    public Item (String itemName, double itemPrice, int numPurchased)
    {
        name = itemName;
        price = itemPrice;
        quantity = numPurchased;
    }
    // -------------------------------------------------------
    // Return a string with the information about the item
    // -------------------------------------------------------
    @Override
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        return String.format("%-10s\t%-10s\t%-10d\t%-10s",
                name, fmt.format(price), quantity, fmt.format(price * quantity));
    }

    // -------------------------------------------------
    // Returns the unit price of the item
    // -------------------------------------------------

    public double getPrice()
    {
        return price;
    }
    // -------------------------------------------------
    // Returns the name of the item
    // -------------------------------------------------
    public String getName()
    {
        return name;
    }
    // -------------------------------------------------
    // Returns the quantity of the item
    // -------------------------------------------------
    public int getQuantity()
    {
        return quantity;
    }
}
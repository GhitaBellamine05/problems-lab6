package problem1;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        ArrayList<Item> cart = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String keepShopping = "y";

        do {
            System.out.print("Enter the name of the item: ");
            String itemName = scan.nextLine();

            System.out.print("Enter the unit price: ");
            double itemPrice = scan.nextDouble();

            System.out.print("Enter the quantity: ");
            int quantity = scan.nextInt();
            scan.nextLine();

            // *** create a new item and add it to the cart
            Item item = new Item(itemName, itemPrice, quantity);
            cart.add(item);

            // *** Print cart contents and total
            double totalPrice = 0;
            System.out.println("\nCurrent Cart:");
            System.out.println("Item\tUnit Price\tQuantity\tTotal");
            System.out.println("---------------------------------------------------");

            for (Item i : cart) {
                System.out.println(i.toString());
                totalPrice += i.getPrice() * i.getQuantity();
            }

            System.out.printf("\nTotal Price: $%.2f\n", totalPrice);

            System.out.print("\nContinue shopping (y/n)? ");
            keepShopping = scan.nextLine();
            System.out.println();

        } while (keepShopping.equals("y"));

        scan.close();
        System.out.println("Thank you for shopping with us!");
    }
}

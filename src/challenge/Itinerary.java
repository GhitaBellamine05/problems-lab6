package challenge;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Itinerary {
    // attributes
    private LinkedList<Place> itinerary = new LinkedList<>();

    // Insert place in order by distance and do not allow duplicate names
    public boolean addInOrder(Place newPlace) {
        ListIterator<Place> it = itinerary.listIterator();
        while (it.hasNext()) {
            Place current = it.next();
            if (current.equals(newPlace)) {
                System.out.println(newPlace.getName() + " is already in the itinerary.");
                return false; // duplicate
            }
            if (newPlace.getDistance() < current.getDistance()) {
                it.previous(); // step back to insert before current
                it.add(newPlace);
                return true;
            }
        }
        it.add(newPlace);
        return true;
    }

    public void printItinerary() {
        if (itinerary.isEmpty()) {
            System.out.println("Itinerary is empty.");
            return;
        }
        System.out.println("Current itinerary (ordered by distance):");
        for (Place p : itinerary) {
            System.out.println(" - " + p);
        }
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("F  -> Move forward to next place");
        System.out.println("B  -> Move backward to previous place");
        System.out.println("L  -> List all places");
        System.out.println("A  -> Add a new place");
        System.out.println("M  -> Print this menu");
        System.out.println("Q  -> Quit");
        System.out.println();
    }

    public static void main(String[] args) {
        Itinerary app = new Itinerary();

        // Add initial Australian list (distances from Sydney in km; Sydney first)
        app.addInOrder(new Place("Sydney", 0));
        app.addInOrder(new Place("Canberra", 286));
        app.addInOrder(new Place("Melbourne", 878));
        app.addInOrder(new Place("Brisbane", 920));
        app.addInOrder(new Place("Adelaide", 1160));
        app.addInOrder(new Place("Hobart", 1170));
        app.addInOrder(new Place("Alice Springs", 2780));
        app.addInOrder(new Place("Perth", 3930));
        app.addInOrder(new Place("Darwin", 3970));

        ListIterator<Place> iterator = app.itinerary.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;

        System.out.println("Welcome — itinerary starting at Sydney.");
        printMenu();

        if (iterator.hasNext()) {
            System.out.println("Now visiting " + iterator.next());
        }

        while (!quit) {
            System.out.print("\nEnter action: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Please enter a command (M for menu).");
                continue;
            }
            char action = Character.toUpperCase(input.charAt(0));

            switch (action) {
                case 'F':
                    if (!goingForward && iterator.hasNext()) {
                        iterator.next();
                    }
                    goingForward = true;

                    if (iterator.hasNext()) {
                        System.out.println("Now visiting " + iterator.next());
                    } else {
                        System.out.println("You have reached the end of the itinerary.");
                    }
                    break;

                case 'B':
                    if (goingForward && iterator.hasPrevious()) {
                        iterator.previous();
                    }
                    goingForward = false;

                    if (iterator.hasPrevious()) {
                        System.out.println("Now visiting " + iterator.previous());
                    } else {
                        System.out.println("You are at the start of the itinerary.");
                    }
                    break;

                case 'L':
                    app.printItinerary();
                    break;

                case 'A':
                    System.out.print("Enter place name: ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }
                    System.out.print("Enter distance from Sydney (integer km): ");
                    String dStr = scanner.nextLine().trim();
                    int dist;
                    try {
                        dist = Integer.parseInt(dStr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid distance. Please enter an integer.");
                        break;
                    }
                    boolean added = app.addInOrder(new Place(name, dist));
                    if (added) {
                        System.out.println(name + " added to itinerary.");
                    }
                    iterator = app.itinerary.listIterator();
                    if (iterator.hasNext()) iterator.next();
                    goingForward = true;
                    break;

                case 'M':
                    printMenu();
                    break;

                case 'Q':
                    quit = true;
                    System.out.println("Exiting itinerary. Safe travels!");
                    break;

                default:
                    System.out.println("Unknown command. Type 'M' for menu.");
            }
        }

        scanner.close();
    }
}

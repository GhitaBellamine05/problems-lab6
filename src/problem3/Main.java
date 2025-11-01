package problem3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter library capacity: ");
        int n = sc.nextInt();
        Library lib = new Library(n);

        // Initialize with 2 documents
        lib.add(new Novel("Pride and Prejudice", "Jane Austen", 300, 19.99));
        lib.add(new Dictionary("Oxford Dictionary", "English"));

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Document");
            System.out.println("2. Display Documents");
            System.out.println("3. Delete Document");
            System.out.println("4. Search Document by numEnreg");
            System.out.println("5. Display Authors");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter month: ");
                    String month = sc.nextLine();
                    System.out.print("Enter year: ");
                    int year = Integer.parseInt(sc.nextLine());

                    lib.add(new Magazine(title, month, year));
                    break;

                case 2:
                    lib.displayDocuments();
                    break;

                case 3:
                    System.out.print("Enter numEnreg to delete: ");
                    int num = sc.nextInt();
                    Document d = lib.document(num);
                    if (d != null && lib.delete(d))
                        System.out.println("Deleted successfully.");
                    else
                        System.out.println("Document not found.");
                    break;

                case 4:
                    System.out.print("Enter numEnreg to search: ");
                    num = sc.nextInt();
                    Document doc = lib.document(num);
                    System.out.println(doc != null ? doc : "Not found.");
                    break;

                case 5:
                    lib.displayAuthors();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }
}

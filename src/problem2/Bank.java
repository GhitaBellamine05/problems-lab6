package problem2;

import java.util.ArrayList;

public class Bank {
    // attributes
    private String name;
    private ArrayList<Customer> customers;
    // Constructor
    public Bank(String name){
        this.name = name;
        this.customers = new ArrayList<>();
    }
    // getters
    public String getName(){
        return this.name;
    }
    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }
    // add new customer
    public boolean addCustomer(Customer customer) {
        if (customers.contains(customer)) {
            System.out.println("Customer already exists: " );
            return false;
        } else {
            customers.add(customer);
            System.out.println("New customer added: " + customer.getName());
            return true;
        }
    }

    public void addTransaction(Customer customer, double amount) {
            boolean found = false;
            for (Customer c : customers) {
                if (c.equals(customer)) {
                    c.addTransaction(amount);
                    System.out.println("Transaction added for " + customer.getName() + ": " + amount);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Customer not found.");
            }
        }
    // Print all customers and their transactions
    public void printStatements() {
        System.out.println("\nBank: " + name + " — Customer Statements");
        for (Customer c : customers) {
            System.out.println("Statement for " + c.getName() + ":");
            double total = 0.0;
            for (Double t : c.getTransactions()) {
                System.out.println("  " + t);
                total += t;
            }
            System.out.println("Total balance: " + total + "\n");
        }
    }

    }


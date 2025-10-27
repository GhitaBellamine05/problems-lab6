package problem2;

import java.util.ArrayList;

public class Customer {
    // attributes
    private String name;
    private ArrayList<Double> transactions;
    // Constructor
    public Customer(String name){
        this.name = name;
        this.transactions = new ArrayList<>();
    }
    // getters
    public String getName(){
        return this.name;
    }
    public ArrayList<Double> getTransactions(){
        return this.transactions;
    }
    // transaction method
    // credit if amount > 0
    // debit if amount < 0
    public void addTransaction(double amount){
        this.transactions.add(amount);
    }
    public void printInformations(){
            System.out.println("Statement for " + name + ":");
            for (Double transaction : transactions) {
                System.out.println("  " + transaction);
            }

    }
}


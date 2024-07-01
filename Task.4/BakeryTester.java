package finalexam.task4;

import java.io.IOException;

public class BakeryTester {
    public static void main(String[] args) {
        Bakery bakery = new Bakery("123 Bakery St", "VAT123456");

        // Create some Customer objects
        Customer c1 = new Customer("Alice", "alice@example.com", "555-1234");
        Customer c2 = new Customer("Bob", "bob@example.com", "555-5678");

        // Add customers to the bakery
        bakery.addCustomer(c1);
        bakery.addCustomer(c2);

        // Save the customer list to a file
        try {
            bakery.saveCustomersToFile("customers.dat");
        } catch (IOException e) {
            System.err.println("Error saving customer list: " + e.getMessage());
        }

        // Clear the current customer list
        bakery.getCustomers().clear();

        // Load the customer list from the file
        try {
            bakery.loadCustomersFromFile("customers.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading customer list: " + e.getMessage());
        }

        // Print the customer list after loading from the file
        System.out.println("Customer list after loading from file:");
        for (Customer c : bakery.getCustomers()) {
            System.out.println(c);
        }
    }
}

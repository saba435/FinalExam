package finalexam.task2;

import java.io.IOException;

public class FactoryTester {
    public static void main(String[] args) {
        PaperFactory factory = new PaperFactory();

        // Create some Person objects
        Person p1 = new Person("John", "Doe", "12345");
        Person p2 = new Person("Jane", "Smith", "67890");

        // Add persons to the factory
        factory.addPerson(p1);
        factory.addPerson(p2);

        // Save the staff list to a file
        try {
            factory.saveStaffToFile("staff.dat");
        } catch (IOException e) {
            System.err.println("Error saving staff list: " + e.getMessage());
        }

        // Clear the current staff list
        factory.getStaff().clear();

        // Load the staff list from the file
        try {
            factory.loadStaffFromFile("staff.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading staff list: " + e.getMessage());
        }

        // Print the staff list after loading from the file
        System.out.println("Staff list after loading from file:");
        for (Person p : factory.getStaff()) {
            System.out.println(p);
        }
    }
}

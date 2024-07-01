package finalexam.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bakery implements LegalEntity {
    private String address;
    private String vatNumber;
    private List<Customer> customers = new ArrayList<>();

    public Bakery(String address, String vatNumber) {
        this.address = address;
        this.vatNumber = vatNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getVatNumber() {
        return vatNumber;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean deleteCustomer(Customer customer) {
        return customers.remove(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    // Method to save customer list to a file
    public void saveCustomersToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(customers);
        }
    }

    // Method to load customer list from a file
    public void loadCustomersFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            customers = (List<Customer>) ois.readObject();
        }
    }
}

package ss8.bai_tap.crued_customer.service;

import ss5.thuc_tap.static_method.Student;
import ss8.bai_tap.crued_customer.customer.Customer;

import java.time.LocalDate;
import java.util.Scanner;

public class CustomerService {
    private static Customer[] customers = new Customer[100];
    private static Scanner scanner = new Scanner(System.in); // Sử dụng chung một Scanner

    static {
        customers[0] = new Customer("Anh", 123, "Ha Noi", LocalDate.of(1992, 2, 12));
        customers[1] = new Customer("Hạnh", 456, "Thái Bình", LocalDate.of(1991, 4, 24));
    }

    public Customer[] getAllCustomers() {
        return customers;
    }

    public void createCustomer() {
        System.out.println("Enter customer name: ");
        String name = scanner.next();
        System.out.println("Enter customer address: ");
        String address = scanner.next();
        System.out.println("Enter customer Id: ");
        int id = Integer.parseInt(scanner.next()) ;
        System.out.println("Enter customer Birth date (YYYY-MM-DD): ");
        String birthDate = scanner.next();
            LocalDate dateOfBirth = LocalDate.parse(birthDate);
            Customer newCustomer = new Customer(name, id, address, dateOfBirth);
            for (int i = 0; i < customers.length; i++) {
                if (customers[i] == null) {
                    customers[i] = newCustomer;
                    System.out.println("Customer added successfully.");
                    return;
                }
            }
            System.out.println("Customer array is full.");
    }
    public void removeCustomer() {
        System.out.println("Enter id need to remove:");
        int id = scanner.nextInt();
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null && customers[i].getId() == id) {
                customers[i] = null;
                System.out.println("Customer removed successfully.");
                return;
            }
        }
        System.out.println("Customer with id " + id + " not found.");
    }

    public void updateCustomer(int id) {
        for (Customer c : customers) {
            if (c != null && c.getId() == id) {
                System.out.println("Enter name to update:");
                String name = scanner.next();
                System.out.println("Enter address to update:");
                String address = scanner.next();
                System.out.println("Enter Birthday to update (YYYY-MM-DD):");
                String birthday = scanner.next();
                    c.setName(name);
                    c.setAddress(address);
                    c.setDateOfBirth(LocalDate.parse(birthday));
                    System.out.println("Customer updated successfully.");
                return;
            }
        }
        System.out.println("Customer with id " + id + " not found.");
    }

    public void showAllCustomers() {
        boolean hasCustomer = false;
        for (Customer c : customers) {
            if (c != null) {
                System.out.println(c);
                hasCustomer = true;
            }
        }
        if (!hasCustomer) {
            System.out.println("There are no customers.");
        }
    }
}
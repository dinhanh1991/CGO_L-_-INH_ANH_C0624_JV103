package ss9.bai_tap.crued_by_array_list.service;

import ss9.bai_tap.crued_by_array_list.customer.Customer;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    private static ArrayList<Customer> customer = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static {
        customer.add(0, new Customer("Anh", 123, "Hà Nội", LocalDate.of(1998, 02, 18)));
        customer.add(1, new Customer("Thanh", 234, "Thái Nguyên", LocalDate.of(1991, 04, 24)));
    }

    public void createCustomer() {
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.println("Enter customer address: ");
        String address = scanner.nextLine();
        System.out.println("Enter customer Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter customer Birth date (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(birthDate);
        Customer newCustomer = new Customer(name, id, address, dateOfBirth);
        customer.add(newCustomer);
    }

    public void removeCustomer() {
        System.out.println("Enter customer id: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < customer.size(); i++) {
            if (customer.get(i).getId() == id) {
                customer.remove(i);
                return;
            }
        }
        System.out.println("Id not found");
    }

    public void UpdateCustomer() {
        System.out.println("Enter customer id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.println("Enter customer address: ");
        String address = scanner.nextLine();
        System.out.println("Enter customer Birth date (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(birthDate);
        for (int i = 0; i < customer.size(); i++) {
            if (customer.get(i).getId() == id) {
                customer.get(i).setName(name);
                customer.get(i).setAddress(address);
                customer.get(i).setDateOfBirth(dateOfBirth);
                System.out.println("Updated customer");
                return;
            }
        }
        System.out.println("Id not found");
    }

    public void showCustomer() {
        for (Customer c : customer) {
            System.out.println(c.toString());
        }
    }
}

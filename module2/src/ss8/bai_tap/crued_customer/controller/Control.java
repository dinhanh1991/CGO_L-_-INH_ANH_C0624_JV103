package ss8.bai_tap.crued_customer.controller;

import ss8.bai_tap.crued_customer.service.CustomerService;

import java.util.Scanner;

public class Control {
    private static CustomerService customerService = new CustomerService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayCustomer();
    }

    public static void displayCustomer() {
        int choice;
        do {
            System.out.println(
                    "Menu: \n" +
                            "1.Create Customer\n" +
                            "2.Display Customer\n" +
                            "3.Delete Customer\n" +
                            "4.Update Customer\n" +
                            "0.Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    customerService.createCustomer();
                    break;
                case 2:
                    customerService.showAllCustomers();
                    break;
                case 3:
                    customerService.removeCustomer();
                    break;
                case 4:
                    System.out.print("Enter customer id to update: ");
                    int idCustomer = scanner.nextInt();
                    customerService.updateCustomer(idCustomer);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}
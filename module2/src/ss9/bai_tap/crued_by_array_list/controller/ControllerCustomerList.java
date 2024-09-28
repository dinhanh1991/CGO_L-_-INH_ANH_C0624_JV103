package ss9.bai_tap.crued_by_array_list.controller;

import ss9.bai_tap.crued_by_array_list.service.Service;

import java.util.Scanner;

public class ControllerCustomerList {
    private static Service service = new Service();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayCustomerList();
    }

    public static void displayCustomerList() {
        int choice;
        do {
            System.out.println("Menu: \n" +
                    "1.Create Customer\n" +
                    "2.Display Customer\n" +
                    "3.Delete Customer\n" +
                    "4.Update Customer\n" +
                    "5.Search for name\n" +
                    "0.Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    service.createCustomer();
                    System.out.println("List Customer after creation :");
                    service.showCustomer();
                    break;
                case 2:
                    service.showCustomer();
                    break;
                case 3:
                    service.removeCustomer();
                    System.out.println("List Customer after removing :");
                    service.showCustomer();
                    break;
                case 4:
                    service.UpdateCustomer();
                    System.out.println("List Customer after updating :");
                    service.showCustomer();
                    break;
                case 5:
                    service.lookingForCustomerByName();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}

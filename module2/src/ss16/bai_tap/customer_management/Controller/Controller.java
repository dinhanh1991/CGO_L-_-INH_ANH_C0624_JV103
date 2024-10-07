package ss16.bai_tap.customer_management.Controller;

import ss16.bai_tap.customer_management.Service.Service;

import java.util.Scanner;

public class Controller {
    private static final Service service = new Service();
    public static Scanner scanner = new Scanner(System.in);

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
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    service.addCustomer();
                    System.out.println("List Customer after creation :");
                    service.showCustomer();
                    break;
                case 2:
                    service.showCustomer();
                    break;
                case 3:
                    service.deleteCustomer();
                    System.out.println("List Customer after removing :");
                    service.showCustomer();
                    break;
                case 4:
                    service.UpdateCustomer();
                    System.out.println("List Customer after updating :");
                    service.showCustomer();
                    break;
                case 5:
                    service.searchCustomer();
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

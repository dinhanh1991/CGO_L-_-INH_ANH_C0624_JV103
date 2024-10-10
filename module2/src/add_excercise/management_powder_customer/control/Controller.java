package add_excercise.management_powder_customer.control;

import add_excercise.management_powder_customer.service.CustomerService;
import add_excercise.management_powder_customer.service.InvoiceService;

import java.util.Scanner;

public class Controller {
    private static final CustomerService customerService = new CustomerService();
    private static final InvoiceService invoiceService = new InvoiceService();
    private  Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayCustomerAndInvoice();
    }

    public static void displayCustomerAndInvoice() {
        int choice;
        do {
            System.out.println("Menu: \n" +
                    "1.Add Customer\n" +
                    "2.Display Customer\n" +
                    "3.Search for name\n" +
                    "4.Add Invoice\n" +
                    "5.Update Invoice\n" +
                    "6.Display Invoice\n" +
                    "0.Exit");
            System.out.print("Enter your choice: ");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    customerService.addCustomer();
                    break;
                case 2:
                    customerService.showCustomers();
                    break;
                case 3:
                    customerService.searchCustomer();
                    break;
                case 4:
                  invoiceService.addInvoice();
                    break;
                case 5:
                    invoiceService.editInvoice();
                    break;
                case 6:
                    invoiceService.showInvoices();
                    break;
                case 7:
                    break;
                case 0:
                    System.out.println("Goodbye! \n" +
                            "Exiting...");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}

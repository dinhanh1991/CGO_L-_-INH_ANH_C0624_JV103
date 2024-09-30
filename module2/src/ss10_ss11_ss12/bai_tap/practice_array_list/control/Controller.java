package ss10_ss11_ss12.bai_tap.practice_array_list.control;

import ss10_ss11_ss12.bai_tap.practice_array_list.service.ProductManager;

import java.util.Scanner;

public class Controller {
    private static final ProductManager productManager = new ProductManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        display();
    }

    public static void display() {
        int choice;
        do {
            System.out.println("Menu: \n" +
                    "1.Create Product\n" +
                    "2.Update Product\n" +
                    "3.Delete Product\n" +
                    "4.Display Product\n" +
                    "5.Search for id\n" +
                    "6.Arrange Product for price\n" +
                    "0.Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    productManager.addProduct();
                    System.out.println("List product after creation :");
                    productManager.displayProducts();
                    break;
                case 2:
                    productManager.updateProduct();
                    System.out.println("List product after updating :");
                    productManager.displayProducts();
                    break;
                case 3:
                    productManager.deleteProduct();
                    System.out.println("List Customer after removing :");
                    productManager.displayProducts();
                    break;
                case 4:
                    productManager.displayProducts();
                    break;
                case 5:
                    productManager.searchProduct();
                    break;
                case 6:
                    productManager.arrangeProducts();
                    System.out.println("List Customer after arranging :");
                    productManager.displayProducts();
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

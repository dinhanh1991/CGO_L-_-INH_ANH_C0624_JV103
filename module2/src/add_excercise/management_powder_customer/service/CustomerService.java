package add_excercise.management_powder_customer.service;

import java.io.*;
import java.util.Scanner;

public class CustomerService {
    private static final String customer_file = "D:\\Codegym\\Codegym module 2\\module2\\" +
            "src\\add_excercise\\management_powder_customer\\cvs_file\\customer.cvs";
    Scanner input = new Scanner(System.in);

    public void addCustomer() {
        System.out.println("Enter kind of Customer : \n" +
                "1.Domestic customer.\n" +
                "2.International customer.\n" +
                "Please chose:");
        int choice = Integer.parseInt(input.nextLine());
        System.out.println("Your choice: " + choice);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(customer_file, true))) {
            if (choice == 1) {
                System.out.println("Domestic customer");
                System.out.println("Enter Customer Name : ");
                String name = input.nextLine();
                System.out.println("Enter id customer follow form DMTC-xxxxx : ");
                String id = input.nextLine();
                while (!id.matches("DMTC-\\d{5}")) {
                    System.out.println("Enter id customer follow form DMTC-xxxxx : ");
                    id = input.nextLine();
                }
                System.out.println("Enter type of customer (Residential customers," +
                        "Business customers or Industrial customers : ");
                String type = input.nextLine();
                System.out.println("Enter consumption : ");
                int consumption = Integer.parseInt(input.nextLine());
                bw.write(id + "," + name + "," + type + "," + consumption);
                bw.newLine();
                System.out.println("Domestic Customer added");
            } else if (choice == 2) {
                System.out.println("International customer ");
                System.out.println("Enter id customer follow form ITNC-xxxxx : ");
                String id = input.nextLine();
                while (!id.matches("ITNC-\\d{5}")) {
                    System.out.println("Enter id customer follow form ITNC-xxxxx : ");
                    id = input.nextLine();
                }
                System.out.println("Enter name of customer: ");
                String name = input.nextLine();
                System.out.println("Enter nationality of customer: ");
                String nationality = input.nextLine();
                bw.write(id + "," + name + "," + nationality);
                bw.newLine();
                System.out.println("International Customer added");
            } else {
                System.out.println("Invalid choice");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCustomers() {
        try (BufferedReader read = new BufferedReader(new FileReader(customer_file))) {
            String line;
            while ((line = read.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchCustomer() {
        System.out.println("Enter the name who you want to search: ");
        String name = input.nextLine().toLowerCase();
        try (BufferedReader read = new BufferedReader(new FileReader(customer_file))) {
            String line;
            boolean found = false;
            while ((line = read.readLine()) != null) {
                if (line.toLowerCase().contains(name)) {
                    System.out.println(line);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Customer not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

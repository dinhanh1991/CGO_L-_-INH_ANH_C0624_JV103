package add_excercise.management_powder_customer.service;

import add_excercise.management_powder_customer.model.Customer;
import add_excercise.management_powder_customer.model.Invoice;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InvoiceService {
    private static final String invoice_file = "D:\\Codegym\\Codegym module 2\\module2\\" +
            "src\\add_excercise\\management_powder_customer\\cvs_file\\invoice.cvs";
    Scanner sc = new Scanner(System.in);
    public void addInvoice(Customer customer) {
        System.out.println("Enter Customer ID: ");
        String invoiceID = sc.nextLine();
        System.out.println("Enter date  ");
        String date = sc.nextLine();
        System.out.println("Enter usage");
        int usage = sc.nextInt();
        System.out.println("Enter unit price ");
        double unitPrice = sc.nextDouble();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Invoice invoice = new Invoice(invoiceID,customer, LocalDate.parse(date,formatter),usage,unitPrice);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(invoice_file,true))) {
            bw.write(invoiceID+","+customer.getId()+","+date+","+usage+","+unitPrice +"," +invoice.getAmount());
            bw.newLine();
            System.out.println("Invoice added");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showInvoice() {
        System.out.println("Enter Invoice ID: ");
        String invoiceID = sc.nextLine();
        try(BufferedReader br = new BufferedReader(new FileReader(invoice_file))) {
            String line ;
            while ((line = br.readLine()) != null) {
                List<String> information= Arrays.asList(line.split(","));
                if (information.get(0).equals(invoiceID)) {
                    System.out.println("Invoice ID: " + invoiceID);
                    System.out.println("Customer ID: " + information.get(1));
                    System.out.println("Invoice Date: " + information.get(2));
                    System.out.println("Invoice Usage: " + information.get(3));
                    System.out.println("Invoice UnitPrice: " + information.get(4));
                    System.out.println("Invoice Amount: " + information.get(5));
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateInvoice(Customer customer) {
        System.out.println("Enter Invoice ID: ");
        String invoiceID = sc.nextLine();

    }
}

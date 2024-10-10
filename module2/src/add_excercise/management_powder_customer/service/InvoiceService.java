package add_excercise.management_powder_customer.service;

import add_excercise.management_powder_customer.model.Invoice;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceService {
    private final String invoice_path = "module2/src/add_excercise/management_powder_customer/cvs_file/invoice";
    private final String customerList_path = "module2/src/add_excercise/management_powder_customer/cvs_file/invoice";
    private final CustomerService customerService = new CustomerService();
    private final Scanner scanner = new Scanner(System.in);
    private int idcount = 1;

    public void addInvoice() {
        if (!new File(customerList_path).exists()) {
            System.out.println("No customers available. Please add customers first.");
            return;
        }
        System.out.println("Enter customer id followed by customer list:");
        customerService.showCustomers();
        String idCustomer = scanner.nextLine();
        System.out.println("Enter Usage ");
        int usage = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter unit price");
        double unitPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter date");
        String date = scanner.nextLine();
        double amount = calculateAmount(idCustomer, usage, unitPrice);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(invoice_path, true))) {
            bw.write(String.join(",", "MHD" + idcount++, idCustomer, date, String.valueOf(usage), String.valueOf(unitPrice), String.valueOf(amount)));
            bw.newLine();
            System.out.println("Invoice added");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editInvoice() {
        List<String[]> invoiceList = readFile(invoice_path);
        System.out.println("Enter Invoice id to edit:");
        String idInvoice = scanner.nextLine();
        updateInvoice(invoiceList, idInvoice);
        writeFile(invoiceList, invoice_path);
        System.out.println("Invoice updated");
    }

    public void showInvoices() {
        List<String[]> invoiceList = readFile(invoice_path);
        System.out.println("Please select the invoice id:");
        String idInvoice = scanner.nextLine();

        String idCustomer = findCustomerId(invoiceList, idInvoice);
        if (idCustomer == null) return;

        String customerName = findCustomerName(idCustomer);
        if (customerName == null) {
            System.out.println("Customer not found");
            return;
        }

        displayInvoiceDetails(invoiceList, idInvoice, customerName);
    }

    private List<String[]> readFile(String path) {
        List<String[]> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void writeFile(List<String[]> data, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String findCustomerId(List<String[]> invoiceList, String idInvoice) {
        for (String[] invoice : invoiceList) {
            if (invoice[0].equals(idInvoice)) {
                return invoice[1];
            }
        }
        return null;
    }

    private String findCustomerName(String idCustomer) {
        List<String[]> customerList = readFile(customerList_path);
        for (String[] customer : customerList) {
            if (customer[0].equals(idCustomer)) {
                return customer[1];
            }
        }
        return null;
    }

    private void displayInvoiceDetails(List<String[]> invoiceList, String idInvoice, String customerName) {
        for (String[] invoice : invoiceList) {
            if (invoice[0].equals(idInvoice)) {
                System.out.println("Invoice id: " + invoice[0] + "\nCustomer Name: " + customerName +
                        "\nInvoice issue date: " + invoice[2] + "\nNumber of kW used: " + invoice[3] +
                        "\nUnit price: " + invoice[4] + "\nTotal amount: " + invoice[5]);
            }
        }
    }

    private void updateInvoice(List<String[]> invoiceList, String idInvoice) {
        System.out.println("Enter new customer id:");
        String idCustomer = scanner.nextLine();
        System.out.println("Enter new Invoice date:");
        String invoiceDate = scanner.nextLine();
        System.out.println("Enter new unit price:");
        double unitPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter new Usage:");
        int usage = Integer.parseInt(scanner.nextLine());
        double amount = calculateAmount(idCustomer, usage, unitPrice);

        for (String[] invoice : invoiceList) {
            if (invoice[0].equals(idInvoice)) {
                invoice[1] = idCustomer;
                invoice[2] = invoiceDate;
                invoice[3] = String.valueOf(usage);
                invoice[4] = String.valueOf(unitPrice);
                invoice[5] = String.valueOf(amount);
            }
        }
    }

    public double calculateAmount(String id, int usage, double unitPrice) {
        if (id.startsWith("VNC-")) {
            for (String[] customer : readFile(customerList_path)) {
                if (customer[0].equals(id)) {
                    int quota = Integer.parseInt(customer[3]);
                    if (usage<=quota){
                        return  usage * unitPrice;
                    }else {
                        return quota * unitPrice + (usage - quota) * unitPrice * 2.5;
                    }
                }
            }
        } else if (id.startsWith("FRC-")) {
            return usage * unitPrice;
        }
        return 0;
    }
}
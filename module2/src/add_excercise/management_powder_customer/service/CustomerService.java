package add_excercise.management_powder_customer.service;

import add_excercise.management_powder_customer.model.Customer;
import add_excercise.management_powder_customer.model.DomesticCustomer;
import add_excercise.management_powder_customer.model.InternationalCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerService {
    private final String customer_file = "module2/src/add_excercise/" +
            "management_powder_customer/cvs_file/customer";
    Scanner input = new Scanner(System.in);
    private List<DomesticCustomer> vietNamCustomers = new ArrayList<DomesticCustomer>();
    private List<InternationalCustomer> foreignerCustomer = new ArrayList<InternationalCustomer>();

    public void addCustomer() {
        System.out.println("Enter customer name: ");
        String nameCustomer = input.nextLine();
        System.out.println(
                "Enter Your option: \n" +
                        "1.Vietnamese Customer\n" +
                        "2.Foreigner Customer");
        int option = input.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter the ID customer in the format VNC-xxxxx. ");
                String idCustomer = input.nextLine();
                while (!idCustomer.matches("VNC-\\d{5}")) {
                    System.out.println("Enter the ID customer in the format VNC-xxxxx. ");
                    idCustomer = input.nextLine();
                }
                System.out.println("Enter the customer type " +
                        "(choose one of the following: residential, business, or production) ");
                String typeCustomer = input.nextLine();
                System.out.println("Enter the consumption");
                int consumption = Integer.parseInt(input.nextLine());
                vietNamCustomers.add(new DomesticCustomer(idCustomer, nameCustomer,
                        typeCustomer, consumption));
                File file = new File(customer_file);
                try(BufferedWriter bw=new BufferedWriter(new FileWriter(file,true))) {
                    bw.write(idCustomer+","+nameCustomer+","+typeCustomer+","+consumption+",.");
                    bw.newLine();
                }catch (IOException e){
                    e.printStackTrace();
                }
                System.out.println("Customer Added Successfully");
                break;
            case 2:
                System.out.println("Enter the ID foreigner customer in the format FRC-xxxxx. ");
                String idForeigner = input.nextLine();
                while (!idForeigner.matches("FRC-\\d{5}")) {
                    System.out.println("Enter the ID customer in the format FRC-xxxxx. ");
                    idForeigner = input.nextLine();
                }
                System.out.println("Enter the Nationality of Customer");
                String nationalityCustomer = input.nextLine();
                foreignerCustomer.add(new InternationalCustomer(idForeigner, nameCustomer
                        , nationalityCustomer));
                File frFile = new File(customer_file);
                try(BufferedWriter bw=new BufferedWriter(new FileWriter(frFile,true))) {
                    bw.write(idForeigner+","+nameCustomer+",,,"+nationalityCustomer);
                    bw.newLine();
                }catch (IOException e){
                    e.printStackTrace();
                }
                System.out.println("Customer Added Successfully");
                break;
                default:
                    System.out.println("You must choose either number 1 or number 2.");
                    break;
        }
    }
    public void showCustomers() {
                File file = new File(customer_file);
                try (BufferedReader read = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = read.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }
    public void searchCustomer() {
        System.out.println("Enter the name customer ");
        String nameCustomer = input.nextLine();
        List<String[]> listCustomer =new ArrayList<>();
        File file = new File(customer_file);
        try(BufferedReader br =new BufferedReader(new FileReader(file))) {
           String line;
           while ((line = br.readLine()) != null) {
               String[] data = line.split(",");
               listCustomer.add(data);
           }
        }catch (IOException e){
            e.printStackTrace();
        }
        boolean found = false;
        for (int i = 0; i < listCustomer.size(); i++) {
            if (listCustomer.get(i)[1].toLowerCase().equals(nameCustomer.toLowerCase())) {
                System.out.println( listCustomer.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Customer Not Found");
        }
    }
}

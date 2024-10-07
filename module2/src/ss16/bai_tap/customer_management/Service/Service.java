package ss16.bai_tap.customer_management.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private final String path = "D:\\Codegym\\Codegym module 2\\module2" +
            "\\src\\ss16\\bai_tap\\customer_management\\file_customer\\list_customer";
    Scanner sc = new Scanner(System.in);

    public void addCustomer() {
        File file = new File(path);
        System.out.println("Enter id of Customer");
        String id = sc.nextLine();
        System.out.println("Enter name of Customer");
        String name = sc.nextLine();
        System.out.println("Enter address of Customer");
        String address = sc.nextLine();
        System.out.println("Enter Birthday of Customer");
        String birthday = sc.nextLine();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(id + "," + name + "," + address + "," + birthday);
            bw.newLine();
            System.out.println("Customer Added Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCustomer() {
        File file = new File(path);
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = read.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void UpdateCustomer() {
        File file = new File(path);
        System.out.println("Enter id of Customer choose one of list");
        showCustomer();
        String id = sc.nextLine();
        System.out.println("Enter name of Customer");
        String name = sc.nextLine();
        System.out.println("Enter address of Customer");
        String address = sc.nextLine();
        System.out.println("Enter Birthday of Customer");
        List<String[]> cvsData = new ArrayList<>();
        System.out.println("Enter Birthday of Customer");
        String birthday = sc.nextLine();
        String[] newData = {id, name, address, birthday};
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = read.readLine()) != null) {
                String[] data = line.split(",");
                cvsData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean found = false;
        for (int i = 0; i < cvsData.size(); i++) {
            if (id.equals(cvsData.get(i)[0])) {
                cvsData.set(i, newData);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Customer Not Found");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String[] data : cvsData) {
                writer.write(data[0] + "," + data[1] + "," + data[2] + "," + data[3]);
                writer.newLine();
            }
            System.out.println("Customer Updated Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer() {
        File file = new File(path);
        System.out.println("Enter id of Customer chose one of list which you want to delete");
        showCustomer();
        String id = sc.nextLine();
        List<String[]> cvsData = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = read.readLine()) != null) {
                String[] data = line.split(",");
                cvsData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean found = false;
        for (int i = 0; i < cvsData.size(); i++) {
            if (id.equals(cvsData.get(i)[0])) {
                cvsData.remove(cvsData.get(i));
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Customer Not Found");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String[] data : cvsData) {
                writer.write(data[0] + "," + data[1] + "," + data[2] + "," + data[3]);
                writer.newLine();
            }
            System.out.println("Customer Updated Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchCustomer() {
        File file = new File(path);
        System.out.println("Enter id of Customer choose one of list which you want to search");
        showCustomer();
        String id = sc.nextLine();
        List<String[]> cvsData = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = read.readLine()) != null) {
                String[] data = line.split(",");
                cvsData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean found = false;
        for (int i = 0; i < cvsData.size(); i++) {
            if (id.equals(cvsData.get(i)[0])) {
                System.out.println("ID: " + cvsData.get(i)[0] +
                        ", Name: " + cvsData.get(i)[1] +
                        ", Address: " + cvsData.get(i)[2] +
                        ", Birthday: " + cvsData.get(i)[3]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Customer Not Found");
        }
    }
}

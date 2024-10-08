package ss17.bai_tap.save_product.controller;

import ss17.bai_tap.save_product.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void writeDatatofile(String path, List<Product> products) {
        try {
            FileOutputStream fos =new FileOutputStream(path);
            ObjectOutputStream oOS =new ObjectOutputStream(fos);
            oOS.writeObject(products);
            oOS.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readDataToFile(String path) {
        List<Product> products = new ArrayList<Product>();
        try {
            FileInputStream fIS= new FileInputStream(path);
            ObjectInputStream oIS=new ObjectInputStream(fIS);
            products = (List<Product>) oIS.readObject();
            fIS.close();
            oIS.close();
        } catch (RuntimeException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Product> products =new ArrayList<>();
        products.add(new Product("Ip15","Iphone 15",15000000,"Apple","Black"));
        products.add(new Product("Ip14","Iphone 14",14000000,"Apple","White"));
        products.add(new Product("S23","Sámung S23",17000000,"Samsung","Pink"));
        System.out.println("Enter path: ");
        String path =sc.nextLine();
        writeDatatofile(path,products);
        readDataToFile(path);
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

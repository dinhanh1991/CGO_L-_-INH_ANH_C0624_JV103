package ss10.bai_tap.practice_array_list.service;

import ss10.bai_tap.practice_array_list.product_model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> products =new ArrayList<>();
    private Scanner scanner=new Scanner(System.in);
    public ProductManager() {
        products.add(new Product("Iphone 11",11000000,"Ip11_123"));
        products.add(new Product("SamSung GalaxyS 21",17000000,"SGS21_123"));
    }
    public void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter product id: ");
        String id = scanner.nextLine();
        products.add(new Product(name,price,id));
    }
    public void updateProduct() {
        System.out.print("Enter product ID which you want to update: ");
       String id = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        int price = Integer.parseInt(scanner.nextLine());
        for (Product product : products) {
            if (product.getId().equals(id)) {
                product.setName(name);
                product.setPrice(price);
                return;
            }
        }
        System.out.println("Product not found");
    }
    public void deleteProduct() {
        System.out.print("Enter product ID which you want to delete: ");
        String id = scanner.nextLine();
        for (Product product : products) {
            if (product.getId().equals(id)) {
                products.remove(product);
                return;
            }
        }
        System.out.println("Product not found");
    }
    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public void searchProduct() {
        System.out.print("Enter product ID which you want to search: ");
        String id = scanner.nextLine();
        for (Product product : products) {
            if (product.getId().equals(id)) {
                System.out.println(product);
                return;
            }
        }
        System.out.println("Product not found");
    }
    public void arrangeProducts() {
        Collections.sort(products, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return Integer.compare(p1.getPrice(), p2.getPrice());
            }
        });
        System.out.println("List Product after arrange");
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

package ss1.thuc_hanh;

import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        double weight,tall,bodyMassIndex;
        System.out.println("Enter the weight of the body (In Kilogram):");
        Scanner sc = new Scanner(System.in);
        weight = sc.nextDouble();
        System.out.println("Enter the tall of the body (In meter):");
        tall = sc.nextDouble();
        bodyMassIndex = weight / Math.pow(tall, 2);
        System.out.printf("%-20.2f%s", bodyMassIndex, "Interpretation\n");
        if (bodyMassIndex<18){
            System.out.printf("%-20.2f%s", bodyMassIndex, "Under weight");
        } else if (bodyMassIndex<25) {
            System.out.printf("%-20.2f%s", bodyMassIndex, "Normal");
        }else if (bodyMassIndex<30) {
            System.out.printf("%-20.2f%s", bodyMassIndex, "Overweight");
        }else {
            System.out.printf("%-20.2f%s", bodyMassIndex, "Obese");
        }
    }
}

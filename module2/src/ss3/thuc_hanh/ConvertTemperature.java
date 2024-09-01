package ss3.thuc_hanh;

import java.util.Scanner;

public class ConvertTemperature {
    public static void main(String[] args) {
        double celsius, fahrenheit;
        int choice=-1;
        while (choice!=0){
            System.out.print("Menu: ");
            System.out.println("1.");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice=new Scanner(System.in).nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter temperature in Fahrenheit: ");
                    fahrenheit=new Scanner(System.in).nextDouble();
                    System.out.println("Fahrenheit to Celsius: " + fahrenheitToCelsius(fahrenheit));
                    break;
                    case 2:
                        System.out.println("Enter temperature in Celsius: ");
                        celsius=new Scanner(System.in).nextDouble();
                        System.out.println("Celsius to Fahrenheit: " + celsiusToFahrenheit(celsius));
                        break;
                        case 0:
                            System.out.println("Goodbye!");
            }
        }
    }
    public static double celsiusToFahrenheit(double celsius){
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit){
        double celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }
}

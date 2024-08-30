package ss2.thuc_hanh;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        int number1, number2;
        int count =0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        number1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        number2 = sc.nextInt();
        for (int i=1; i<=number1; i++) {
            if (number2%i==0&&number1%i==0) {
                count=i;
            }
        }
        System.out.println("The greatest common divisor is: "+count);
    }
}

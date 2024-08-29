package ss2.bai_tap;

import java.util.Scanner;

public class PrimeNuberLessThan100 {
    public static void main(String[] args) {
        int number;
        int fistNumber = 2;
        Scanner sc = new Scanner(System.in);
        String string = "các  số nguyên tố nhỏ hơn 100 là: " + fistNumber + "; ";
        while (fistNumber < 100) {
            fistNumber++;
            boolean isPrime = true;
            for (int i = 2; i < Math.sqrt(fistNumber) + 0.1; i++) {
                if (fistNumber % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                string = string + fistNumber + "; ";
            }
        }
        System.out.println(string);
    }
}

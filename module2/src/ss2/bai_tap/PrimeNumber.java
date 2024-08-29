package ss2.bai_tap;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        int number;
        int count = 1;
        int fistNumber = 2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");//so lượng số nguyen tố cần in ra
        number = sc.nextInt();
        String string = number + "  số nguyên tố đầu tiên là: " + fistNumber + "; ";
        while (count < number) {
            fistNumber++;
            boolean isPrime = true;
            for (int i = 2; i < Math.sqrt(fistNumber) + 0.1; i++) {
                if (fistNumber % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                count++;
                string = string + fistNumber + "; ";
            }
        }
        System.out.println(string);
    }
}

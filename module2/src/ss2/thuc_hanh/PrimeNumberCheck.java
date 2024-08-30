package ss2.thuc_hanh;

import java.util.Scanner;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        int number;
        System.out.println("Enter number");
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();
        if (number<2){
            System.out.println(number+" is not Prime Number");
        } else if (number<4) {
            System.out.println(number+" is Prime Number");
        } else {
            boolean isPrime = true;
            for (int i = 2; i < Math.sqrt(number)+0.1; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(number+" is Prime Number");
            }else {
                System.out.println(number+" is not Prime Number");
            }
        }
    }
}

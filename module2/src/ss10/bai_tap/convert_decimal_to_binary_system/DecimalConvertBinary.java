package ss10.bai_tap.convert_decimal_to_binary_system;

import java.util.Scanner;
import java.util.Stack;

public class DecimalConvertBinary {
    public static void main(String[] args) {
        Stack<Integer> binaryArray=new Stack<>();
        int numberDecimal;
        System.out.println("Enter Decimal Number");
        Scanner sc=new Scanner(System.in);
        numberDecimal=sc.nextInt();
        int decimal=numberDecimal;
        do {
            binaryArray.push(decimal%2);
            decimal=decimal/2;
        }while (decimal>0);
        System.out.print("Number "+numberDecimal+" convert to Binary : ");
        for (int b:binaryArray){
            System.out.print(b);
        }
    }
}

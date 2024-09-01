package ss3.thuc_hanh;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        int size;
        int[] arrayNumbers;
        System.out.println("Enter the size of the array: ");
        size=new Scanner(System.in).nextInt();
        while (size>20){
            System.out.println("Enter the size of the array again size must not greater than 20: ");
            size=new Scanner(System.in).nextInt();
        }
        arrayNumbers=new int[size];
        for (int i=0;i<size;i++){
            System.out.println("Enter the number "+(i+1)+": ");
            arrayNumbers[i]=new Scanner(System.in).nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int i=0;i<size;i++){
            System.out.print(arrayNumbers[i]+"\t ");
        }
        int maxNumber = arrayNumbers[0];
        for (int i=1;i<size;i++){
            if (arrayNumbers[i]>maxNumber){
                maxNumber=arrayNumbers[i];
            }
        }
        System.out.println("The max number of arrayNumber is "+maxNumber);
    }
}

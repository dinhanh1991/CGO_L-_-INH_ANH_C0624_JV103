package ss3.thuc_hanh;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        int size;
        int[] arrayNumber;
        System.out.println("Enter the size of the array: ");
        size=new Scanner(System.in).nextInt();
        while (size>20) {
            System.out.println("Enter the size of the array again size 's not than greater 20: ");
            size=new Scanner(System.in).nextInt();
        }
        arrayNumber=new int[size];
        for (int i=0;i<size;i++) {
            System.out.println("Enter the number "+(i+1)+": ");
            arrayNumber[i]=new Scanner(System.in).nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j=0;j<size;j++) {
            System.out.print(arrayNumber[j]+"\t");
        }
        for (int j=0;j<size/2;j++) {
            arrayNumber[j]+=arrayNumber[size-j-1];
            arrayNumber[size-j-1]=arrayNumber[j]-arrayNumber[size-j-1];
            arrayNumber[j]-=arrayNumber[size-j-1];
        }
        System.out.printf("%-20s%s", "Reverse array: ", "");
        for (int j=0;j<size;j++) {
            System.out.print(arrayNumber[j]+"\t");
        }
    }
}

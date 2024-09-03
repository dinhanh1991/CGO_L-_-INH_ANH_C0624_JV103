package ss3.bai_tap;

import java.util.Scanner;

public class JointArray {
    public static void main(String[] args) {
        int [] arrayNumber1,arrayNumber2,arrayNumber3;
        int size1,size2,size3;
        System.out.println("Enter the size of array 1: ");
        size1=new Scanner(System.in).nextInt();
        System.out.println("Enter the size of array 2: ");
        size2=new Scanner(System.in).nextInt();
        arrayNumber1=new int[size1];
        arrayNumber2=new int[size2];
        size3=size1+size2;
        arrayNumber3=new int[size3];
        for (int i = 0; i < size1; i++) {
            System.out.println("Enter the element "+(i+1)+"of Array 1 : ");
            arrayNumber1[i]=new Scanner(System.in).nextInt();
        }
        for (int i = 0; i < size2; i++) {
            System.out.println("Enter the element "+(i+1)+"of Array 2 : ");
            arrayNumber2[i]=new Scanner(System.in).nextInt();
        }
        System.out.printf("%-20s%s", "Elements in Array 1: ", "");
        for (int i = 0; i < size1; i++) {
            System.out.print(arrayNumber1[i]+"\t");
        }
        System.out.println();
        System.out.printf("%-20s%s", "Elements in Array 2: ", "");
        for (int i = 0; i < size2; i++) {
            System.out.print(arrayNumber2[i]+"\t");
        }
        System.out.println();
        for (int i = 0; i <size3; i++) {
            if (i<size1){
                arrayNumber3[i]=arrayNumber1[i];
            }else {
                arrayNumber3[i]=arrayNumber2[i-size1];
            }
        }
        System.out.printf("%-20s%s", "Elements in Array 3: ", "");
        for (int i = 0; i < arrayNumber3.length; i++) {
            System.out.print(arrayNumber3[i]+"\t");
        }
    }
}

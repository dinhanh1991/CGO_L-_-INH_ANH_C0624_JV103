package ss3.bai_tap;

import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arrayNumber;
        int sizeOfArray;
        System.out.println("Enter the size of the array: ");
        sizeOfArray=new Scanner(System.in).nextInt();
        while (sizeOfArray>20) {
            System.out.println("Enter the size of the array again: ");
            sizeOfArray=new Scanner(System.in).nextInt();
        }
        arrayNumber=new int[sizeOfArray];
        for (int i=0;i<sizeOfArray;i++) {
            System.out.println("Enter the Element"+(i+1)+": ");
            arrayNumber[i]=new Scanner(System.in).nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int i=0;i<sizeOfArray;i++) {
            System.out.print(arrayNumber[i]+"\t ");
        }
        int number;
        System.out.println("Enter the number to be removed: ");
        number=new Scanner(System.in).nextInt();
        if(findElements(arrayNumber,number)!=0) {
            System.out.printf("%-20s%s", "Indexes in array need to remove: ", "");
            for (int i=0;i<arrayNumber.length;i++) {
                if (arrayNumber[i]==number) {
                    System.out.print((i+1)+"\t");
                }
            }
            while (findElements(arrayNumber,number)>0) {
                for (int i=0;i<sizeOfArray;i++) {
                    if (arrayNumber[i]==number) {
                        for (int j=i;j<sizeOfArray-1;j++) {
                            arrayNumber[j]=arrayNumber[j+1];
                        }
                        arrayNumber[sizeOfArray-1]=0;
                    }
                }
            }
            System.out.printf("%-20s%s", "Elements in array after removing: ", "");
            for (int i=0;i<sizeOfArray;i++) {
                System.out.print(arrayNumber[i]+"\t ");
            }
        }else {
            System.out.println("Element not found");
        }

    }
    public static int findElements(int[] array,int number) {
        int count =0 ;
        for (int i=0;i<array.length;i++) {
            if (array[i]==number) {
                count++;
                break;
            }
        }
        return count;
    }
}

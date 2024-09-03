package ss3.bai_tap;

import java.util.Scanner;

public class AdditionElements {
    public static void main(String[] args) {
        int element, index, size;
        int[] arrayNumber;
        System.out.println("Enter element");
        element = new Scanner(System.in).nextInt();
        System.out.println("Enter index");
        index = new Scanner(System.in).nextInt();
        System.out.println("Enter size");
        size = new Scanner(System.in).nextInt();
        while (size > 20) {
            System.out.println("Enter the size of the array again: ");
            size = new Scanner(System.in).nextInt();
        }
        arrayNumber = new int[size];
        for (int i = 0; i < size - 1; i++) {
            System.out.println("Enter the Element" + (i + 1) + ": ");
            arrayNumber[i] = new Scanner(System.in).nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(arrayNumber[i] + "\t ");
        }
        System.out.println();
        if (index < 0 || index > size) {
            System.out.println("Invalid Index");
        } else {
            for (int i = arrayNumber.length-1; i > index-1; i--) {
                arrayNumber[i] = arrayNumber[i - 1];
            }
            arrayNumber[index - 1]=element;
        }
        System.out.printf("%-20s%s", "Elements in array after change: ", "");
        for (int i = 0; i < size; i++) {
            System.out.print(arrayNumber[i] + "\t ");
        }
    }
}

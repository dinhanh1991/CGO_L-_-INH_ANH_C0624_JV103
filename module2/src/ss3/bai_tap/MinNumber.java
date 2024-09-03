package ss3.bai_tap;

import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        int size;
        int[] arrayNumbers;
        System.out.println("Enter the size of the array: ");
        size = new Scanner(System.in).nextInt();
        while (size > 20) {
            System.out.println("Enter the size of the array again size must not greater than 20: ");
            size = new Scanner(System.in).nextInt();
        }
        arrayNumbers = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter the number " + (i + 1) + ": ");
            arrayNumbers[i] = new Scanner(System.in).nextInt();
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int i = 0; i < size; i++) {
            System.out.print(arrayNumbers[i] + "\t ");
        }
        System.out.println("The min number of arrayNumber is:" + findMinValue(arrayNumbers));
    }

    public static int findMinValue(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}


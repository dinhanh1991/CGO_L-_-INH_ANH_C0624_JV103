package ss14.bai_tap;

import java.util.Scanner;

public class BubbleInsertSort {
    public static void main(String[] args) {
        int length;
        System.out.println("Enter the size of the array");
        Scanner sc = new Scanner(System.in);
        length = sc.nextInt();
        int[] arr = new int[length];
        System.out.println("Enter " + arr.length + " values:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("\nBegin sort processing...");
        bubbleSort(arr);
        System.out.println("\nEnd sort processing.");
        System.out.println("After Sorting");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>temp) {
                arr[j+1] = arr[j];
                j=j-1;
            }
            arr[j+1] =temp;
        }
    }
}

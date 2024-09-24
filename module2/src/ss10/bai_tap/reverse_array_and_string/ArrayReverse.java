package ss10.bai_tap.reverse_array_and_string;

import java.util.Scanner;
import java.util.Stack;

public class ArrayReverse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int sizeArray;
        int [] numberArray;
        System.out.println("Enter the size of the array: ");
        Scanner sc = new Scanner(System.in);
        sizeArray =Integer.parseInt(sc.nextLine());
        numberArray = new int[sizeArray];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < sizeArray; i++) {
            System.out.println("Enter the elemnt"+(i+1)+": ");
            numberArray[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.printf("%-20s%s","The fist Array is: ","");
      for (int array : numberArray) {
          System.out.print(array+"\t");
      }
        for (int i = 0; i < sizeArray; i++) {
            stack.push(numberArray[i]);
        }
        for (int i = 0; i < sizeArray; i++) {
            numberArray[i] = stack.pop();
        }
        System.out.printf("%-20s%s", "The reversed array is ", "");
        for (int i = 0; i < sizeArray; i++) {
            System.out.print(numberArray[i]+"\t");
        }
    }
}

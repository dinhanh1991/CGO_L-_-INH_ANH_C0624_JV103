package ss3.bai_tap;

import java.util.Scanner;

public class SumOfColumn {
    public static void main(String[] args) {
        double sum;
        int columns,rows;
        double[][] arrayNumber;
        System.out.println("Enter the number of rows in the array");
        rows = new Scanner(System.in).nextInt();
        System.out.println("Enter the number of columns in the array");
        columns = new Scanner(System.in).nextInt();
        arrayNumber = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println("Enter the value for " + i + "x" + j + ": ");
                arrayNumber[i][j] = new Scanner(System.in).nextDouble();
            }
        }
        System.out.println( "Elements in array: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%1.2f ", arrayNumber[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        sum=0;
        int columnTotal;
        System.out.println("Enter the column which need to find sum: ");
        columnTotal = new Scanner(System.in).nextInt();
        while (columnTotal < 0||columnTotal > columns-1) {
            System.out.println("Enter the column which need to find sum: ");
            columnTotal = new Scanner(System.in).nextInt();
        }
        for (int i = 0; i < rows; i++) {
            sum+= arrayNumber[i][columnTotal];
        }
        System.out.println("The sum of column"+columnTotal+"'s array is: "+sum);
    }
}

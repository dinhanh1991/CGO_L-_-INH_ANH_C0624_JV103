package ss3.bai_tap;

import java.util.Scanner;

public class MaxNumberOfArray2D {
    public static void main(String[] args) {
        double [][] arrayNumber2D;
        int columns,rows ;
        System.out.println("Enter the number of rows in the array");
        rows =new Scanner(System.in).nextInt();
        System.out.println("Enter the number of columns in the array");
        columns =new Scanner(System.in).nextInt();
        arrayNumber2D = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arrayNumber2D[i][j] = Math.random()*50-24;
            }
        }
        for (int i = 0; i < arrayNumber2D.length; i++) {
            for (int j = 0; j < arrayNumber2D[i].length; j++) {
                System.out.printf("%1.2f ", arrayNumber2D[i][j]," ");
            }
            System.out.println();
        }
        double max =arrayNumber2D[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arrayNumber2D[i][j] > max) {
                    max = arrayNumber2D[i][j];
                }
            }
        }
        int count=0;
        String str=" ";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (arrayNumber2D[i][j] == max) {
                    count++;
                    str=str+"row"+ i+" and column " +j;
                }
            }
        }
        System.out.println("The max number is "+max +"There are "+count+" elements in the array in "+str);
    }
}

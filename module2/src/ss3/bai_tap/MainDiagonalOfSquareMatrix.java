package ss3.bai_tap;

import java.util.Scanner;

public class MainDiagonalOfSquareMatrix {
    public static void main(String[] args) {
        double[][] matrix ;
        int columns , rows ;
        double sum=0.00;
        System.out.println("Enter the number of rows in the matrix");
        rows = new Scanner(System.in).nextInt();
        System.out.println("Enter the number of columns in the matrix");
        columns = new Scanner(System.in).nextInt();
        while (rows<0 || columns<0||rows!=columns) {
            System.out.println("Enter the number of rows in the matrix");
            rows = new Scanner(System.in).nextInt();
            System.out.println("Enter the number of columns in the matrix");
            columns = new Scanner(System.in).nextInt();
        }
        matrix = new double[rows][columns];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.println("Enter element"+i+"x"+j+" in matrix");
                matrix[i][j]=(new Scanner(System.in).nextDouble());
            }
        }
        System.out.println("Elements in matrix");
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            sum+=matrix[i][i];
            System.out.println();
        }
        System.out.println("The sum of all the elements in main diagonal of matrix is"+sum);
    }
}

package ss2.bai_tap;

import java.util.Scanner;

public class StarShape {
    public static void main(String[] args) {
        int choice =5;
        Scanner sc = new Scanner(System.in);
        while (choice != 4) {
            System.out.println("Menu");
            System.out.println("1.Print the rectangle");
            System.out.println("2.Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3.Print isosceles triangle");
            System.out.println("4.Exit");
            System.out.println("enter your choice");
            choice = sc.nextInt();

        switch (choice) {
            case 1:
                int height;
                int width;
                System.out.println("Enter height ");
                Scanner rec = new Scanner(System.in);
                height = rec.nextInt();
                System.out.println("Enter width");
                width = rec.nextInt();

                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
                case 2:
                    int height2;
                    System.out.println("Enter height ");
                    Scanner rightTriangle = new Scanner(System.in);
                    height2 = rightTriangle.nextInt();
                    System.out.println("Right triangle bottom_left");
                    for (int i = 0; i < height2; i++) {
                        for (int j = 0; j <i+1; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println("Right triangle top_left");
                    for (int i = 0; i < height2; i++) {
                        for (int j = 0; j <height2-i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println("Right triangle bottom_right");
                    for (int i = 0; i < height2; i++) {
                        for (int j = 0; j <height2; j++) {
                            if (j<height2-1-i) {
                                System.out.print(" ");
                            }else {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Right triangle top_right");
                    for (int i = 0; i < height2; i++) {
                        for (int j = 0; j <height2; j++) {
                            if (i>j) {
                                System.out.print(" ");
                            }else {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }
                    break;
                    case 3:
                        System.out.println("Print isosceles triangle");
                        Scanner isoscelesTriangle = new Scanner(System.in);
                        int heightITriangle;
                        System.out.println("Enter height ");
                        heightITriangle = isoscelesTriangle.nextInt();
                        for (int i = 0; i < heightITriangle; i++) {
                            for (int j = 0; j < 2*heightITriangle-1; j++) {
                                if (j>=heightITriangle-1-i && j<=heightITriangle-1+i) {
                                    System.out.print("*");
                                }else {
                                    System.out.print(" ");
                                }
                            }
                            System.out.println();
                        }
                        break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
}

package case_study.controller;

import case_study.View.SchoolView;

import java.util.Scanner;

public class HighSchoolController {
    private static final SchoolView schoolView = new SchoolView();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showProgram();
    }

    public static void showProgram() {
        int choice;
        do {
            System.out.println("Menu: \n" +
                    "1.Manage Student\n" +
                    "2.Manage Teachers\n" +
                    "3.Manage Classes\n" +
                    "0.Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    schoolView.viewFunctionForStudents();
                    break;
                case 2:
                    schoolView.viewFunctionForTeachers();
                    break;
                case 3:
                    schoolView.viewFunctionForClassrooms();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }
}

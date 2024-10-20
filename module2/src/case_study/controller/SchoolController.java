package case_study.controller;

import case_study.service.ClassroomService;
import case_study.service.StudentService;
import case_study.service.TeacherService;

import java.util.Scanner;

public class SchoolController {
    private static final StudentService studentService = new StudentService();
    private static final TeacherService teacherService = new TeacherService();
    private static final ClassroomService classroomService = new ClassroomService();
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
                    studentService.getFunctionForStudent();
                    break;
                case 2:
                    teacherService.getFunctionForTeachers();
                    break;
                case 3:
                    classroomService.getFunctionForClassroom();
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

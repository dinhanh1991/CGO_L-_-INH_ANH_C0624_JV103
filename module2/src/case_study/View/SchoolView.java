package case_study.View;

import case_study.service.ClassroomService;
import case_study.service.StudentService;
import case_study.service.TeacherService;

import java.util.Scanner;

public class SchoolView {
    private final ClassroomService classroomService=new ClassroomService();
    private final StudentService studentService=new StudentService();
    private final TeacherService teacherService=new TeacherService();
    Scanner scanner=new Scanner(System.in);
    public void viewFunctionForStudents(){
        int choice;
        System.out.println("Enter choice Function of program:\n" +
                "1.Add student.\n" +
                "2.Show all students.\n" +
                "3.Update student in list.\n" +
                "4.Delete student from list.\n" +
                "5.Looking for Student.\n" +
                "6.Show List student follow score of student.");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                studentService.createStudent();
                break;
            case 2:
                studentService.readStudent();
                break;
            case 3:
                studentService.updateStudent();
                break;
            case 4:
                studentService.deleteStudent();
                break;
            case 5:
                studentService.findStudent();
                break;
            case 6:
                studentService.arrangeStudent();
                break;
            default:
                System.out.println("Invalid choice");

                break;
        }
    }
    public void viewFunctionForTeachers(){
        int choice;
        System.out.println("Enter choice Function of program:\n" +
                "1.Add teacher.\n" +
                "2.Show all teacher.\n" +
                "3.Update teacher in list.\n" +
                "4.Delete teacher from list.\n" +
                "5.Looking for teacher.\n");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                teacherService.createTeacher();
                break;
            case 2:
                teacherService.readTeacher();
                break;
            case 3:
               teacherService.editTeacher();
                break;
            case 4:
                teacherService.deleteTeacher();
                break;
            case 5:
                teacherService.findTeacher();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public void viewFunctionForClassrooms(){
        int choice;
        System.out.println("Enter choice Function of program:\n" +
                "1.Add classroom.\n" +
                "2.Show all classrooms.\n" +
                "3.Update classroom in list.\n" +
                "4.Add or remove Student from class.\n" +
                "5.Looking for Class.\n");
        choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                classroomService.createClassroom();
                break;
            case 2:
                classroomService.readClassroom();
                break;
            case 3:
                classroomService.editClassroom();
                break;
            case 4:
                classroomService.changeSizeOfClass();
                break;
            case 5:
                classroomService.findClass();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}

package case_study.controller;

import case_study.model.Student;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    private final String STUDENT_PATH="module2/src/case_study/cvs_file/student";
    private final Scanner scanner=new Scanner(System.in);
    private final StudentService studentService=new StudentService();
    private List<String[]> readFile(String path) {
        List<String[]> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    private void writeFile(String path, List<String[]> data,boolean append) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path,append))) {
            for (String[] str : data) {
                bw.write(String.join(",", str));
                bw.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
   public void createStudent() {
        if (!new File(STUDENT_PATH).exists()) {
            System.out.println("Student file does not exist. Please create a new one.");
            return;
        }
       System.out.println("Enter student id: ");
        String studentId = scanner.nextLine();
        System.out.println("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter student birth date: ");
        String studentBirthDate = scanner.nextLine();
        System.out.println("Enter grade level: ");
        String gradeLevel = scanner.nextLine();
       System.out.println("Enter Score of student: ");
       double score = Double.parseDouble(scanner.nextLine());
       Student student=new Student(studentId,studentName,studentBirthDate,gradeLevel,score);
       String str =student.getInformation().toString();
       List<String[]> data=new ArrayList<>();
       data.add(str.split(","));
       writeFile(STUDENT_PATH,data,true);
       System.out.println("Student created successfully.");
       studentService.readStudent();
   }
   public void readStudent() {
        List<String[]> studentList = readFile(STUDENT_PATH);
       for (String[] str : studentList) {
           System.out.println(str);
       }
   }
   public void editStudent() {
        if (!new File(STUDENT_PATH).exists()) {
            System.out.println("Student file does not exist. Please create a new one.");
            return;
        }
        System.out.println("Enter student id: ");
        String studentId = scanner.nextLine();
        System.out.println("Enter student name who you want to edit: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter student birth date: ");
        String studentBirthDate = scanner.nextLine();
        System.out.println("Enter grade level: ");
        String gradeLevel = scanner.nextLine();
        System.out.println("Enter Score of student: ");
        double score = Double.parseDouble(scanner.nextLine());
       List<String[]> studentList = readFile(STUDENT_PATH);
       boolean isUpdated=false;
       for (String[] data : studentList) {
           if (studentId.equals(data[0])) {
               data[1] = studentName;
               data[2] = studentBirthDate;
               data[3] = gradeLevel;
               data[4] = String.valueOf(score);
              isUpdated=true;
              break;
           }
       }
       if (isUpdated) {
           writeFile(STUDENT_PATH,studentList,false);
           System.out.println("Student updated successfully.");
           studentService.readStudent();
           return;
       }
       System.out.println("Student not found.");
   }
   public void deleteStudent() {
       if (!new File(STUDENT_PATH).exists()) {
           System.out.println("Student file does not exist. Please create a new one.");
           return;
       }
       System.out.println("Enter student id: ");
       String studentId = scanner.nextLine();
       if (!findStudent(studentId)) {
           System.out.println("Student not found.");
           return;
       }
       List<String[]> studentList = readFile(STUDENT_PATH);
       studentList.removeIf(data -> studentId.equals(data[0]));
       writeFile(STUDENT_PATH, studentList, false);
       System.out.println("Student deleted successfully.");
   }
   public boolean findStudent(String studentId) {
        List<String[]> studentList = readFile(STUDENT_PATH);
        for (String[] str : studentList) {
            if (studentId.equals(str[0])) {
                return true;
            }
        }
        return false;
   }
}

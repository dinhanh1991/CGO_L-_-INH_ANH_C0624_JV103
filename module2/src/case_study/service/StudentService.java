package case_study.service;

import case_study.model.Student;

import java.io.*;
import java.util.*;

public class StudentService {
    private final String STUDENT_PATH = "module2/src/case_study/cvs_file/student";
    private final Scanner scanner = new Scanner(System.in);
    private final StudentService studentService = new StudentService();


    public void createStudent() {
        if (!isFileExists()) {
            return;
        }
        System.out.println("Enter student id: ");
        String studentId = scanner.nextLine();
        System.out.println("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter student birth date: ");
        String studentBirthDate = scanner.nextLine();
        System.out.println("Enter Class name: ");
        String className = scanner.nextLine();
        System.out.println("Enter Score of student: ");
        double score = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter student position: ");
        String position = scanner.nextLine();
        System.out.println("Enter Student Email");
        String email = scanner.nextLine();
        System.out.println("Enter Student Phone Number");
        String phoneNumber = scanner.nextLine();
        Student student = new Student(studentId, studentName, studentBirthDate,
                position, email, phoneNumber, className, score);
        String str = student.getInformation();
        List<String[]> data = new ArrayList<>();
        data.add(str.split(","));
        writeFile(STUDENT_PATH, data, true);
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
        if (!isFileExists()) {
            return;
        }
        System.out.println("Enter student id: ");
        String studentId = scanner.nextLine();
        System.out.println("Enter student name who you want to edit: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter student birth date: ");
        String studentBirthDate = scanner.nextLine();
        System.out.println("Enter class name: ");
        String className = scanner.nextLine();
        System.out.println("Enter Score of student: ");
        double score = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter student position: ");
        String position = scanner.nextLine();
        System.out.println("Enter Student Email");
        String email = scanner.nextLine();
        System.out.println("Enter Student Phone Number");
        String phoneNumber = scanner.nextLine();
        List<String[]> studentList = readFile(STUDENT_PATH);
        boolean isEdited = false;
        for (String[] data : studentList) {
            if (studentId.equals(data[0])) {
                data[1] = studentName;
                data[2] = studentBirthDate;
                data[3] = position;
                data[4] = email;
                data[5] = phoneNumber;
                data[6] = className;
                data[7] = String.valueOf(score);
                isEdited = true;
                break;
            }
        }
        if (isEdited) {
            writeFile(STUDENT_PATH, studentList, false);
            System.out.println("Student edited successfully.");
            studentService.readStudent();
            return;
        }
        System.out.println("Student not found.");
    }

    public void deleteStudent() {
        if (!isFileExists()) {
            return;
        }
        System.out.println("Enter student id: ");
        String studentId = scanner.nextLine();
        List<String[]> studentList = readFile(STUDENT_PATH);
        if (studentList.removeIf(data -> studentId.equals(data[0]))) {
            writeFile(STUDENT_PATH, studentList, false);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public List<String[]> arrangeStudent() {
        if (!isFileExists()) {
            return null;
        }
        List<String[]> studentList = readFile(STUDENT_PATH);
        studentList.sort(Comparator.comparingDouble(data -> Double.parseDouble(data[4])));
        for (String[] list : studentList) {
            System.out.println(Arrays.toString(list));
        }
        return studentList;
    }

    public void searchStudent() {
        if (!isFileExists()) {
            return;
        }
        System.out.println("Enter student id: ");
        String studentId = scanner.nextLine();
        List<String[]> studentList = readFile(STUDENT_PATH);
    }

    private boolean isFileExists() {
        if (!new File(STUDENT_PATH).exists()) {
            System.out.println("Student file does not exist. Please create a new one.");
            return false;
        }
        return true;
    }

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

    private void writeFile(String path, List<String[]> data, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            for (String[] str : data) {
                bw.write(String.join(",", str));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package case_study.service;

import case_study.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService {
    private final String TEACHER_PATH = "module2/src/case_study/cvs_file/teachers";
    private final TeacherService teacherService = new TeacherService();
    Scanner scanner = new Scanner(System.in);

    public void createTeacher() {
        if (!isFileExists()) {
            return;
        }
        System.out.println("Enter the id of the teacher: ");
        String teacherId = scanner.nextLine();
        System.out.println("Enter the name of the teacher: ");
        String teacherName = scanner.nextLine();
        System.out.println("Enter the birthdate of the teacher: ");
        String teacherBirthDate = scanner.nextLine();
        System.out.println("Enter the position of the teacher: ");
        String teacherPosition = scanner.nextLine();
        System.out.println("Enter the email of the teacher: ");
        String teacherEmail = scanner.nextLine();
        System.out.println("Enter the phone number of the teacher:");
        String teacherPhone = scanner.nextLine();
        System.out.println("Enter the subject which the teacher teach is:");
        String teacherSubject = scanner.nextLine();
        System.out.println("Enter the name of the class where the teacher manage:");
        String teacherClass = scanner.nextLine();
        Teacher teacher = new Teacher(teacherId, teacherName, teacherBirthDate,
                teacherPosition, teacherEmail, teacherPhone, teacherSubject, teacherClass);
        String data = teacher.getInformation();
        List<String[]> list = new ArrayList<>();
        list.add(data.split(","));
        writeFile(TEACHER_PATH, list, true);
        System.out.println("Student created successfully.");
        teacherService.readTeacher();
    }

    public void readTeacher() {
        List<String[]> teacherList = readFile(TEACHER_PATH);
        for (String[] teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    public void editTeacher() {
        if (!isFileExists()) {
            return;
        }
        System.out.println("Enter the id of the teacher: ");
        String teacherId = scanner.nextLine();
        System.out.println("Enter the name of the teacher: ");
        String teacherName = scanner.nextLine();
        System.out.println("Enter the birthdate of the teacher: ");
        String teacherBirthDate = scanner.nextLine();
        System.out.println("Enter the position of the teacher: ");
        String teacherPosition = scanner.nextLine();
        System.out.println("Enter the email of the teacher: ");
        String teacherEmail = scanner.nextLine();
        System.out.println("Enter the phone number of the teacher:");
        String teacherPhone = scanner.nextLine();
        System.out.println("Enter the subject which the teacher teach is:");
        String teacherSubject = scanner.nextLine();
        System.out.println("Enter the name of the class where the teacher manage:");
        String teacherClass = scanner.nextLine();
        boolean isEdited = false;
        List<String[]> listTeachers = readFile(TEACHER_PATH);
        for (String[] teacher : listTeachers) {
            if (teacherId.equals(teacher[0])) {
                teacher[1] = teacherName;
                teacher[2] = teacherBirthDate;
                teacher[3] = teacherPosition;
                teacher[4] = teacherEmail;
                teacher[5] = teacherPhone;
                teacher[6] = teacherSubject;
                teacher[7] = teacherClass;
                isEdited = true;
                break;
            }
        }
        if (isEdited) {
           writeFile(TEACHER_PATH, listTeachers, false);
            System.out.println("Teacher edited successfully.");
            teacherService.readTeacher();
            return;
        }
        System.out.println("Invalid teacher id.");
    }
    public void deleteTeacher() {
        if (!isFileExists()) {
            return;
        }
        System.out.println("Enter the id of the teacher: ");
        String teacherId = scanner.nextLine();
        List<String[]> listTeachers = readFile(TEACHER_PATH);
        if (listTeachers.removeIf(teacher -> teacherId.equals(teacher[0]))) {
            writeFile(TEACHER_PATH, listTeachers, false);
            System.out.println("Teacher deleted successfully.");
        }else {
            System.out.println("Invalid teacher id.");
        }
    }
    private boolean isFileExists() {
        if (!new File(TEACHER_PATH).exists()) {
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

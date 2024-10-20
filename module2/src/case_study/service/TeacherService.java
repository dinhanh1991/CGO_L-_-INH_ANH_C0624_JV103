package case_study.service;

import case_study.model.Teacher;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TeacherService {
    private final String TEACHER_PATH = "module2/src/case_study/cvs_file/teacher";
    private final Scanner scanner = new Scanner(System.in);

    public void getFunctionForTeachers() {
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
                createTeacher();
                break;
            case 2:
                readTeacher();
                break;
            case 3:
                editTeacher();
                break;
            case 4:
                deleteTeacher();
                break;
            case 5:
                findTeacher();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public void createTeacher() {
        if (!isFileExists(TEACHER_PATH)) {
            return;
        }
        String teacherId = getInput("Enter teacher id: ");
        String teacherName = getInput("Enter teacher name: ");
        String teacherBirthDate = getInput("Enter teacher birth date (dd/MM/yyyy): ");
        while (!isValidDate(teacherBirthDate)) {
            System.out.println("Invalid date format. Please enter again.");
            teacherBirthDate = getInput("Enter teacher birth date (dd/MM/yyyy): ");
        }
        String subject = getInput("Enter subject: ");
        String position = getInput("Enter teacher position: ");
        String email = getInput("Enter Teacher Email: ");
        while (!isValidEmail(email)) {
            System.out.println("Invalid email format. Please enter again.");
            email = getInput("Enter Teacher Email: ");
        }
        String phoneNumber = getInput("Enter Teacher Phone Number: ");
        while (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Invalid phone number format. Please enter again.");
            phoneNumber = getInput("Enter Teacher Phone Number: ");
        }
        String teacherClass = getInput("Enter class name: ");

        Teacher teacher = new Teacher(teacherId, teacherName, teacherBirthDate, position,
                email, phoneNumber, subject, teacherClass);
        String[] tc = teacher.getInformation().split(",");
        List<String[]> data = new ArrayList();
        data.add(tc);
        writeFile(TEACHER_PATH, data, true);
        System.out.println("Teacher created successfully.");
        readTeacher();
    }
    public void readTeacher() {
        List<String[]> teacherList = readFile(TEACHER_PATH);
        for (String[] teacher : teacherList) {
            System.out.println(Arrays.toString(teacher));
        }
    }
    public void editTeacher() {
        if (!isFileExists(TEACHER_PATH)) {
            return;
        }
        String teacherId = getInput("Enter teacher id to edit: ");
        List<String[]> teacherList = readFile(TEACHER_PATH);
        for (String[] teacher : teacherList) {
            if (teacher[0].equals(teacherId)) {
                String teacherName = getInput("Enter new teacher name: ");
                String teacherBirthDate = getInput("Enter new teacher birth date (dd/MM/yyyy): ");
                while (!isValidDate(teacherBirthDate)) {
                    System.out.println("Invalid date format. Please enter again.");
                    teacherBirthDate = getInput("Enter new teacher birth date (dd/MM/yyyy): ");
                }
                String subject = getInput("Enter new subject : ");
                String position = getInput("Enter new position : ");
                String email = getInput("Enter new Teacher Email : ");
                while (!isValidEmail(email)) {
                    System.out.println("Invalid email format. Please enter again.");
                    email = getInput("Enter new Teacher Email : ");
                }
                String phoneNumber = getInput("Enter new Teacher Phone Number  ");
                while (!isValidPhoneNumber(phoneNumber)) {
                    System.out.println("Invalid phone number format. Please enter again.");
                    phoneNumber = getInput("Enter new Teacher Phone Number (leave empty to keep current): ");
                }
                String teacherClass = getInput("Enter new class name ");
                teacher[1] = teacherName;
                teacher[2] = teacherBirthDate;
                teacher[3] = position;
                teacher[4] = email;
                teacher[5] = phoneNumber;
                teacher[6] = subject;
                teacher[7] = teacherClass;

                writeFile(TEACHER_PATH, teacherList, false);
                System.out.println("Teacher updated successfully.");
                return;
            }
        }
        System.out.println("Teacher ID not found.");
    }

    public void deleteTeacher() {
        if (!isFileExists(TEACHER_PATH)) return;
        String teacherId = getInput("Enter teacher id to delete: ");
        List<String[]> teacherList = readFile(TEACHER_PATH);
        boolean found = false;

        for (String[] teacher : teacherList) {
            if (teacher[0].equals(teacherId)) {
                teacherList.remove(teacher);
                found = true;
                break;
            }
        }

        if (found) {
            writeFile(TEACHER_PATH, teacherList, false);
            System.out.println("Teacher deleted successfully.");
        } else {
            System.out.println("Teacher ID not found.");
        }
    }

    public void findTeacher() {
        if (!isFileExists(TEACHER_PATH)) {
            return;
        }
        String teacherId = getInput("Enter teacher id to find: ");
        List<String[]> teacherList = readFile(TEACHER_PATH);
        for (String[] teacher : teacherList) {
            if (teacher[0].equals(teacherId)) {
                System.out.println(Arrays.toString(teacher));
                return;
            }
        }
        System.out.println("Teacher ID not found.");
    }

    private String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    private boolean isFileExists(String path) {
        if (!new File(path).exists()) {
            System.out.println("File does not exist. Please create a new one.");
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

    void writeFile(String path, List<String[]> data, boolean append) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
            for (String[] str : data) {
                bw.write(String.join(",", str));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^0\\d{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    private boolean isValidDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}

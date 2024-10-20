package case_study.service;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ss16.bai_tap.customer_management.Controller.Controller.scanner;

public class ClassroomService {
    private final String CLASSROOM_PATH = "module2/src/case_study/cvs_file/classroom";
    private final String TEACHER_PATH = "module2/src/case_study/cvs_file/teachers";
    private final String STUDENT_PATH = "module2/src/case_study/cvs_file/student";
    private final List<String[]> students = readFile(STUDENT_PATH);
    private final List<String[]> teachers = readFile(TEACHER_PATH);
    private final StudentService studentService = new StudentService();
    private final TeacherService teacherService = new TeacherService();
    private final Scanner sc = new Scanner(System.in);
    public void getFunctionForClassroom() {
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
                createClassroom();
                break;
                case 2:
                    readClassroom();
                    break;
                    case 3:
                        editClassroom();
                        break;
                        case 4:
                            changeSizeOfClass();
                            break;
                            case 5:

                                break;
                                default:
                                    System.out.println("Invalid choice.");
        }
    }
    public void createClassroom() {
        System.out.print("Enter the name of the classroom: ");
        String className = sc.nextLine();
        List<String[]> classroomStudents = filterList(students, 6, className);
        String homeroomTeacher = getTeacherInfo(className);

        if (homeroomTeacher.isEmpty() || classroomStudents.isEmpty()) {
            System.out.println("A class requires both a homeroom teacher and students.");
            return;
        }

        String studentList = getStudentList(classroomStudents);
        String classification = getClassification(classroomStudents);

        saveClassInfo(className, homeroomTeacher, studentList, classification);
        readClassroom();
    }

    public void editClassroom() {
        System.out.println("Enter your choice:\n" +
                "1. Edit student list\n" +
                "2. Edit homeroom teacher");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1) {
            updateStudentInfo();
        } else if (choice == 2) {
            updateTeacherInfo();
        }
        readClassroom();
    }
    public void changeSizeOfClass() {
        System.out.println("Enter your choice: \n" +
                "1: Add Student\n" +
                "2: Remove Student");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            modifyClassSize(true);
        } else if (choice == 2) {
            modifyClassSize(false);
        }
        readClassroom();
    }

    public void readClassroom() {
        List<String[]> classroom = readFile(CLASSROOM_PATH);
        for (String[] classInfo : classroom) {
            System.out.println(String.join(", ", classInfo));
        }
    }

    private void updateStudentInfo() {
        System.out.print("Enter the classroom name to edit: ");
        String className = sc.nextLine();

        List<String[]> studentsInClass = filterList(students, 6, className);

        System.out.print("Enter the ID of the student to edit: ");
        String studentId = sc.nextLine();

        for (String[] student : studentsInClass) {
            if (student[0].equals(studentId)) {
                System.out.print("Enter new student name: ");
                student[1] = sc.nextLine();
                do {
                    System.out.print("Enter birth date (dd/MM/yyyy): ");
                    student[2] = sc.nextLine();
                    if (!isValidDate(student[2])) {
                        System.out.println("Invalid date format or invalid day for the given month. Please enter a valid date.");
                    }
                } while (!isValidDate(student[2]));
                System.out.println("Enter position of student: ");
                student[3] = sc.nextLine();
                do {
                    System.out.println("Enter student email: ");
                    student[4] = sc.nextLine();
                    if (!isValidEmail(student[4])) {
                        System.out.println("Invalid email format. Please enter a valid email.");
                    }
                } while (!isValidEmail(student[4]));
                do {
                    System.out.println("Enter student phone number: ");
                    student[5] = sc.nextLine();
                    if (!isValidPhoneNumber(student[5])) {
                        System.out.println("Invalid phone number. Please enter a valid 10-digit phone number starting with 0.");
                    }
                } while (!isValidPhoneNumber(student[5]));
                System.out.print("Enter score: ");
                student[7] = sc.nextLine();
                break;
            }
        }

        studentService.writeFile(STUDENT_PATH, students, false);
    }

    private void updateTeacherInfo() {
        System.out.print("Enter the class name: ");
        String className = sc.nextLine();
        System.out.print("Enter the ID of the teacher to edit: ");
        String teacherId = sc.nextLine();

        for (String[] teacher : teachers) {
            if (teacher[0].equals(teacherId) && teacher[7].equals(className)) {
                System.out.print("Enter new teacher name: ");
                teacher[1] = sc.nextLine();
                break;
            }
        }

        teacherService.writeFile(TEACHER_PATH, teachers, false);
    }

    private void modifyClassSize(boolean isAdd) {
        System.out.print("Enter class name: ");
        String className = sc.nextLine();
        List<String[]> studentList = readFile(STUDENT_PATH);
        if (isAdd) {
            System.out.print("Enter new student ID: ");
            String id = sc.nextLine();
            System.out.print("Enter new student name: ");
            String name = sc.nextLine();
            String dob;
            do {
                System.out.print("Enter birth date (dd/MM/yyyy): ");
                dob = sc.nextLine();
                if (!isValidDate(dob)) {
                    System.out.println("Invalid date format or invalid day for the given month. " +
                            "Please enter a valid date.");
                }
            } while (!isValidDate(dob));
            System.out.println("Enter student position");
            String position = sc.nextLine();
            String phone;
            do {
                System.out.print("Enter phone number: ");
                phone = sc.nextLine();
                if (!isValidPhoneNumber(phone)) {
                    System.out.println("Invalid phone number. " +
                            "Please enter a valid 10-digit phone number starting with 0.");
                }
            } while (!isValidPhoneNumber(phone));
            String email;
            do {
                System.out.print("Enter email: ");
                email = sc.nextLine();
                if (!isValidEmail(email)) {
                    System.out.println("Invalid email format. Please enter a valid email.");
                }
            } while (!isValidEmail(email));
            System.out.print("Enter score: ");
            String score = sc.nextLine();
            String[] newStudent = {id, name, dob, position, phone, email, className, score};
            studentList.add(newStudent);
        } else {
            System.out.print("Enter student ID to remove: ");
            String id = sc.nextLine();
            studentList.removeIf(student -> student[0].equals(id) && student[6].equals(className));
        }

        studentService.writeFile(STUDENT_PATH, studentList, false);
        updateClassInfo(className);
    }

    private void updateClassInfo(String className) {
        List<String[]> classStudents = filterList(students, 6, className);
        String studentList = getStudentList(classStudents);
        String classification = getClassification(classStudents);

        List<String[]> classroomList = readFile(CLASSROOM_PATH);
        for (String[] classroom : classroomList) {
            if (classroom[0].contains(className)) {
                classroom[2] = "Size: " + classStudents.size();
                classroom[3] = "Classification: " + classification;
                classroom[4] = "List Students: " + studentList;
                break;
            }
        }
        writeFile(CLASSROOM_PATH, classroomList, false);
    }
    private List<String[]> filterList(List<String[]> list, int index, String value) {
        List<String[]> filtered = new ArrayList<>();
        for (String[] item : list) {
            if (item[index].equals(value)) {
                filtered.add(item);
            }
        }
        return filtered;
    }

    private String getTeacherInfo(String className) {
        for (String[] teacher : teachers) {
            if (teacher[7].equals(className)) {
                return String.join("\t", teacher);
            }
        }
        return "";
    }

    private void saveClassInfo(String className, String teacher, String students, String classification) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CLASSROOM_PATH, true))) {
            bw.write("Class Name: " + className + "\n");
            bw.write("Homeroom Teacher: " + teacher + "\n");
            bw.write("Students: \n" + students);
            bw.write("Classification: " + classification + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private int[] rankingStudent(List<String[]> students) {
        int[] ranking = new int[5];
        for (String[] student : students) {
            double score = Double.parseDouble(student[7]);
            if (score >= 8.5) ranking[0]++;
            else if (score >= 8.0) ranking[1]++;
            else if (score >= 6.5) ranking[2]++;
            else if (score >= 5.0) ranking[3]++;
            else ranking[4]++;
        }
        return ranking;
    }

    private String getClassification(List<String[]> students) {
        int[] ranking = rankingStudent(students);
        return "Excellent: " + ranking[0] + ", Good: " + ranking[1] + ", Fair: " + ranking[2] +
                ", Average: " + ranking[3] + ", Weak: " + ranking[4];
    }

    private String getStudentList(List<String[]> students) {
        StringBuilder sb = new StringBuilder();
        for (String[] student : students) {
            sb.append(String.join("\t", student)).append("\n");
        }
        return sb.toString();
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

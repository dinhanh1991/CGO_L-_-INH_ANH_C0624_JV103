package case_study.service;

import case_study.model.Student;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentService {
    private final String STUDENT_PATH = "module2/src/case_study/cvs_file/student";
    private final Scanner scanner = new Scanner(System.in);

    public void getFunctionForStudent() {
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
                createStudent();
                break;
            case 2:
                readStudent();
                break;
            case 3:
                updateStudent();
                break;
            case 4:
                deleteStudent();
                break;
            case 5:
                findStudent();
                break;
            case 6:
                arrangeStudent();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    public void createStudent() {
        if (!isFileExists(STUDENT_PATH)) {
            return;
        }
        String studentId = getInput("Enter student id: ");
        String studentName = getInput("Enter student name: ");
        String studentBirthDate = getInput("Enter student birth date: ");
        while (!isValidDate(studentBirthDate)) {
            studentBirthDate = getInput("Enter student birth date: ");
            if (!isValidDate(studentBirthDate)) {
                System.out.println("Invalid date format or invalid day for the given month. " +
                        "Please enter a valid date.");
            }
        }
        String className = getInput("Enter Class name: ");
        double score = Double.parseDouble(getInput("Enter Score of student: "));
        String position = getInput("Enter student position: ");
        String email;
        do {
            email = getInput("Enter student email: ");
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email.");
            }
        } while (!isValidEmail(email));
        String phoneNumber;
        do {
            phoneNumber = getInput("Enter student phone number: ");
            if (!isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid phone number. " +
                        "Please enter a valid 10-digit phone number starting with 0.");
            }
        } while (!isValidPhoneNumber(phoneNumber));
        Student student = new Student(studentId, studentName, studentBirthDate, position,
                email, phoneNumber, className, score);
        String[] std = student.getInformation().split(",");
        List<String[]> data = new ArrayList();
        data.add(std);
        writeFile(STUDENT_PATH, data, true);
        System.out.println("Student created successfully.");
        readStudent();
    }

    public void readStudent() {
        List<String[]> studentList = readFile(STUDENT_PATH);
        for (String[] str : studentList) {
            System.out.println(Arrays.toString(str));
        }
    }

    public void updateStudent() {
        System.out.print("Enter student ID to update: ");
        String studentId = scanner.nextLine();
        List<String[]> students = readFile(STUDENT_PATH);
        boolean found = false;
        for (String[] student : students) {
            if (student[0].equals(studentId)) {
                System.out.println("Student found: " + Arrays.toString(student));
                String studentName = getInput("Enter new student name (or press Enter to skip): ");
                String studentBirthDate;
                do {
                    studentBirthDate = getInput("Enter new birth date (dd/MM/yyyy) (or press Enter to skip): ");
                    if (!isValidDate(studentBirthDate)) {
                        System.out.println("Invalid date format. Please enter a valid date.");
                    }
                } while (!isValidDate(studentBirthDate));
                String position = getInput("Enter new position (or press Enter to skip): ");
                String email;
                do {
                    email = getInput("Enter new email (or press Enter to skip): ");
                    if (!isValidEmail(email)) {
                        System.out.println("Invalid email format.");
                    }
                } while (!isValidEmail(email));
                String phoneNumber;
                do {
                    phoneNumber = getInput("Enter new phone number (or press Enter to skip): ");
                    if (!isValidPhoneNumber(phoneNumber)) {
                        System.out.println("Invalid phone number.");
                    }
                } while (isValidPhoneNumber(phoneNumber));
                String className = getInput("Enter new class name (or press Enter to skip): ");
                String scoreStr = getInput("Enter new score (or press Enter to skip): ");
                student[1] = studentName;
                student[2] = studentBirthDate;
                student[3] = position;
                student[4] = email;
                student[5] = phoneNumber;
                student[6] = className;
                student[7] = scoreStr;
                found = true;
                break;
            }
        }

        if (found) {
            writeFile(STUDENT_PATH, students, false);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        String studentId = scanner.nextLine();

        List<String[]> students = readFile(STUDENT_PATH);
        boolean removed = students.removeIf(student -> student[0].equals(studentId));

        if (removed) {
            writeFile(STUDENT_PATH, students, false);
            System.out.println("Student with ID " + studentId + " has been deleted.");
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void findStudent() {
        System.out.print("Enter student ID to search: ");
        String studentId = scanner.nextLine();
        List<String[]> students = readFile(STUDENT_PATH);
        boolean found = false;
        for (String[] student : students) {
            if (student[0].equals(studentId)) {
                System.out.println("Student found: " + student);
                double score = Double.parseDouble(student[7]);
                evaluateAcademicPerformance(score);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + studentId + " not found.");
        } else {

        }
    }

    public void arrangeStudent() {
        List<String[]> students = readFile(STUDENT_PATH);
        Collections.sort(students, new Comparator<String[]>() {
            public int compare(String[] o1, String[] o2) {
                double score1 = Double.parseDouble(o1[7]);
                double score2 = Double.parseDouble(o2[7]);
                return Double.compare(score1, score2);
            }
        });
        System.out.println("List arranged: ");
        for (String[] student : students) {
            System.out.println(Arrays.toString(student));
        }
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

    private void evaluateAcademicPerformance(double score) {
        if (score < 0 || score > 10) {
            System.out.println("Score is invalid.check again");
            return;
        }
        if (score > 8.5 && score <= 10) {
            System.out.println("Outstanding and awarded a scholarship of 120% of tuition fees.");
        } else if (score > 8.0) {
            System.out.println("Good and awarded a scholarship of 100% of tuition fees");
        } else if (score > 6.5) {
            System.out.println("Fair and awarded a scholarship of 70% of tuition fees");
        } else if (score > 5.0) {
            System.out.println("Those with average performance need to strive to improve themselves.");
        } else if (score > 4.5) {
            System.out.println("Must retake the exam to improve grades.");
        } else {
            System.out.println("Repeat the grade.");
        }
    }
}

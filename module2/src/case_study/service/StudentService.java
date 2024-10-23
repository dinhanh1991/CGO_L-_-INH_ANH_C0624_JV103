package case_study.service;

import case_study.model.Classroom;
import case_study.model.Student;
import case_study.utils.CvsInputAndOutput;
import case_study.utils.InputData;
import case_study.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    private final String STUDENT_PATH = "module2/src/case_study/cvs_file/student";
    private final String CLASS_PATH = "module2/src/case_study/cvs_file/classroom";
    private final CvsInputAndOutput cvsInputAndOutput = new CvsInputAndOutput();
    private final ValidationUtils validationUtils = new ValidationUtils();
    private final InputData inputData = new InputData();
    private final List<Classroom> classrooms = cvsInputAndOutput.readClassData(CLASS_PATH);
    private final Scanner scanner = new Scanner(System.in);
    public void createStudent() {
        if (!validationUtils.isFileExists(STUDENT_PATH)) {
            return;
        }
        String className = inputData.getInput("Enter Class name: ");
        if (validationUtils.isStudentExisting(className)) {
            System.out.println("Student already exist in Classroom"+className+"/n" +
                    "You need to re-enter the class name.You must update the class list to avoid class data conflicts." +
                    "After existing this interface:\n" +
                    "You select 3 and then 4 to add new student in class");
            return;
        }
        String studentId = inputData.getInput("Enter student id: ");
        String studentName = inputData.getInput("Enter student name: ");
        String studentBirthDate = inputData.getInput("Enter student birth date: ");
        while (!validationUtils.isValidDate(studentBirthDate)) {
            studentBirthDate = inputData.getInput("Enter student birth date: ");
            if (!validationUtils.isValidDate(studentBirthDate)) {
                System.out.println("Invalid date format or invalid day for the given month. " +
                        "Please enter a valid date.");
            }
        }
        double score = Double.parseDouble(inputData.getInput("Enter Score of student: "));
        String position = inputData.getInput("Enter student position: ");
        String email;
        do {
            email = inputData.getInput("Enter student email: ");
            if (!validationUtils.isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email.");
            }
        } while (!validationUtils.isValidEmail(email));
        String phoneNumber;
        do {
            phoneNumber = inputData.getInput("Enter student phone number: ");
            if (!validationUtils.isValidPhoneNumber(phoneNumber)) {
                System.out.println("Invalid phone number. " +
                        "Please enter a valid 10-digit phone number starting with 0.");
            }
        } while (!validationUtils.isValidPhoneNumber(phoneNumber));
        Student student = new Student(studentId, studentName, studentBirthDate, position,
                email, phoneNumber, className, score);
        List<Student> data = new ArrayList<>();
        data.add(student);
        cvsInputAndOutput.writeFileStudent(STUDENT_PATH, data, true);
        System.out.println("Student created successfully.");
        readStudent();
    }

    public void readStudent() {
        List<Student> studentList = cvsInputAndOutput.readFileStudent(STUDENT_PATH);
        for (Student str : studentList) {
            System.out.println(str.getInformation());
        }
    }

    public void updateStudent() {
        System.out.print("Enter student ID to update: ");
        String studentId = scanner.nextLine();
        List<Student> students = cvsInputAndOutput.readFileStudent(STUDENT_PATH);
        boolean found = false;
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                for(Classroom classroom : classrooms) {
                    if (classroom.getNameClass().equals(student.getClassName())) {
                        System.out.println("This student is already assigned as the student list of class:." +classroom.getNameClass()+
                                " If you want to change it, you must update the class list to avoid class data conflicts\n" +
                                "After existing this interface:\n" +
                                "You select 3 and then 3 to add new student in class");
                        return;
                    }
                }
                System.out.println("Student found: " );
                String studentName = inputData.getInput("Enter new student name (or press Enter to skip): ");
                String studentBirthDate;
                do {
                    studentBirthDate = inputData.getInput("Enter new birth date (dd/MM/yyyy) (or press Enter to skip): ");
                    if (!validationUtils.isValidDate(studentBirthDate)) {
                        System.out.println("Invalid date format. Please enter a valid date.");
                    }
                } while (!validationUtils.isValidDate(studentBirthDate));
                String position = inputData.getInput("Enter new position (or press Enter to skip): ");
                String email;
                do {
                    email = inputData.getInput("Enter new email (or press Enter to skip): ");
                    if (!validationUtils.isValidEmail(email)) {
                        System.out.println("Invalid email format.");
                    }
                } while (!validationUtils.isValidEmail(email));
                String phoneNumber;
                do {
                    phoneNumber = inputData.getInput("Enter new phone number (or press Enter to skip): ");
                    if (!validationUtils.isValidPhoneNumber(phoneNumber)) {
                        System.out.println("Invalid phone number.");
                    }
                } while (validationUtils.isValidPhoneNumber(phoneNumber));
                String className = inputData.getInput("Enter new class name (or press Enter to skip): ");
                String scoreStr = inputData.getInput("Enter new score (or press Enter to skip): ");
                student.setId(studentId);
                student.setName(studentName);
                student.setBirthDate(studentBirthDate);
                student.setPosition(position);
                student.setEmail(email);
                student.setPhoneNumber(phoneNumber);
                student.setClassName(className);
                student.setAgvScore(Double.parseDouble(scoreStr));
                found = true;
                break;
            }
        }

        if (found) {
            String confirm="";
            while (!confirm.equals("yes") && !confirm.equals("no")) {
                System.out.println("You must select \"Yes or No\"");
                System.out.println("Select \"Yes or No\"");
                confirm = scanner.nextLine();
            }
            InputData.confirm(confirm, () -> {
                        cvsInputAndOutput.writeFileStudent(STUDENT_PATH, students, false);
                        System.out.println("Student updated successfully.");
                        readStudent();
                    },
                    () -> {
                        System.out.println("You cancelled the update.");
                    });
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        String studentId = scanner.nextLine();

        List<Student> students = cvsInputAndOutput.readFileStudent(STUDENT_PATH);
        boolean removed = students.removeIf(student -> student.getId().equals(studentId));

        if (removed) {
            String confirm="";
            while (!confirm.equals("yes") && !confirm.equals("no")) {
                System.out.println("You must select \"Yes or No\"");
                System.out.println("Select \"Yes or No\"");
                confirm = scanner.nextLine();
            }
            InputData.confirm(confirm, () -> {
                        cvsInputAndOutput.writeFileStudent(STUDENT_PATH, students, false);
                        System.out.println("Student updated successfully.");
                        readStudent();
                    },
                    () -> {
                        System.out.println("You cancelled the delete.");
                    });
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }
    public void findStudent() {
        System.out.print("Enter student ID to search: ");
        String studentId = scanner.nextLine();
        List<Student> students = cvsInputAndOutput.readFileStudent(STUDENT_PATH);
        boolean found = false;
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
                System.out.println("Student found: " + student.toString());
                double score = student.getAgvScore();
                student.evaluateAcademicPerformance(score);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void arrangeStudent() {
        List<Student> students = cvsInputAndOutput.readFileStudent(STUDENT_PATH);
        students.sort(Comparator.comparingDouble(Student::getAgvScore));
        System.out.println("List arranged: ");
        for (Student student : students) {
            System.out.println(student.getInformation());
        }
    }
}

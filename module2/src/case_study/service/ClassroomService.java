package case_study.service;

import case_study.model.Classroom;
import case_study.model.Student;
import case_study.model.Teacher;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClassroomService {
    private final String CLASSROOM_PATH = "module2/src/case_study/cvs_file/classroom";
    private final String TEACHER_PATH = "module2/src/case_study/cvs_file/teachers";
    private final String STUDENT_PATH = "module2/src/case_study/cvs_file/student";
    private final StudentService studentService = new StudentService();
    private final TeacherService teacherService = new TeacherService();
    private final List<Student> students =studentService.readFile(STUDENT_PATH);
    private final List<Teacher> teachers =teacherService.readFile(TEACHER_PATH);
    private final Scanner sc = new Scanner(System.in);
    public void getFunctionForClassroom() {
        int choice;
        System.out.println("Enter choice Function of program:\n" +
                "1.Add classroom.\n" +
                "2.Show all classrooms.\n" +
                "3.Update classroom in list.\n" +
                "4.Add or remove Student from class.\n" +
                "5.Looking for Class.\n");
        choice = Integer.parseInt(sc.nextLine());
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
                                findClass();
                                break;
                                default:
                                    System.out.println("Invalid choice.");
        }
    }
    public void createClassroom() {
        List<Classroom> classrooms = readClassData(CLASSROOM_PATH);
        System.out.print("Enter the name of the classroom: ");
        String className = sc.nextLine();
        for (Classroom classroom : classrooms) {
            if (classroom.getNameClass().equals(className)) {
                System.out.print("The classroom already exists.");
                return;
            }
        }
        List<Student> classroomStudents = filterList(students, className);
        Teacher homeroomTeacher = getTeacherInfo(className);

        if (homeroomTeacher!=null || classroomStudents.isEmpty()) {
            System.out.println("A class requires both a homeroom teacher and students.");
            return;
        }
        classrooms.add(new Classroom(className,homeroomTeacher,classroomStudents));
        writeClassData(CLASSROOM_PATH,classrooms,true);
        readClassroom();
    }

    public void editClassroom() {
        System.out.println("Enter the name of the classroom: ");
        String className = sc.nextLine();
        System.out.println("Enter id of student in the classroom: ");
        String studentId = sc.nextLine();
        System.out.println("Enter the id of teacher in the classroom: ");
        String teacherId = sc.nextLine();
        System.out.println("Enter your choice:\n" +
                "1. Edit student list\n" +
                "2. Edit homeroom teacher");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1) {
            updateStudentInfo();
            List<Student>classStudentList=filterList(students,className);
            List<Classroom> classrooms =readClassData(CLASSROOM_PATH);
            for (Classroom classroom : classrooms) {
                if (classroom.getNameClass().equals(className)) {
                    classroom.setStudents(classStudentList);
                    writeClassData(CLASSROOM_PATH,classrooms,false);
                    System.out.println("Changed Information of Student");
                    break;
                }
            }
        } else if (choice == 2) {
            updateTeacherInfo();
            Teacher homeroomTeacher = getTeacherInfo(className);
            List<Classroom> classrooms =readClassData(CLASSROOM_PATH);
            for (Classroom classroom :classrooms ) {
                if (classroom.getNameClass().equals(className)) {
                    classroom.setTeacher(homeroomTeacher);
                    writeClassData(CLASSROOM_PATH,classrooms,false);
                    System.out.println("Changed Information of teacher");
                }
            }
        }
        readClassroom();
    }
    public void changeSizeOfClass() {
        List<Classroom> classrooms =readClassData(CLASSROOM_PATH);
        System.out.println("Enter your choice: \n" +
                "1: Add Student\n" +
                "2: Remove Student");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            System.out.println("Enter the name of the classroom where you wana add ");
            String className = sc.nextLine();
            System.out.println("Enter Id of student in the classroom: ");
            String studentId = sc.nextLine();
            System.out.println("Enter the name Student in the classroom: ");
            String studentName = sc.nextLine();
            String birthday;
            do {
                System.out.println("Enter Student birthday (dd/MM/yyyy):: ");
                birthday = sc.nextLine();
                if (!isValidDate(birthday)) {
                    System.out.println("Invalid birthday birthday has to follow form :dd/MM/yyyy input again");
                }
            }while (!isValidDate(birthday));
            System.out.println("Enter position of student in the classroom: ");
            String position = sc.nextLine();
            String email;
            do {
                System.out.println("Enter email: ");
                email = sc.nextLine();
                if (!isValidEmail(email)) {
                    System.out.println("Invalid email input again");
                }
            }while (!isValidEmail(email));
            String phoneNumber;
            do {
                System.out.println("Enter phone number. Please enter a valid 10-digit phone number starting with 0.: ");
                phoneNumber = sc.nextLine();
                if (!isValidPhoneNumber(phoneNumber)) {
                    System.out.println("Invalid phone number.Please enter a valid 10-digit phone number starting with 0. input again");
                }
            }while (!isValidPhoneNumber(phoneNumber));
            System.out.println("Enter the score of student in the classroom: ");
            double score = Double.parseDouble(sc.nextLine());
            students.add(new Student(studentId,studentName,birthday,position,email,phoneNumber,className,score));
            studentService.writeFile(STUDENT_PATH,students,false);
            List<Student> studentInClass=filterList(students,className);
            boolean found =false;
            for (Classroom classroom : classrooms) {
                if (classroom.getNameClass().equals(className)) {
                    classroom.setStudents(studentInClass);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid Class please check again");
                return;
            }
        } else if (choice == 2) {
            System.out.println("Enter Class where you wana remove student from classroom: ");
            String className = sc.nextLine();
            System.out.println("Enter Id of student in the classroom: ");
            String studentId = sc.nextLine();
            boolean found =false;
            for (Student student : students) {
                if (student.getId().equals(studentId)&&student.getClassName().equals(className)) {
                    students.remove(student);
                    studentService.writeFile(STUDENT_PATH,students,false);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid Class please check again");
                return;
            }
            List<Student> studentInClass=filterList(students,className);
            for (Classroom classroom : classrooms) {
                if (classroom.getNameClass().equals(className)) {
                    classroom.setStudents(studentInClass);
                    break;
                }
            }
        }
        writeClassData(CLASSROOM_PATH,classrooms,false);
        System.out.println("Changed student List");
        readClassroom();
    }
    public void findClass(){
        System.out.println("Enter name of Class where you ana find information");
        String className = sc.nextLine();
        List<Classroom> classrooms =readClassData(CLASSROOM_PATH);
        for (Classroom classroom : classrooms) {
            if (classroom.getNameClass().equals(className)) {
                System.out.println(classroom.toString());
            }
        }
    }
    public void readClassroom() {
        List<Classroom> classroom = readClassData(CLASSROOM_PATH);
        for (Classroom classInfo : classroom) {
            System.out.println("Class Name: " + classInfo.getNameClass());
            System.out.println("Homeroom Teacher: " + classInfo.getTeacher().getName());
            System.out.println("Size: " + classInfo.getInformSize());
            System.out.println("Classification: " + classInfo.getClassificationInform());
            System.out.println("Students:");
            for (Student student : classInfo.getStudents()) {
                System.out.println(student.toString());
            }
        }
    }
    private void updateStudentInfo() {
        System.out.print("Enter the classroom name to edit: ");
        String className = sc.nextLine();
        System.out.print("Enter the ID of the student to edit: ");
        String studentId = sc.nextLine();
        for (Student student : students) {
            if (student.getId().equals(studentId)&&student.getClassName().equals(className)) {
                System.out.print("Enter new student name: ");
                String nameStudent = sc.nextLine();
                String birthday;
                do {
                    System.out.print("Enter birth date (dd/MM/yyyy): ");
                     birthday = sc.nextLine();
                    if (!isValidDate(birthday)) {
                        System.out.println("Invalid date format or invalid day for the given month. Please enter a valid date.");
                    }
                } while (!isValidDate(birthday));
                System.out.println("Enter position of students");
                String position = sc.nextLine();
               String emailStudent;
                do {
                    System.out.println("Enter student email: ");
                    emailStudent = sc.nextLine();
                    if (!isValidEmail(emailStudent)) {
                        System.out.println("Invalid email format. Please enter a valid email.");
                    }
                } while (!isValidEmail(emailStudent));
                String phoneStudent;
                do {
                    System.out.println("Enter student phone number: ");
                    phoneStudent = sc.nextLine();
                    if (!isValidPhoneNumber(phoneStudent)) {
                        System.out.println("Invalid phone number. Please enter a valid 10-digit phone number starting with 0.");
                    }
                } while (!isValidPhoneNumber(phoneStudent));
                System.out.print("Enter score: ");
                double score = Double.parseDouble(sc.nextLine());
               student.setName(nameStudent);
               student.setBirthDate(birthday);
               student.setPosition(position);
               student.setEmail(emailStudent);
               student.setPhoneNumber(phoneStudent);
               student.setAgvScore(score);
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

        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherId) && teacher.getHomeroomClass().equals(className)) {
                System.out.print("Enter new teacher name: ");
                String nameTeacher = sc.nextLine();
                String birthday;
                do {
                    System.out.print("Enter birth date (dd/MM/yyyy): ");
                    birthday = sc.nextLine();
                    if (!isValidDate(birthday)) {
                        System.out.println("Invalid date format or invalid day for the given month. Please enter a valid date.");
                    }
                } while (!isValidDate(birthday));
                System.out.println("Enter position of teacher");
                String position = sc.nextLine();
                String emailTeacher;
                do {
                    System.out.println("Enter teacher email: ");
                    emailTeacher = sc.nextLine();
                    if (!isValidEmail(emailTeacher)) {
                        System.out.println("Invalid email format. Please enter a valid email.");
                    }
                } while (!isValidEmail(emailTeacher));
                String phoneTeacher;
                do {
                    System.out.println("Enter teacher phone number: ");
                    phoneTeacher = sc.nextLine();
                    if (!isValidEmail(phoneTeacher)) {
                        System.out.println("Invalid email format. Please enter a valid email.");
                    }
                } while (!isValidEmail(phoneTeacher));
                System.out.println("Enter subject");
                String subject = sc.nextLine();
                teacher.setName(nameTeacher);
                teacher.setBirthDate(birthday);
                teacher.setPosition(position);
                teacher.setEmail(emailTeacher);
                teacher.setPhoneNumber(phoneTeacher);
                teacher.setSubject(subject);
                break;
            }
        }

        teacherService.writeFile(TEACHER_PATH, teachers, false);
    }
    private List<Student> filterList(List<Student> list, String value) {
        List<Student> filtered = new ArrayList<>();
        for (Student item : list) {
            if (item.getClassName().equals(value)) {
                filtered.add(item);
            }
        }
        return filtered;
    }

    private Teacher getTeacherInfo(String className) {
        for (Teacher teacher : teachers) {
            if (teacher.getHomeroomClass().equals(className)) {
                return teacher;
            }
        }
        return null;
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
    public List<Classroom> readClassData(String path){
        List<Classroom> classroomList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();
            Classroom currentClassroom = null;
            String className = null;
            Teacher homeroomTeacher = null;
            List<Student> studentList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("Class Name:")) {
                    if (currentClassroom != null) {
                        currentClassroom.setStudents(studentList);
                        classroomList.add(currentClassroom);
                    }
                    className = line.split(":")[1].trim();
                    studentList = new ArrayList<>();
                    currentClassroom = new Classroom(className,homeroomTeacher,studentList);
                }
                else if (line.startsWith("Homeroom Teacher:")) {
                    String[] teacherData = line.split(":")[1].trim().split("\t");
                    homeroomTeacher = new Teacher(
                            teacherData[0], teacherData[1], teacherData[2], teacherData[3],
                            teacherData[4], teacherData[5], teacherData[6], teacherData[7]
                    );
                    if (currentClassroom != null) {
                        currentClassroom.setTeacher(homeroomTeacher);
                    }
                }
                else if (line.startsWith("Size") || line.startsWith("Classification:") || line.startsWith("Students:")) {
                    continue;
                }
                else if (!line.isEmpty()) {
                    String[] studentData = line.split("\t");
                    Student student = new Student(
                            studentData[0], studentData[1], studentData[2], studentData[3],
                            studentData[4], studentData[5], studentData[6], Double.parseDouble(studentData[7])
                    );
                    studentList.add(student);
                }
            }
            if (currentClassroom != null) {
                currentClassroom.setStudents(studentList);
                classroomList.add(currentClassroom);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return classroomList;
    }
    public void writeClassData(String path, List<Classroom> classrooms,boolean append) {
        File file = new File(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            if (!file.exists()||file.length()==0) {
                bw.write("Class name, homeroom teacher,size, classification,student list:...");
                bw.newLine();
            }
            for (Classroom classroom : classrooms) {
                bw.write("Class Name: " + classroom.getNameClass());
                bw.newLine();
                bw.write("Homeroom Teacher: " + classroom.getTeacher());
                bw.newLine();
                bw.write(classroom.getStudents().size() > 0 ? "Size: " + classroom.getStudents().size() : "Size: 0");
                bw.newLine();
                bw.write("Classification: " + classroom.createClassification(classroom.getStudents()));
                bw.newLine();
                bw.write("Students:");
                bw.newLine();
                for (Student student : classroom.getStudents()) {
                    bw.write(String.join("\t",student.getId(),student.getName(),student.getBirthDate()
                            ,student.getPosition(),student.getEmail(),student.getPhoneNumber()
                            ,student.getClassName(),String.valueOf(student.getAgvScore())));
                    bw.newLine();
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

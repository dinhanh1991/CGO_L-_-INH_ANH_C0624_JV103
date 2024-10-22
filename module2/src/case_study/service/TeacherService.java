package case_study.service;

import case_study.model.Classroom;
import case_study.model.Student;
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
    private final String CLASS_PATH="module2/src/case_study/cvs_file/classroom";
    private final String TEACHER_PATH = "module2/src/case_study/cvs_file/teachers";
    private final List<Classroom> classrooms=loadClassroomList(CLASS_PATH);
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
        String teacherBirthDate = "";
        while (!isValidDate(teacherBirthDate)) {
            System.out.println("Invalid date format. Please enter again.");
            teacherBirthDate = getInput("Enter teacher birth date (dd/MM/yyyy): ");
        }
        String position = getInput("Enter teacher position: ");
        String email = "";
        while (!isValidEmail(email)) {
            System.out.println("Invalid email format. Please enter again.");
            email = getInput("Enter Teacher Email: ");
        }
        String phoneNumber="";
        while (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Invalid phone number format. Please enter again.");
            phoneNumber = getInput("Enter Teacher Phone Number: ");
        }
        String subject = getInput("Enter subject: ");
        String teacherClass ;
        do {
            teacherClass= getInput("Enter class name: ");
            if (isHomeroomExisting(teacherClass)){
                System.out.println("Each class can only have one homeroom teacher. \n" +
                        "You need to re-enter the class name. \n" +
                        "If you are not the homeroom teacher of any class, leave it blank");
            }
        }while (isHomeroomExisting(teacherClass));
        Teacher teacher = new Teacher(teacherId, teacherName, teacherBirthDate, position,email, phoneNumber, subject, teacherClass);
        List<Teacher> data = new ArrayList();
        data.add(teacher);
        writeFile(TEACHER_PATH, data, true);
        System.out.println("Teacher created successfully.");
        readTeacher();
    }
    public void readTeacher() {
        List<Teacher> teacherList = readFile(TEACHER_PATH);
        for (Teacher teacher : teacherList) {
            System.out.println(teacher.getInformation());
        }
    }
    public void editTeacher() {
        if (!isFileExists(TEACHER_PATH)) {
            return;
        }
        String teacherId = getInput("Enter teacher id to edit: ");
        List<Teacher> teacherList = readFile(TEACHER_PATH);
        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(teacherId)) {
                for (Classroom classroom : classrooms) {
                    if (classroom.getTeacher().getId().equals(teacherId)) {
                        System.out.println("This teacher is already assigned as the homeroom teacher of class:." +classroom.getNameClass()+
                                " If you want to change it, you must update the class list to avoid data conflicts");
                        return;
                    }
                }
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
                teacher.setName(teacherName);
                teacher.setBirthDate(teacherBirthDate);
                teacher.setPosition(position);
                teacher.setEmail(email);
                teacher.setPhoneNumber(phoneNumber);
                teacher.setSubject(subject);
                teacher.setPosition(teacherClass);
                writeFile(TEACHER_PATH, teacherList, false);
                System.out.println("Teacher updated successfully.");
                readTeacher();
                return;
            }
        }
        System.out.println("Teacher ID not found.");
    }

    public void deleteTeacher() {
        if (!isFileExists(TEACHER_PATH)) return;
        String teacherId = getInput("Enter teacher id to delete: ");
        List<Teacher> teacherList = readFile(TEACHER_PATH);
        boolean found = false;

        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(teacherId)) {
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
        List<Teacher> teacherList = readFile(TEACHER_PATH);
        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(teacherId)) {
                System.out.println(teacher.getInformation());
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

    public List<Teacher> readFile(String path) {
        List<Teacher> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.trim().split(",");
                list.add(new Teacher(data[0],data[1],data[2],data[3],data[4],data[5],data[6],data[7]));
            }
        } catch (IOException e) {
            System.out.println("Read file error."+e.getMessage());
        }
        return list;
    }

    public void writeFile(String path, List<Teacher> data, boolean append) {
        File file =new File(path);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, append))) {
            if (!file.exists()||file.length()==0){
                bw.write("Id,Name,Birthday,position,email,phone number,Subject,Homeroom Class");
                bw.newLine();
            }
            for (Teacher str : data) {
                bw.write(str.getInformation());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Write file error."+e.getMessage());
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
    private boolean isHomeroomExisting(String className){
        List<Teacher> teacherList = readFile(TEACHER_PATH);
        for (Teacher teacher : teacherList) {
            if (teacher.getClass().equals(className)) {
                return true;
            }
        }
        return false;
    }
    private List<Classroom> loadClassroomList(String path) {
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
}

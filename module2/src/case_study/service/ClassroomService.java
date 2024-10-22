package case_study.service;

import case_study.model.Classroom;
import case_study.model.Student;
import case_study.model.Teacher;
import case_study.utils.CvsInputAndOutput;
import case_study.utils.InputData;
import case_study.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClassroomService {
    private final String CLASSROOM_PATH = "module2/src/case_study/cvs_file/classroom";
    private final String TEACHER_PATH = "module2/src/case_study/cvs_file/teachers";
    private final String STUDENT_PATH = "module2/src/case_study/cvs_file/student";
    private final CvsInputAndOutput cvsInputAndOutput = new CvsInputAndOutput();
    private final ValidationUtils validationUtils = new ValidationUtils();
    private final InputData inputData = new InputData();
    private final List<Student> students = cvsInputAndOutput.readFileStudent(STUDENT_PATH);
    private final List<Teacher> teachers = cvsInputAndOutput.readFilTeacher(TEACHER_PATH);

    private final Scanner sc = new Scanner(System.in);
    public void createClassroom() {
        List<Classroom> classrooms = cvsInputAndOutput.readClassData(CLASSROOM_PATH);
        String className = inputData.getInput("Enter class name: ");
        for (Classroom classroom : classrooms) {
            if (classroom.getNameClass().equals(className)) {
                System.out.print("The classroom already exists.");
                return;
            }
        }
        List<Student> classroomStudents = filterList(students, className);
        Teacher homeroomTeacher = getTeacherInfo(className);

        if (homeroomTeacher==null || classroomStudents.isEmpty()) {
            System.out.println("A class requires both a homeroom teacher and students.");
            return;
        }
        classrooms.add(new Classroom(className,homeroomTeacher,classroomStudents));
        cvsInputAndOutput.writeClassData(CLASSROOM_PATH, classrooms, true);
        readClassroom();
    }

    public void editClassroom() {
        System.out.println("Enter the name of the classroom: ");
        String className = sc.nextLine();
        System.out.println("Enter your choice:\n" +
                "1. Edit student list\n" +
                "2. Edit homeroom teacher");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1) {
            updateStudentInfo();
            List<Student>classStudentList=filterList(students,className);
            List<Classroom> classrooms = cvsInputAndOutput.readClassData(CLASSROOM_PATH);
            for (Classroom classroom : classrooms) {
                if (classroom.getNameClass().equals(className)) {
                    classroom.setStudents(classStudentList);
                    cvsInputAndOutput.writeClassData(CLASSROOM_PATH, classrooms, false);
                    System.out.println("Changed Information of Student");
                    break;
                }
            }
        } else if (choice == 2) {
            updateTeacherInfo();
            Teacher homeroomTeacher = getTeacherInfo(className);
            List<Classroom> classrooms = cvsInputAndOutput.readClassData(CLASSROOM_PATH);
            for (Classroom classroom :classrooms ) {
                if (classroom.getNameClass().equals(className)) {
                    classroom.setTeacher(homeroomTeacher);
                    cvsInputAndOutput.writeClassData(CLASSROOM_PATH, classrooms, false);
                    System.out.println("Changed Information of teacher");
                }
            }
        }
        readClassroom();
    }
    public void changeSizeOfClass() {
        List<Classroom> classrooms = cvsInputAndOutput.readClassData(CLASSROOM_PATH);
        System.out.println("Enter your choice: \n" +
                "1: Add Student\n" +
                "2: Remove Student");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            String className = inputData.getInput("Enter the name of the classroom where you wana add ");
            String studentId = inputData.getInput("Enter Id of student in the classroom: ");
            String studentName = inputData.getInput("Enter Name Student in the classroom: ");
            String birthday;
            do {
                birthday = inputData.getInput("Enter Student birthday (dd/MM/yyyy):");
                if (!validationUtils.isValidDate(birthday)) {
                    System.out.println("Invalid birthday birthday has to follow form :dd/MM/yyyy input again");
                }
            } while (!validationUtils.isValidDate(birthday));
            String position = inputData.getInput("Enter position of student in the classroom: ");
            String email;
            do {
                email = inputData.getInput("Enter email address: ");
                if (!validationUtils.isValidEmail(email)) {
                    System.out.println("Invalid email input again");
                }
            } while (!validationUtils.isValidEmail(email));
            String phoneNumber;
            do {
                phoneNumber = inputData.getInput("Enter phone number. Please enter a valid 10-digit phone number starting with 0.: ");
                if (!validationUtils.isValidPhoneNumber(phoneNumber)) {
                    System.out.println("Invalid phone number.Please enter a valid 10-digit phone number starting with 0. input again");
                }
            } while (!validationUtils.isValidPhoneNumber(phoneNumber));
            double score = Double.parseDouble(inputData.getInput("Enter score of student in the classroom: "));
            students.add(new Student(studentId,studentName,birthday,position,email,phoneNumber,className,score));
            cvsInputAndOutput.writeFileStudent(STUDENT_PATH, students, false);
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
            String className = inputData.getInput("Enter Class where you wana remove student from classroom: ");
            String studentId = inputData.getInput("Enter Id of student in the classroom: ");
            boolean found =false;
            for (Student student : students) {
                if (student.getId().equals(studentId)&&student.getClassName().equals(className)) {
                    students.remove(student);
                    cvsInputAndOutput.writeFileStudent(STUDENT_PATH, students, false);
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
        cvsInputAndOutput.writeClassData(CLASSROOM_PATH, classrooms, false);
        System.out.println("Changed student List");
        readClassroom();
    }
    public void findClass(){
        String className = inputData.getInput("Enter Class where you wana find information: ");
        List<Classroom> classrooms = cvsInputAndOutput.readClassData(CLASSROOM_PATH);
        for (Classroom classroom : classrooms) {
            if (classroom.getNameClass().equals(className)) {
                System.out.println(classroom.toString());
            }
        }
    }
    public void readClassroom() {
        List<Classroom> classroom = cvsInputAndOutput.readClassData(CLASSROOM_PATH);
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
        String className = inputData.getInput("Enter the classroom name to edit: ");
        String studentId = inputData.getInput("Enter the ID of the student to edit: ");
        for (Student student : students) {
            if (student.getId().equals(studentId)&&student.getClassName().equals(className)) {
                String nameStudent = inputData.getInput("Enter new student name: ");
                String birthday;
                do {
                    birthday = inputData.getInput("Enter birth date (dd/MM/yyyy): ");
                    if (!validationUtils.isValidDate(birthday)) {
                        System.out.println("Invalid date format or invalid day for the given month. Please enter a valid date.");
                    }
                } while (!validationUtils.isValidDate(birthday));
                String position = inputData.getInput("Enter position of student in the classroom: ");
               String emailStudent;
                do {
                    System.out.println("Enter student email: ");
                    emailStudent = inputData.getInput("Enter student email address: ");
                    if (!validationUtils.isValidEmail(emailStudent)) {
                        System.out.println("Invalid email format. Please enter a valid email.");
                    }
                } while (!validationUtils.isValidEmail(emailStudent));
                String phoneStudent;
                do {
                    System.out.println("Enter student phone number: ");
                    phoneStudent = inputData.getInput("Enter student phone number." +
                            "Please enter a valid 10-digit phone number starting with 0.: ");
                    if (!validationUtils.isValidPhoneNumber(phoneStudent)) {
                        System.out.println("Invalid phone number. Please enter a valid 10-digit phone number starting with 0.");
                    }
                } while (!validationUtils.isValidPhoneNumber(phoneStudent));
                double score = Double.parseDouble(inputData.getInput("Enter score of student in the classroom: "));
               student.setName(nameStudent);
               student.setBirthDate(birthday);
               student.setPosition(position);
               student.setEmail(emailStudent);
               student.setPhoneNumber(phoneStudent);
               student.setAgvScore(score);
                break;
            }
        }
        cvsInputAndOutput.writeFileStudent(STUDENT_PATH, students, false);
    }
    private void updateTeacherInfo() {
        String className = inputData.getInput("Enter the class name to edit: ");
        String teacherId = inputData.getInput("Enter the ID of the teacher to edit: ");
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(teacherId) && teacher.getHomeroomClass().equals(className)) {
                String nameTeacher = inputData.getInput("Enter new teacher name: ");
                String birthday;
                do {
                    birthday = inputData.getInput("Enter birth date (dd/MM/yyyy): ");
                    if (!validationUtils.isValidDate(birthday)) {
                        System.out.println("Invalid date format or invalid day for the given month. " +
                                "Please enter a valid date.");
                    }
                } while (!validationUtils.isValidDate(birthday));
                String position = inputData.getInput("Enter position of teacher: ");
                String emailTeacher;
                do {
                    emailTeacher = inputData.getInput("Enter teacher email address: ");
                    if (!validationUtils.isValidEmail(emailTeacher)) {
                        System.out.println("Invalid email format. Please enter a valid email.");
                    }
                } while (!validationUtils.isValidEmail(emailTeacher));
                String phoneTeacher;
                do {
                    System.out.println("Enter teacher phone number: ");
                    phoneTeacher = inputData.getInput("Enter teacher phone number.Please enter a valid 10-digit phone number starting with 0.: ");
                    if (!validationUtils.isValidPhoneNumber(phoneTeacher)) {
                        System.out.println("Invalid email format. Please enter a valid email.Please enter a valid 10-digit phone number starting with 0.: ");
                    }
                } while (!validationUtils.isValidPhoneNumber(phoneTeacher));
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

        cvsInputAndOutput.writeFileTeacher(TEACHER_PATH, teachers, false);
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
}
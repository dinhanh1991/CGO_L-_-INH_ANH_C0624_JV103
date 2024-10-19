package case_study.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ss16.bai_tap.customer_management.Controller.Controller.scanner;

public class ClassroomService {
    private final String CLASSROOM_PATH = "module2/src/case_study/cvs_file/classroom";
    private final String TEACHER_PATH = "module2/src/case_study/cvs_file/teachers";
    private final String STUDENT_PATH = "module2/src/case_study/cvs_file/student";
    private final List<String[]> students = readFile(STUDENT_PATH);
    private final List<String[]> teachers = readFile(TEACHER_PATH);
    private final StudentService studentService = new StudentService();
    private final TeacherService teacherService = new TeacherService();
    Scanner sc = new Scanner(System.in);

    public void createClassroom() {
        System.out.println("Enter the name of the classroom: ");
        String className = sc.nextLine();
        List<String[]> classroomStudent = new ArrayList<>();
        for (String[] student : students) {
            if (student[6].equals(className)) {
                classroomStudent.add(student);
            }
        }
        String informTeacher = "";
        boolean flag = false;
        for (String[] teacher : teachers) {
            if (teacher[7].equals(className)) {
                for (int i = 0; i < teacher.length; i++) {
                    informTeacher += teacher[i] + "\t";
                }
                flag = true;
                break;
            }
        }
        if (!flag && classroomStudent.size() < 1) {
            System.out.println("To create a class, a homeroom teacher and students are required.");
            return;
        } else if (!flag) {
            System.out.println("A class needs a homeroom teacher.");
            return;
        } else if (classroomStudent.size() == 0) {
            System.out.println("Class need add Students to classroom.");
            return;
        }
        int[] ranking = RankingStudent(classroomStudent);
        String informRanking = "Excellent: " + ranking[0] + ", good: " + ranking[1] + ", Fair: " + ranking[2]
                + ", Average: " + ranking[3] + ", Weak: " + ranking[4];
        StringBuilder sb = new StringBuilder();
        for (String[] student : classroomStudent) {
            for (String element : student) {
                sb.append(element).append("\t");
            }
            sb.append("\n");
        }
        String listStudents = sb.toString();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CLASSROOM_PATH, true))) {
            bw.write("Class Name :" + className + ",\n" +
                    "Homeroom teacher :" + informTeacher + ",\"" +
                    " Size : " + listStudents.length() + ",\n" +
                    "Classification: " + informRanking + "\n" +
                    "List Students: " + listStudents);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readClassroom() {
        List<String[]> classroom = readFile(CLASSROOM_PATH);
        for (String[] classInform : classroom) {
            System.out.println(classInform);
        }
    }

    public void editClassroom() {
        List<String[]> classroomStudent = readFile(STUDENT_PATH);
        System.out.println("Enter your choice: \n" +
                "1: Edit homeroom teacher information.\n" +
                "2. Edit student list information.");
        int choice = Integer.parseInt(sc.nextLine());
        if (choice == 1) {
            System.out.println("Enter the name of the classroom which you want to edit: ");
            String name = sc.nextLine();
            String className = sc.nextLine();
            List<String[]> listStudents = readFile(STUDENT_PATH);
            System.out.println("Enter id Student who you want to edit: ");
            String idStudent = sc.nextLine();
            for (String[] student : listStudents) {
                if (student[0].equals(idStudent)&&student[6].equals(className)) {
                    System.out.println("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.println("Enter student birth date: ");
                    String studentBirthDate = scanner.nextLine();
                    System.out.println("Enter Score of student: ");
                    double score = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter student position: ");
                    String position = scanner.nextLine();
                    System.out.println("Enter Student Email");
                    String email = scanner.nextLine();
                    System.out.println("Enter Student Phone Number");
                    String phoneNumber = scanner.nextLine();
                    student[1] = studentName;
                    student[2] = studentBirthDate;
                    student[3] = position;
                    student[4] = email;
                    student[5] = phoneNumber;
                    student[7] = String.valueOf(score);
                }
            }
            StringBuilder sb = new StringBuilder();
            List<String[]> listClass = readFile(CLASSROOM_PATH);
            for (String[] classroom : listClass) {
                if (classroom[0].equals("Class Name :" + className + ",")) {
                    for (String[] student : classroomStudent) {
                        for (String element : student) {
                            sb.append(element).append("\t");
                        }
                        sb.append("\n");
                    }
                    String list = sb.toString();
                    classroom[5] = "List Students: " + list;
                    break;
                }
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(CLASSROOM_PATH))) {
                for (String[] classroom : listClass) {
                    bw.write("Class Name :" + classroom[0] + ",\n" +
                            "Homeroom teacher :" + classroom[1] + ",\"" +
                            " Size : " + classroomStudent.size() + ",\n" +
                            "Classification: " + classroom[3] + "\n" +
                            "List Students: " + classroom[5]);
                    bw.newLine();
                    System.out.println("Edit Success");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (choice == 2) {
            System.out.println("Enter Name of class which you want to edit: ");
            String name = sc.nextLine();

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

    public int[] RankingStudent(List<String[]> students) {
        int excellentRanking = 0;
        int goodRanking = 0;
        int fairRanking = 0;
        int averageRanking = 0;
        int badRanking = 0;
        for (String[] student : students) {
            if (Double.parseDouble(student[7]) >= 8.5) {
                excellentRanking++;
            } else if (Double.parseDouble(student[7]) >= 8.0) {
                goodRanking++;
            } else if (Double.parseDouble(student[7]) >= 6.5) {
                fairRanking++;
            } else if (Double.parseDouble(student[7]) >= 5.0) {
                averageRanking++;
            } else {
                badRanking++;
            }
        }
        int[] ranking = {excellentRanking, goodRanking, fairRanking, averageRanking, badRanking};
        return ranking;
    }

    public String getStudentList(List<String[]> students) {
        String list = "";
        for (String[] student : students) {
            list += String.join(",", student[0], student[1],
                    student[2], student[3], student[4], student[5], student[6], student[7]) + "\n";
        }
        return list;
    }
}

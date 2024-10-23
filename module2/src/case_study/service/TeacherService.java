package case_study.service;

import case_study.model.Classroom;
import case_study.model.Teacher;
import case_study.utils.CvsInputAndOutput;
import case_study.utils.InputData;
import case_study.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TeacherService {
    private final String CLASS_PATH="module2/src/case_study/cvs_file/classroom";
    private final String TEACHER_PATH = "module2/src/case_study/cvs_file/teachers";
    private final CvsInputAndOutput cvsInputAndOutput = new CvsInputAndOutput();
    private final ValidationUtils validationUtils = new ValidationUtils();
    private final InputData inputData = new InputData();
    private final List<Classroom> classrooms = cvsInputAndOutput.readClassData(CLASS_PATH);
    private final Scanner scanner = new Scanner(System.in);

    public void createTeacher() {
        if (!validationUtils.isFileExists(TEACHER_PATH)) {
            return;
        }
        String teacherId = inputData.getInput("Enter teacher id: ");
        String teacherName = inputData.getInput("Enter teacher name: ");
        String teacherBirthDate = "";
        while (!validationUtils.isValidDate(teacherBirthDate)) {
            System.out.println("Invalid date format. Please enter again.");
            teacherBirthDate = inputData.getInput("Enter teacher birth date (dd/MM/yyyy): ");
        }
        String position = inputData.getInput("Enter teacher position: ");
        String email = "";
        while (!validationUtils.isValidEmail(email)) {
            System.out.println("Invalid email format. Please enter again.");
            email = inputData.getInput("Enter Teacher Email: ");
        }
        String phoneNumber="";
        while (!validationUtils.isValidPhoneNumber(phoneNumber)) {
            System.out.println("Invalid phone number format. Please enter again.");
            phoneNumber = inputData.getInput("Enter Teacher Phone Number: ");
        }
        String subject = inputData.getInput("Enter subject: ");
        String teacherClass ;
        do {
            teacherClass = inputData.getInput("Enter class name: ");
            if (validationUtils.isHomeroomExisting(teacherClass)) {
                System.out.println("Each class can only have one homeroom teacher. \n" +
                        "You need to re-enter the class name. \n" +
                        "If you are not the homeroom teacher of any class, leave it blank");
            }
        } while (validationUtils.isHomeroomExisting(teacherClass));
        Teacher teacher = new Teacher(teacherId, teacherName, teacherBirthDate, position,email, phoneNumber, subject, teacherClass);
        List<Teacher> data = new ArrayList<>();
        data.add(teacher);
        cvsInputAndOutput.writeFileTeacher(TEACHER_PATH, data, true);
        System.out.println("Teacher created successfully.");
        readTeacher();
    }
    public void readTeacher() {
        List<Teacher> teacherList = cvsInputAndOutput.readFilTeacher(TEACHER_PATH);
        for (Teacher teacher : teacherList) {
            System.out.println(teacher.getInformation());
        }
    }
    public void editTeacher() {
        if (!validationUtils.isFileExists(TEACHER_PATH)) {
            return;
        }
        String teacherId = inputData.getInput("Enter teacher id to edit: ");
        List<Teacher> teacherList = cvsInputAndOutput.readFilTeacher(TEACHER_PATH);
        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(teacherId)) {
                for (Classroom classroom : classrooms) {
                    if (classroom.getTeacher().getId().equals(teacherId)) {
                        System.out.println("This teacher is already assigned as the homeroom teacher of class:." +classroom.getNameClass()+
                                " If you want to change it, you must update the class list to avoid class data conflicts");
                        return;
                    }
                }
                String teacherName = inputData.getInput("Enter new teacher name: ");
                String teacherBirthDate = inputData.getInput("Enter new teacher birth date (dd/MM/yyyy): ");
                while (!validationUtils.isValidDate(teacherBirthDate)) {
                    System.out.println("Invalid date format. Please enter again.");
                    teacherBirthDate = inputData.getInput("Enter new teacher birth date (dd/MM/yyyy): ");
                }
                String subject = inputData.getInput("Enter new subject : ");
                String position = inputData.getInput("Enter new position : ");
                String email = inputData.getInput("Enter new Teacher Email : ");
                while (!validationUtils.isValidEmail(email)) {
                    System.out.println("Invalid email format. Please enter again.");
                    email = inputData.getInput("Enter new Teacher Email : ");
                }
                String phoneNumber = inputData.getInput("Enter new Teacher Phone Number  ");
                while (!validationUtils.isValidPhoneNumber(phoneNumber)) {
                    System.out.println("Invalid phone number format. Please enter again.");
                    phoneNumber = inputData.getInput("Enter new Teacher Phone Number (leave empty to keep current): ");
                }
                String teacherClass = inputData.getInput("Enter new class name ");
                teacher.setName(teacherName);
                teacher.setBirthDate(teacherBirthDate);
                teacher.setPosition(position);
                teacher.setEmail(email);
                teacher.setPhoneNumber(phoneNumber);
                teacher.setSubject(subject);
                teacher.setPosition(teacherClass);
                System.out.println("Are you sure:\n" +
                        "\"yes to countinues\"\n\"No\" to cancel");
                String confirm = "";
                while (!confirm.equals("yes") && !confirm.equals("no")) {
                    System.out.println("You must select \"Yes or No\"");
                    System.out.println("Select \"Yes or No\"");
                    confirm = scanner.nextLine();
                }
                InputData.confirm(confirm, () -> {
                    cvsInputAndOutput.writeFileTeacher(TEACHER_PATH, teacherList, false);
                    System.out.println("Teacher updated successfully.");
                    readTeacher();
                }, () -> {
                    System.out.println("Teacher not updated successfully.");
                    readTeacher();
                });
            }
        }
        System.out.println("Teacher ID not found.");
    }

    public void deleteTeacher() {
        if (!validationUtils.isFileExists(TEACHER_PATH)) return;
        String teacherId = inputData.getInput("Enter teacher id to delete: ");
        List<Teacher> teacherList = cvsInputAndOutput.readFilTeacher(TEACHER_PATH);
        boolean found = false;

        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(teacherId)) {
                teacherList.remove(teacher);
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
                cvsInputAndOutput.writeFileTeacher(TEACHER_PATH, teacherList, false);
                System.out.println("Teacher updated successfully.");
                readTeacher();
            }, () -> {
                System.out.println("Teacher not updated successfully.");
                readTeacher();
            });
        } else {
            System.out.println("Teacher ID not found.");
        }
    }

    public  void  findTeacher() {
        if (!validationUtils.isFileExists(TEACHER_PATH)) {
            return;
        }
        String teacherId = inputData.getInput("Enter teacher id to find: ");
        List<Teacher> teacherList = cvsInputAndOutput.readFilTeacher(TEACHER_PATH);
        for (Teacher teacher : teacherList) {
            if (teacher.getId().equals(teacherId)) {
                System.out.println(teacher.getInformation());
                return;
            }
        }
        System.out.println("Teacher ID not found.");
    }
}

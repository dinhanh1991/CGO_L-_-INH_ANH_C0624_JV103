package case_study.utils;

import case_study.model.Student;
import case_study.model.Teacher;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
    private final CvsInputAndOutput cvsInputAndOutput = new CvsInputAndOutput();
    private final String TEACHER_PATH = "module2/src/case_study/cvs_file/teachers";
    private final String STUDENT_PATH = "module2/src/case_study/cvs_file/student";
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^0\\d{9}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public boolean isValidDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean isFileExists(String path) {
        if (!new File(path).exists()) {
            System.out.println("File does not exist. Please create a new one.");
            return false;
        }
        return true;
    }
    public boolean isHomeroomExisting(String className){
        List<Teacher> teacherList = cvsInputAndOutput.readFilTeacher(TEACHER_PATH);
        for (Teacher teacher : teacherList) {
            if (teacher.getClass().equals(className)) {
                return true;
            }
        }
        return false;
    }
    public boolean isStudentExisting(String className){
        List<Student> studentsList = cvsInputAndOutput.readFileStudent(STUDENT_PATH);
        for (Student student : studentsList) {
            if (student.getClass().equals(className)) {
                return true;
            }
        }
        return false;
    }
}

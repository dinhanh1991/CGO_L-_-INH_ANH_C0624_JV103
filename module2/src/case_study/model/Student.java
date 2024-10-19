package case_study.model;

public class Student extends Person {
    private final String className;
    private final double agvScore;
    public Student(String id, String name, String birthDate, String position, String email,
                   String phoneNumber, String className, double agvScore) {
        super(id, name, birthDate, position, email, phoneNumber);
        this.className = className;
        this.agvScore = agvScore;
    }

    public String getInformation() {
        return getId() + "," + getName() + "," + getBirthDate() +
                "," + getPosition() + "," + getEmail() + "," + getPhoneNumber() + "," +
                className + "," + agvScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "gradeLevel='" + className + '\'' +
                ", agvScore=" + agvScore +
                "} " + super.toString();
    }
}

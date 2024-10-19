package case_study.model;

public class Teacher extends Person {
    private final String subject;
    private final String homeroomClass;

    public Teacher(String id, String name, String birthDate, String position,
                   String email, String phoneNumber, String subject, String homeroomClass) {
        super(id, name, birthDate, position, email, phoneNumber);
        this.subject = subject;
        this.homeroomClass = homeroomClass;
    }

    public String getInformation() {
        return getId() + "," + getName() + "," + getBirthDate() + "," + getPosition() + ","
                + "," + getEmail() + "," + getPhoneNumber() + "," + subject + "," + homeroomClass;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                ", homeroomClass='" + homeroomClass + '\'' +
                "} " + super.toString();
    }
}


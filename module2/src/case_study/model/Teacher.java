package case_study.model;

public class Teacher extends Person {
    private  String subject;
    private  String homeroomClass;

    public Teacher(String id, String name, String birthDate, String position,
                   String email, String phoneNumber, String subject, String homeroomClass) {
        super(id, name, birthDate, position, email, phoneNumber);
        this.subject = subject;
        this.homeroomClass = homeroomClass;
    }

    public String getSubject() {
        return subject;
    }

    public String getHomeroomClass() {
        return homeroomClass;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setHomeroomClass(String homeroomClass) {
        this.homeroomClass = homeroomClass;
    }

    public String getInformation() {
        return getId() + "," + getName() + "," + getBirthDate() + "," + getPosition() + ","
                 + getEmail() + "," + getPhoneNumber() + "," + subject + "," + homeroomClass;
    }

    @Override
    public String toString() {
        return   super.toString()+"\t"+subject + "\t" + homeroomClass ;
    }
}


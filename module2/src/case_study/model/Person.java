package case_study.model;

public abstract class Person {
    private String id;
    private String name;
    private String birthDate;
    private String position;
    private String email;
    private String phoneNumber;
    public Person() {}
    public Person(String id, String name, String birthDate, String position, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public abstract String getInformation();

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + birthDate + "\t" + position + "\t" + email + "\t" + phoneNumber + "\t";
    }
}

package case_study.model;

public class Student extends Person {
    private  String className;
    private double agvScore;
    public Student(String id, String name, String birthDate, String position, String email,
                   String phoneNumber, String className, double agvScore) {
        super(id, name, birthDate, position, email, phoneNumber);
        this.className = className;
        this.agvScore = agvScore;
    }

    public void setAgvScore(double agvScore) {
        this.agvScore = agvScore;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public double getAgvScore() {
        return agvScore;
    }

    public String getInformation() {
        return getId() + "," + getName() + "," + getBirthDate() +
                "," + getPosition() + "," + getEmail() + "," + getPhoneNumber() + "," +
                className + "," + agvScore;
    }

    @Override
    public String toString() {
        return  super.toString()+"\t"+className+"\t"+agvScore+"\t";
    }
}

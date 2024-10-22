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
    public void evaluateAcademicPerformance(double score) {
        if (score < 0 || score > 10) {
            System.out.println("Score is invalid.check again");
            return;
        }
        if (score > 8.5 && score <= 10) {
            System.out.println("Outstanding and awarded a scholarship of 120% of tuition fees.");
        } else if (score > 8.0) {
            System.out.println("Good and awarded a scholarship of 100% of tuition fees");
        } else if (score > 6.5) {
            System.out.println("Fair and awarded a scholarship of 70% of tuition fees");
        } else if (score > 5.0) {
            System.out.println("Those with average performance need to strive to improve themselves.");
        } else if (score > 4.5) {
            System.out.println("Must retake the exam to improve grades.");
        } else {
            System.out.println("Repeat the grade.");
        }
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

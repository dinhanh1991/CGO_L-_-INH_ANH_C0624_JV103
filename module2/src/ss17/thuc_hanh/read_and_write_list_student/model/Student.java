package ss17.thuc_hanh.read_and_write_list_student.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String Id;
    private String Name;
private String address;
    public Student(String id, String name, String address) {
        Id = id;
        Name = name;
        this.address = address;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

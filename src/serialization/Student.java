package serialization;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    String name;
    String surname;
    ArrayList subjects = new ArrayList();

    public Student() {
        this.name = "name";
        this.surname = "surname";
    }

    public Student(String name, String surname, ArrayList subjects) {
        this.name = name;
        this.surname = surname;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public ArrayList getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
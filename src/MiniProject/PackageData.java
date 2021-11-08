package MiniProject;

import java.io.*;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<Students> students=new ArrayList<>();
    Students student;

    public PackageData() {
    }

    public PackageData(String operationType, Students student) {
        this.operationType = operationType;
        this.student = student;
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public ArrayList<Students> getStudents() {
        this.students = getStudentsList();
        return students;
    }

    public void setStudents(ArrayList<Students> students) {
        this.students = students;
        saveStudentsList(students);
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", students=" + students +
                ", student=" + student +
                '}';
    }

    public static void saveStudentsList(ArrayList<Students> students) {
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("studentsList.data"));
            outStream.writeObject(students);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Students> getStudentsList() {
        ArrayList students = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("studentsList.data"));
            students = (ArrayList) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {

        }
        return students;
    }
}

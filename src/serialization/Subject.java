package serialization;

import java.io.Serializable;

public class Subject implements Serializable {
    String subjectName;
    int credits;

    public Subject() {
        this.subjectName = "name";
        this.credits = 0;
    }

    public Subject(String subjectName, int credits) {
        this.subjectName = subjectName;
        this.credits = credits;
    }

    public String getSubjectNameName() {
        return subjectName;
    }

    public void setSubjectNameName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject name='" + subjectName + '\'' +
                ", credits=" + credits +
                '}';
    }
}

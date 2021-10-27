package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Mainn {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        while (true) {
            System.out.println("PRESS [1] TO ADD STUDENT");
            System.out.println("PRESS [2] TO LIST STUDENTS");
            System.out.println("PRESS [0] TO EXIT");
            String choice = in.next();
            if (choice.equals("1")) {
                System.out.println("Insert Name");
                String name = in.next();
                System.out.println("Insert Surname");
                String surname = in.next();
                ArrayList<Subject> subjects = new ArrayList<>();
                while (true) {
                    System.out.println("PRESS [1] TO ADD SUBJECT");
                    System.out.println("PRESS [0] TO GO TO MAIN MENU");
                    String choice1 = in.next();
                    if (choice1.equals("1")) {
                        System.out.println("Insert Subject Name");
                        String subjectName = in.next();
                        System.out.println("Insert Number of Credits");
                        int credits = in.nextInt();
                        subjects.add(new Subject(subjectName, credits));
                    } else{
                        break;
                    }
                    /*PrintWriter writer = new PrintWriter("memory.dat");
                    writer.print("");
                    writer.close();*/
                }
                students.add(new Student(name,surname,subjects));
                saveStudents(students);
            } else if (choice.equals("2")) {
                students = readStudents();
                System.out.println(students.toString());
            } else {
                System.exit(0);;
            }
        }
    }

    public static void saveStudents(ArrayList<Student> students) {
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("memory.dat"));
            outStream.writeObject(students);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> readStudents() {
        ArrayList students = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("memory.dat"));
            students = (ArrayList) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {

        }
        return students;
    }


    public static void saveSubjects(ArrayList<Subject> subjects){
        try{
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("memory.dat"));
            outStream.writeObject(subjects);
            outStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Subject> readSubjects(){
        ArrayList subjects = new ArrayList<>();
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("memory.dat"));
            subjects = (ArrayList)inputStream.readObject();
            inputStream.close();
        }catch (Exception e){

        }
        return subjects;
    }
}
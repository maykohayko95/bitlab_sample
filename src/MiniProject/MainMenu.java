package MiniProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MainMenu extends JPanel{
    private MainFrame parent;

    private JButton addStudentButton;
    private JButton listStudentButton;
    private JButton exitButton;

    public MainMenu(MainFrame parent) {

        this.parent = parent;

        setSize(500,500);
        setLayout(null);

        addStudentButton = new JButton("ADD STUDENT");
        addStudentButton.setSize(300,30);
        addStudentButton.setLocation(100,100);
        add(addStudentButton);
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenuPage().setVisible(false);
                parent.getAddStudentPage().setVisible(true);
            }
        });

        listStudentButton = new JButton("LIST STUDENTS");
        listStudentButton.setSize(300,30);
        listStudentButton.setLocation(100,150);
        add(listStudentButton);
        listStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Students> students = new ArrayList<>();
                try{
                    Socket socket = new Socket("localhost", 4567);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    PackageData data = new PackageData("LIST STUDENTS");
                    outputStream.writeObject(data);
                    outputStream.reset();
                    students = (ArrayList<Students>) inputStream.readObject();   //!!!!!!!!!!!!!!!!!!!
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                parent.getListStudentPage().generateTable(students); //!!!!!!!!!!!!!!!!!!!
                parent.getMainMenuPage().setVisible(false);
                parent.getListStudentPage().setVisible(true);
            }
        });

        exitButton = new JButton("EXIT");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,200);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}

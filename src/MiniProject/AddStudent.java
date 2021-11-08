package MiniProject;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AddStudent extends JPanel{
    private MainFrame parent;

    private JLabel name;
    private JLabel surname;
    private JLabel age;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField ageField;
    private JButton add;
    private JButton back;

    public AddStudent(MainFrame parent) {

        this.parent = parent;

        setSize(500, 500);
        setLayout(null);

        name = new JLabel("NAME:");
        name.setSize(100, 30);
        name.setLocation(100, 100);
        add(name);

        surname = new JLabel("SURNAME:");
        surname.setSize(100, 30);
        surname.setLocation(100, 150);
        add(surname);

        age = new JLabel("AGE:");
        age.setSize(100, 30);
        age.setLocation(100, 200);
        add(age);

        nameField = new JTextField();
        nameField.setSize(200, 35);
        nameField.setLocation(200, 100);
        add(nameField);

        surnameField = new JTextField();
        surnameField.setSize(200, 35);
        surnameField.setLocation(200, 150);
        add(surnameField);


        ageField = new JTextField();
        ageField.setSize(200, 35);
        ageField.setLocation(200, 200);
        add(ageField);

        add = new JButton("ADD STUDENT");
        add.setSize(150, 35);
        add.setLocation(100, 300);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Socket socket = new Socket("localhost", 4567);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    String name = nameField.getText();
                    String surname = surnameField.getText();
                    int age = Integer.parseInt(ageField.getText());
                    Students student = new Students(name,surname,age);
                    PackageData data = new PackageData("ADD STUDENT", student);
                    outputStream.writeObject(data);
                    //outputStream.reset();
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                parent.getAddStudentPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
                nameField.setText("");
                surnameField.setText("");
                ageField.setText("");
            }
        });
        add(add);


        back = new JButton("BACK");
        back.setSize(150,35);
        back.setLocation(300,300);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAddStudentPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }
}

package BigProjectAvia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AddAircrafts extends JPanel{
    private MainFrame parent;

    private JLabel name;
    private JLabel model;
    private JLabel busclasscap;
    private JLabel ecoclasscap;
    private JTextField nameField;
    private JTextField modelField;
    private JTextField busclasscapField;
    private JTextField ecoclasscapField;
    private JButton add;
    private JButton back;

    public AddAircrafts(MainFrame parent) {

        this.parent = parent;

        setSize(1000, 1000);
        setLayout(null);

        name = new JLabel("NAME:");
        name.setSize(100, 30);
        name.setLocation(100, 100);
        add(name);

        model = new JLabel("MODEL:");
        model.setSize(100, 30);
        model.setLocation(100, 150);
        add(model);

        busclasscap = new JLabel("BUSINESS CLASS CAPACITY:");
        busclasscap.setSize(100, 30);
        busclasscap.setLocation(100, 200);
        add(busclasscap);

        ecoclasscap = new JLabel("ECONOM CLASS CAPACITY:");
        ecoclasscap.setSize(100, 30);
        ecoclasscap.setLocation(100, 250);
        add(ecoclasscap);

        nameField = new JTextField();
        nameField.setSize(200, 35);
        nameField.setLocation(200, 100);
        add(nameField);

        modelField = new JTextField();
        modelField.setSize(200, 35);
        modelField.setLocation(200, 150);
        add(modelField);

        busclasscapField = new JTextField();
        busclasscapField.setSize(200, 35);
        busclasscapField.setLocation(200, 200);
        add(busclasscapField);

        ecoclasscapField = new JTextField();
        ecoclasscapField.setSize(200, 35);
        ecoclasscapField.setLocation(200, 250);
        add(ecoclasscapField);

        add = new JButton("ADD AIRCRAFT");
        add.setSize(150, 35);
        add.setLocation(100, 300);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket socket = new Socket("localhost", 6789);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    String name = nameField.getText();
                    String model = modelField.getText();
                    int busclasscap = Integer.parseInt(busclasscapField.getText());
                    int ecoclasscap = Integer.parseInt(ecoclasscapField.getText());
                    Aircrafts aircraft = new Aircrafts(name, model, busclasscap,ecoclasscap);
                    PackageData data = new PackageData("ADD AIRCRAFT", aircraft);
                    outputStream.writeObject(data);
                    //outputStream.reset();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                parent.getAddAircraftsPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
                nameField.setText("");
                modelField.setText("");
                busclasscapField.setText("");
                ecoclasscapField.setText("");
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
                parent.getAddAircraftsPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }
}

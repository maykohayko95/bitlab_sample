package BigProjectAvia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AddCities extends JPanel {
    private MainFrame parent;

    private JLabel name;
    private JLabel country;
    private JLabel shortName;
    private JTextField nameField;
    private JTextField countryField;
    private JTextField shortNameField;
    private JButton add;
    private JButton back;

    public AddCities(MainFrame parent) {

        this.parent = parent;

        setSize(1000, 1000);
        setLayout(null);

        name = new JLabel("NAME:");
        name.setSize(100, 30);
        name.setLocation(100, 100);
        add(name);

        country = new JLabel("COUNTRY:");
        country.setSize(100, 30);
        country.setLocation(100, 150);
        add(country);

        shortName = new JLabel("SHORT NAME:");
        shortName.setSize(100, 30);
        shortName.setLocation(100, 200);
        add(shortName);

        nameField = new JTextField();
        nameField.setSize(200, 35);
        nameField.setLocation(200, 100);
        add(nameField);

        countryField = new JTextField();
        countryField.setSize(200, 35);
        countryField.setLocation(200, 150);
        add(countryField);

        shortNameField = new JTextField();
        shortNameField.setSize(200, 35);
        shortNameField.setLocation(200, 200);
        add(shortNameField);

        add = new JButton("ADD CITY");
        add.setSize(150, 35);
        add.setLocation(100, 300);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket socket = new Socket("localhost", 6789);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    String name = nameField.getText();
                    String country = countryField.getText();
                    String shortName = shortNameField.getText();
                    Cities city = new Cities(name,country,shortName);
                    PackageData data = new PackageData("ADD CITY", city);
                    outputStream.writeObject(data);
                    //outputStream.reset();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                parent.getAddCityPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
                nameField.setText("");
                countryField.setText("");
                shortNameField.setText("");
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
                parent.getAddCityPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }
}

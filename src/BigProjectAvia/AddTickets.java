package BigProjectAvia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AddTickets extends JPanel {
    private MainFrame parent;

    private JLabel flightId;
    private JLabel name;
    private JLabel surname;
    private JLabel passportNumber;
    private JLabel ticketType;
    private JTextField flightIdField;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField passportNumberField;
    private JTextField ticketTypeField;
    private JButton add;
    private JButton back;

    public AddTickets(MainFrame parent) {

        this.parent = parent;

        setSize(1000, 1000);
        setLayout(null);

        flightId = new JLabel("FLIGHT ID:");
        flightId.setSize(100, 30);
        flightId.setLocation(100, 100);
        add(flightId);

        name = new JLabel("NAME:");
        name.setSize(100, 30);
        name.setLocation(100, 150);
        add(name);

        surname = new JLabel("SURNAME:");
        surname.setSize(100, 30);
        surname.setLocation(100, 200);
        add(surname);

        passportNumber = new JLabel("PASSPORT NUMBER:");
        passportNumber.setSize(100, 30);
        passportNumber.setLocation(100, 250);
        add(passportNumber);

        ticketType = new JLabel("TICKET TYPE:");
        ticketType.setSize(100, 30);
        ticketType.setLocation(100, 300);
        add(ticketType);

        flightIdField = new JTextField();
        flightIdField.setSize(200, 35);
        flightIdField.setLocation(200, 100);
        add(flightIdField);

        nameField = new JTextField();
        nameField.setSize(200, 35);
        nameField.setLocation(200, 150);
        add(nameField);

        surnameField = new JTextField();
        surnameField.setSize(200, 35);
        surnameField.setLocation(200, 200);
        add(surnameField);

        passportNumberField = new JTextField();
        passportNumberField.setSize(200, 35);
        passportNumberField.setLocation(200, 250);
        add(passportNumberField);

        ticketTypeField = new JTextField();
        ticketTypeField.setSize(200, 35);
        ticketTypeField.setLocation(200, 300);
        add(ticketTypeField);

        add = new JButton("ADD TICKET");
        add.setSize(150, 35);
        add.setLocation(100, 400);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket socket = new Socket("localhost", 6789);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    int flightId = Integer.parseInt(flightIdField.getText());
                    String name = nameField.getText();
                    String surname = surnameField.getText();
                    String passportNum = passportNumberField.getText();
                    String ticketType = ticketTypeField.getText();
                    Tickets ticket = new Tickets(flightId,name,surname,passportNum,ticketType);
                    PackageData data = new PackageData("ADD TICKET", ticket);
                    outputStream.writeObject(data);
                    //outputStream.reset();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                parent.getAddTicketPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
                flightIdField.setText("");
                nameField.setText("");
                surnameField.setText("");
                passportNumberField.setText("");
                ticketTypeField.setText("");
            }
        });

        add(add);

        back = new JButton("BACK");
        back.setSize(150,35);
        back.setLocation(300,400);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getAddTicketPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }
}

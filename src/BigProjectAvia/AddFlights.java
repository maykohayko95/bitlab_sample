package BigProjectAvia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AddFlights extends JPanel {
    private MainFrame parent;

    private JLabel aircraftId;
    private JLabel departureCityId;
    private JLabel arrivalCityId;
    private JLabel departureTime;
    private JLabel ecoprice;
    private JLabel busprice;
    private JTextField aircraftIdField;
    private JTextField departureCityIdField;
    private JTextField arrivalCityIdField;
    private JTextField departureTimeField;
    private JTextField ecopriceField;
    private JTextField buspriceField;
    private JButton add;
    private JButton back;

    public AddFlights(MainFrame parent) {

        this.parent = parent;

        setSize(1000, 1000);
        setLayout(null);

        aircraftId = new JLabel("AIRCRAFT ID:");
        aircraftId.setSize(100, 30);
        aircraftId.setLocation(100, 100);
        add(aircraftId);

        departureCityId = new JLabel("DEPARTURE CITY ID:");
        departureCityId.setSize(100, 30);
        departureCityId.setLocation(100, 150);
        add(departureCityId);

        arrivalCityId = new JLabel("ARRIVAL CITY ID:");
        arrivalCityId.setSize(100, 30);
        arrivalCityId.setLocation(100, 200);
        add(arrivalCityId);

        departureTime = new JLabel("DEPARTURE TIME:");
        departureTime.setSize(100, 30);
        departureTime.setLocation(100, 250);
        add(departureTime);

        ecoprice = new JLabel("ECONOM PRICE:");
        ecoprice.setSize(100, 30);
        ecoprice.setLocation(100, 300);
        add(ecoprice);

        busprice = new JLabel("BUSINESS PRICE:");
        busprice.setSize(100, 30);
        busprice.setLocation(100, 350);
        add(busprice);

        aircraftIdField = new JTextField();
        aircraftIdField.setSize(200, 35);
        aircraftIdField.setLocation(200, 100);
        add(aircraftIdField);

        departureCityIdField = new JTextField();
        departureCityIdField.setSize(200, 35);
        departureCityIdField.setLocation(200, 150);
        add(departureCityIdField);

        arrivalCityIdField = new JTextField();
        arrivalCityIdField.setSize(200, 35);
        arrivalCityIdField.setLocation(200, 200);
        add(arrivalCityIdField);

        departureTimeField = new JTextField();
        departureTimeField.setSize(200, 35);
        departureTimeField.setLocation(200, 250);
        add(departureTimeField);

        ecopriceField = new JTextField();
        ecopriceField.setSize(200, 35);
        ecopriceField.setLocation(200, 300);
        add(ecopriceField);

        buspriceField = new JTextField();
        buspriceField.setSize(200, 35);
        buspriceField.setLocation(200, 350);
        add(buspriceField);

        add = new JButton("ADD FLIGHT");
        add.setSize(150, 35);
        add.setLocation(100, 400);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket socket = new Socket("localhost", 6789);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    int aircraftId = Integer.parseInt(aircraftIdField.getText());
                    int departureCityId = Integer.parseInt(departureCityIdField.getText());
                    int arrivalCityId = Integer.parseInt(arrivalCityIdField.getText());
                    String departureTime = departureTimeField.getText();
                    int ecoPrice = Integer.parseInt(ecopriceField.getText());
                    int busPrice = Integer.parseInt(buspriceField.getText());
                    Flights flight = new Flights(aircraftId,departureCityId,arrivalCityId,departureTime,ecoPrice,busPrice);
                    PackageData data = new PackageData("ADD FLIGHT", flight);
                    outputStream.writeObject(data);
                    //outputStream.reset();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                parent.getAddFlightPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
                aircraftIdField.setText("");
                departureCityIdField.setText("");
                arrivalCityIdField.setText("");
                departureTimeField.setText("");
                ecopriceField.setText("");
                buspriceField.setText("");
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
                parent.getAddCityPage().setVisible(false);
                parent.getMainMenuPage().setVisible(true);
            }
        });
    }
}

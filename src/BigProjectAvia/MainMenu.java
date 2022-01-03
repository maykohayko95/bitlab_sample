package BigProjectAvia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class MainMenu extends JPanel{
    private MainFrame parent;

    private JButton addAircraftButton;
    private JButton listAircraftButton;
    private JButton addCityButton;
    private JButton listCitiesButton;
    private JButton addFlightButton;
    private JButton listFlightsButton;
    private JButton addTicketButton;
    private JButton listTicketsButton;
    private JButton exitButton;

    public MainMenu(MainFrame parent) {

        this.parent = parent;

        setSize(1000,1000);
        setLayout(null);

        addAircraftButton = new JButton("ADD AIRCRAFT");
        addAircraftButton.setSize(300,30);
        addAircraftButton.setLocation(100,100);
        add(addAircraftButton);
        addAircraftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenuPage().setVisible(false);
                parent.getAddAircraftsPage().setVisible(true);
            }
        });

        listAircraftButton = new JButton("LIST AIRCRAFTS");
        listAircraftButton.setSize(300,30);
        listAircraftButton.setLocation(100,150);
        add(listAircraftButton);
        listAircraftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Aircrafts> aircrafts = new ArrayList<>();
                try{
                    Socket socket = new Socket("localhost", 6789);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    PackageData data = new PackageData("LIST AIRCRAFTS");
                    outputStream.writeObject(data);
                    outputStream.reset();
                    aircrafts = (ArrayList<Aircrafts>) inputStream.readObject();   //!!!!!!!!!!!!!!!!!!!
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                parent.getListAircraftsPage().generateTable(aircrafts); //!!!!!!!!!!!!!!!!!!!
                parent.getMainMenuPage().setVisible(false);
                parent.getListAircraftsPage().setVisible(true);
            }
        });


        addCityButton = new JButton("ADD CITY");
        addCityButton.setSize(300,30);
        addCityButton.setLocation(100,200);
        add(addCityButton);
        addCityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenuPage().setVisible(false);
                parent.getAddCityPage().setVisible(true);
            }
        });

        listCitiesButton = new JButton("LIST CITIES");
        listCitiesButton.setSize(300,30);
        listCitiesButton.setLocation(100,250);
        add(listCitiesButton);
        listCitiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Cities> cities = new ArrayList<>();
                try{
                    Socket socket = new Socket("localhost", 6789);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    PackageData data = new PackageData("LIST CITIES");
                    outputStream.writeObject(data);
                    outputStream.reset();
                    cities = (ArrayList<Cities>) inputStream.readObject();   //!!!!!!!!!!!!!!!!!!!
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                parent.getListCitiesPage().generateTable(cities); //!!!!!!!!!!!!!!!!!!!
                parent.getMainMenuPage().setVisible(false);
                parent.getListCitiesPage().setVisible(true);
            }
        });


        addFlightButton = new JButton("ADD FLIGHT");
        addFlightButton.setSize(300,30);
        addFlightButton.setLocation(100,300);
        add(addFlightButton);
        addFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenuPage().setVisible(false);
                parent.getAddFlightPage().setVisible(true);
            }
        });

        listFlightsButton = new JButton("LIST FLIGHTS");
        listFlightsButton.setSize(300,30);
        listFlightsButton.setLocation(100,350);
        add(listFlightsButton);
        listFlightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Flights> flights = new ArrayList<>();
                try{
                    Socket socket = new Socket("localhost", 6789);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    PackageData data = new PackageData("LIST FLIGHTS");
                    outputStream.writeObject(data);
                    outputStream.reset();
                    flights = (ArrayList<Flights>) inputStream.readObject();   //!!!!!!!!!!!!!!!!!!!
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                parent.getListFlightsPage().generateTable(flights); //!!!!!!!!!!!!!!!!!!!
                parent.getMainMenuPage().setVisible(false);
                parent.getListFlightsPage().setVisible(true);
            }
        });

        addTicketButton = new JButton("ADD TICKET");
        addTicketButton.setSize(300,30);
        addTicketButton.setLocation(100,400);
        add(addTicketButton);
        addTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                parent.getMainMenuPage().setVisible(false);
                parent.getAddTicketPage().setVisible(true);
            }
        });

        listTicketsButton = new JButton("LIST TICKETS");
        listTicketsButton.setSize(300,30);
        listTicketsButton.setLocation(100,450);
        add(listTicketsButton);
        listTicketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Tickets> tickets = new ArrayList<>();
                try{
                    Socket socket = new Socket("localhost", 6789);
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                    PackageData data = new PackageData("LIST TICKETS");
                    outputStream.writeObject(data);
                    outputStream.reset();
                    tickets = (ArrayList<Tickets>) inputStream.readObject();   //!!!!!!!!!!!!!!!!!!!
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                parent.getListTicketsPage().generateTable(tickets); //!!!!!!!!!!!!!!!!!!!
                parent.getMainMenuPage().setVisible(false);
                parent.getListTicketsPage().setVisible(true);
            }
        });

        exitButton = new JButton("EXIT");
        exitButton.setSize(300,30);
        exitButton.setLocation(100,500);
        add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}

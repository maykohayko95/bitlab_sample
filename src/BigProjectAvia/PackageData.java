package BigProjectAvia;

import java.io.*;
import java.util.ArrayList;

public class PackageData implements Serializable {
    String operationType;
    ArrayList<Aircrafts> aircrafts =new ArrayList<>();
    Aircrafts aircraft;
    ArrayList<Cities> cities =new ArrayList<>();
    Cities city;
    ArrayList<Flights> flights =new ArrayList<>();
    Flights flight;
    ArrayList<Tickets> tickets =new ArrayList<>();
    Tickets ticket;

    public PackageData() {
    }

    public PackageData(String operationType, Aircrafts aircraft, Cities city, Flights flight, Tickets ticket) {
        this.operationType = operationType;
        this.aircraft = aircraft;
        this.city = city;
        this.flight = flight;
        this.ticket = ticket;
    }

    public PackageData(String operationType, Aircrafts aircraft) {
        this.operationType = operationType;
        this.aircraft = aircraft;
    }

    public PackageData(String operationType, Cities city) {
        this.operationType = operationType;
        this.city = city;
    }

    public PackageData(String operationType, Flights flight) {
        this.operationType = operationType;
        this.flight = flight;
    }

    public PackageData(String operationType, Tickets ticket) {
        this.operationType = operationType;
        this.ticket = ticket;
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

    public ArrayList<Aircrafts> getAircrafts() {
        this.aircrafts = getAircraftsList();
        return aircrafts;
    }

    public void setAircrafts(ArrayList<Aircrafts> aircrafts) {
        this.aircrafts = aircrafts;
        saveAircraftsList(aircrafts);
    }

    public Aircrafts getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircrafts aircraft) {
        this.aircraft = aircraft;
    }

    public ArrayList<Cities> getCities() {
        this.cities = getCitiesList();
        return cities;
    }

    public void setCities(ArrayList<Cities> cities) {
        this.cities = cities;
        saveCitiesList(cities);
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public ArrayList<Flights> getFlights() {
        this.flights = getFlightsList();
        return flights;
    }

    public void setFlights(ArrayList<Flights> flights) {
        this.flights = flights;
        saveFlightsList(flights);
    }

    public Flights getFlight() {
        return flight;
    }

    public void setFlight(Flights flight) {
        this.flight = flight;
    }

    public ArrayList<Tickets> getTickets() {
        this.tickets = getTicketsList();
        return tickets;
    }

    public void setTickets(ArrayList<Tickets> tickets) {
        this.tickets = tickets;
        saveTicketsList(tickets);
    }

    public Tickets getTicket() {
        return ticket;
    }

    public void setTicket(Tickets ticket) {
        this.ticket = ticket;
    }

    public static void saveAircraftsList(ArrayList<Aircrafts> aircrafts) {
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("aircrafts.data"));
            outStream.writeObject(aircrafts);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Aircrafts> getAircraftsList() {
        ArrayList aircrafts = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("aircrafts.data"));
            aircrafts = (ArrayList) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {

        }
        return aircrafts;
    }

    public static void saveCitiesList(ArrayList<Cities> cities) {
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("cities.data"));
            outStream.writeObject(cities);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Cities> getCitiesList() {
        ArrayList cities = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("cities.data"));
            cities = (ArrayList) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {

        }
        return cities;
    }

    public static void saveFlightsList(ArrayList<Flights> flights) {
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("flights.data"));
            outStream.writeObject(flights);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Flights> getFlightsList() {
        ArrayList flights = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("flights.data"));
            flights = (ArrayList) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {

        }
        return flights;
    }

    public static void saveTicketsList(ArrayList<Tickets> tickets) {
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("tickets.data"));
            outStream.writeObject(tickets);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Tickets> getTicketsList() {
        ArrayList tickets = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("tickets.data"));
            tickets = (ArrayList) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {

        }
        return tickets;
    }
}

package BigProjectAvia;

import java.io.Serializable;

public class Tickets implements Serializable {
    int id;
    int flightId;
    String name;
    String surname;
    String passportNumber;
    String ticketType;

    public Tickets() {
    }

    public Tickets(int id, int flightId, String name, String surname, String passportNumber, String ticketType) {
        this.id = id;
        this.flightId = flightId;
        this.name = name;
        this.surname = surname;
        this.passportNumber = passportNumber;
        this.ticketType = ticketType;
    }

    public Tickets(int flightId, String name, String surname, String passportNumber, String ticketType) {
        this.flightId = flightId;
        this.name = name;
        this.surname = surname;
        this.passportNumber = passportNumber;
        this.ticketType = ticketType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", ticketType='" + ticketType + '\'' +
                '}';
    }
}

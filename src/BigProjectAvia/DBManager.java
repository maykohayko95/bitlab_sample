package BigProjectAvia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private Connection connection;
    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bigprojectbitlab?useUnicode=true&serverTimezone=UTC","root", "");
            System.out.println("CONNECTED");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public ArrayList<Aircrafts> getAllAircrafts(){
        ArrayList<Aircrafts> aircrafts = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM aircrafts");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String model = rs.getString("model");
                int busclasscap = rs.getInt("business_class_capacity");
                int ecoclasscap = rs.getInt("econom_class_capacity");
                aircrafts.add(new Aircrafts(id,name,model,busclasscap,ecoclasscap));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return aircrafts;
    }

    public void addAircraft(Aircrafts aircraft){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO aircrafts(name,model,business_class_capacity,econom_class_capacity) values(?,?,?,?)");
            st.setString(1,aircraft.getName());
            st.setString(2,aircraft.getModel());
            st.setInt(3,aircraft.getBusclasscap());
            st.setInt(4,aircraft.getEcoclasscap());
            st.executeUpdate();
            //st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Cities> getAllCities(){
        ArrayList<Cities> cities = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cities");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");
                String shortName = rs.getString("short_name");
                cities.add(new Cities(id,name,country,shortName));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return cities;
    }

    public void addCity(Cities city){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO cities(name,country,short_name) values(?,?,?)");
            st.setString(1,city.getName());
            st.setString(2,city.getCountry());
            st.setString(3,city.getShortName());
            st.executeUpdate();
            //st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Flights> getAllFlights(){
        ArrayList<Flights> flights = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM flights");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int aircraftId = rs.getInt("aircraft_id");
                int departureCityId = rs.getInt("departure_city_id");
                int arrivalCityId = rs.getInt("arrival_city_id");
                String departureTime = rs.getString("departure_time");
                int ecoprice = rs.getInt("econom_place_price");
                int busprice = rs.getInt("business_place_price");
                flights.add(new Flights(id,aircraftId,departureCityId,arrivalCityId,departureTime,ecoprice,busprice));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return flights;
    }

    public void addFlight(Flights flight){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO flights(aircraft_id,departure_city_id,arrival_city_id,departure_time,econom_place_price,business_place_price) values(?,?,?,?,?,?)");
            st.setInt(1,flight.getAircraftId());
            st.setInt(2,flight.getDepartureCityId());
            st.setInt(3,flight.getArrivalCityId());
            st.setString(4,flight.getDepartureTime());
            st.setInt(5,flight.getEcoprice());
            st.setInt(6,flight.getBusprice());
            st.executeUpdate();
            //st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Tickets> getAllTickets(){
        ArrayList<Tickets> tickets = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM tickets");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int flightId = rs.getInt("flight_id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String passportNumber = rs.getString("passport_number");
                String ticketType = rs.getString("ticket_type");
                tickets.add(new Tickets(id,flightId,name,surname,passportNumber,ticketType));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return tickets;
    }

    public void addTicket(Tickets ticket){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO tickets(flight_id,name,surname,passport_number,ticket_type) values(?,?,?,?,?)");
            st.setInt(1,ticket.getFlightId());
            st.setString(2,ticket.getName());
            st.setString(3,ticket.getSurname());
            st.setString(4,ticket.getPassportNumber());
            st.setString(5,ticket.getTicketType());
            st.executeUpdate();
            //st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

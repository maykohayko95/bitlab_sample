package BigProjectAvia;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class ClientHandler extends Thread{
    private Socket socket;
    private DBManager dbManager;

    public ClientHandler(Socket socket, DBManager dbManager) {
        this.socket = socket;
        this.dbManager=dbManager;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client connected");
            dbManager.connect();
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            while(true){
                PackageData data = (PackageData) inputStream.readObject();
                if(data.getOperationType().equals("ADD AIRCRAFT")){
                    dbManager.addAircraft(data.getAircraft());
                }else if(data.getOperationType().equals("LIST AIRCRAFTS")){
                    System.out.println(dbManager.getAllAircrafts().toString());
                    outputStream.writeObject(dbManager.getAllAircrafts());
                    outputStream.reset();
                }else if(data.getOperationType().equals("ADD CITY")){
                    dbManager.addCity(data.getCity());
                }else if(data.getOperationType().equals("LIST CITIES")) {
                    System.out.println(dbManager.getAllCities().toString());
                    outputStream.writeObject(dbManager.getAllCities());
                    outputStream.reset();
                }else if(data.getOperationType().equals("ADD FLIGHT")) {
                    dbManager.addFlight(data.getFlight());
                }else if(data.getOperationType().equals("LIST FLIGHTS")) {
                    System.out.println(dbManager.getAllFlights().toString());
                    outputStream.writeObject(dbManager.getAllFlights());
                    outputStream.reset();
                }else if(data.getOperationType().equals("ADD TICKET")) {
                    dbManager.addTicket(data.getTicket());
                }else{
                    System.out.println(dbManager.getAllTickets().toString());
                    outputStream.writeObject(dbManager.getAllTickets());
                    outputStream.reset();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


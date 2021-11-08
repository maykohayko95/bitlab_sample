package MiniProject;

import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClientHandler extends Thread {
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
                if(data.getOperationType().equals("ADD STUDENT")){
                    dbManager.addStudent(data.getStudent());
                }else{
                    System.out.println(dbManager.getAllStudents().toString());
                    outputStream.writeObject(dbManager.getAllStudents());
                    outputStream.reset();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

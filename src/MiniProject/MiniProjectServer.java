package MiniProject;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MiniProjectServer {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
        DBManager dbManager = new DBManager();
        dbManager.connect();
    try{
        ServerSocket server = new ServerSocket(4567);
        while(true){
            Socket socket = server.accept();
            System.out.println("Client connected");
            ClientHandler ch = new ClientHandler(socket,dbManager);
            ch.start();
        }
    }catch (Exception e) {
        e.printStackTrace();
    }
}
}


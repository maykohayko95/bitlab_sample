package SocketThread;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            ServerSocket server = new ServerSocket(2021);
            int clientId = 1;
            PackageData pd = new PackageData("add");
            while(true){
                Socket socket = server.accept();
                System.out.println("Client connected");
                ClientHandler ch = new ClientHandler(socket,clientId,pd);
                ch.start();
                clientId++;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

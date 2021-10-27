package SocketThread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClientHandler extends Thread {
    private Socket socket;
    private int clientId;
    PackageData pd;

    public ClientHandler() {
    }

    public ClientHandler(Socket socket, int clientId, PackageData pd) {
        this.socket = socket;
        this.clientId = clientId;
        this.pd = pd;
    }

    public void run() {
        PackageData pd = new PackageData();
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ArrayList<Book> books = new ArrayList<>();
            while (true) {
                outputStream.writeObject("PRESS [1] TO LIST BOOKS\n" +
                        "PRESS [2] TO ADD BOOKS\n" +
                        "PRESS [0] TO DISCONNECT FROM SERVER");
                int choice = (int) inputStream.readObject();
                if (choice == 1) {
                    outputStream.writeObject(pd.toString() + '\n');
                } else if (choice == 2) {
                    outputStream.writeObject("Insert Book ID");
                    int id = (int) inputStream.readObject();
                    outputStream.writeObject("Insert Book Name");
                    String name = (String) inputStream.readObject();
                    outputStream.writeObject("Insert Author");
                    String author = (String) inputStream.readObject();
                    pd.addBook(new Book(id, name, author));
                    outputStream.writeObject("The book is added successfully");
                } else {
                    break;
                }
            }
        } catch (Exception e) {

        }
    }
}

/*    public static void savePackageData(PackageData pd) {
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("library.data"));
            outStream.writeObject(pd);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PackageData readPackageData() {
        PackageData pd = new PackageData();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("library.data"));
            pd = (PackageData) inputStream.readObject();
            inputStream.close();
        } catch (Exception e) {

        }
        return pd;
    }*/




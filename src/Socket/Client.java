/*package Socket;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Please enter your username: ");
            String userName = in.next();
            Socket socket = new Socket("localhost", 2021);
            while(true){
                System.out.println("PRESS [1] TO SEND MESSAGE\n" +
                        "PRESS [2] TO EXIT");
                int choice = in.nextInt();
                if(choice==1){
                    System.out.println("Insert message text:");
                    String messageText = in.next();
                    MessageData messageData = new MessageData(userName,messageText, new Date());
                    ObjectOutputStream outputStream = new ObjectOutputStream((socket.getOutputStream()));
                    outputStream.writeObject(messageData);
                }else{
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/

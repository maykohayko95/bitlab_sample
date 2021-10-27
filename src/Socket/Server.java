/*package Socket;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(2021);
            Socket socket = server.accept();
            System.out.println("Client connected");
            while(true){
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                MessageData message = (MessageData)inputStream.readObject();
                System.out.println(message.toString());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/

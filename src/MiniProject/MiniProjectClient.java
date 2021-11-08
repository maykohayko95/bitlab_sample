package MiniProject;

import java.net.Socket;
import java.util.Scanner;

public class MiniProjectClient {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            Socket socket = new Socket("127.0.0.1", 4567);
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            mainFrame.setResizable(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*package serialization2;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class serialization2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        while (true) {
            ArrayList<Game> games = new ArrayList<>();
            System.out.println("PRESS [1] TO CREATE GAME");
            System.out.println("PRESS [2] TO ADD PLAYER TO GAME");
            System.out.println("PRESS [3] TO PLAY GAME");
            System.out.println("PRESS [0] TO EXIT");
            String choice = in.next();
            if (choice.equals("1")) {
                ArrayList<Player> players = new ArrayList<>();
                System.out.println("Game name:");
                String gameName = in.next();
                System.out.println("IP address:");
                String ipAddress = in.next();
                System.out.println("PORT:");
                int port = in.nextInt();
                games.add(new Game(gameName, ipAddress, port, players));
                saveGame(games);
            } else if (choice.equals("2")) {
                System.out.println("CHOOSE GAME: \n");
                games = readGame();
                int i = 1;
                for (Game s : games) {
                    System.out.println(i + " " + s.getGameName());
                    i++;
                }
                int ind = in.nextInt();
                System.out.println("Nickname:");
                String nickName = in.next();
                System.out.println("Rating:");
                double rating = in.nextDouble();
                games.get(ind - 1).addPlayer((new Player(nickName, rating)));
                saveGame(games);
            } else if (choice.equals("3")) {
                System.out.println("CHOOSE GAME: \n");
                ArrayList<Player> players = new ArrayList<>();
                players = readPlayers();
                games = readGame();
                int i = 1;
                for (Game s : games) {
                    System.out.println(i + " " + s.getGameName());
                    i++;
                }
                int ind = in.nextInt();
                for(int j =0;j< games.size();j++ ) {
                    if (players.size()==0) {
                        System.out.println("No players");
                    } else {
                        System.out.println(games.get(j).toString());
                    }
                }
            } else {
                break;
            }
        }
    }

    public static void saveGame(ArrayList<Game> games) {
        try {
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("settings.data"));
            outStream.writeObject(games);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Game> readGame(){
        ArrayList games = new ArrayList<>();
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("settings.data"));
            games = (ArrayList) inputStream.readObject();
            inputStream.close();
        }catch (Exception e){

        }
        return games;
    }
    public static void savePlayers(ArrayList<Player> players){
        try{
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("settings.data"));
            outStream.writeObject(players);
            outStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Player> readPlayers(){
        ArrayList players = new ArrayList<>();
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("settings.data"));
            players = (ArrayList)inputStream.readObject();
            inputStream.close();
        }catch (Exception e){

        }
        return players;
    }
}*/
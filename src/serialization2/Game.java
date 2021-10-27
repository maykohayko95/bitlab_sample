package serialization2;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
    String gameName;
    String ipAddress;
    int port;
    ArrayList<Player> players = new ArrayList<>();

    public Game() {

    }

    public Game(String gameName, String ipAddress, int port, ArrayList<Player> players) {
        this.gameName = gameName;
        this.ipAddress = ipAddress;
        this.port = port;
        this.players = players;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ArrayList getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList players) {
        this.players = players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }


    @Override
    public String toString() {
        return "Game{" +
                "gameName='" + gameName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", port=" + port +
                ", players=" + players +
                '}';
    }
}

package serialization2;

import java.io.Serializable;

public class Player implements Serializable {
    String nickName;
    double rating;

    public Player() {
        this.nickName = "nickName";
        this.rating = 0;
    }

    public Player(String nickName, double rating) {
        this.nickName = nickName;
        this.rating = rating;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nickName='" + nickName + '\'' +
                ", rating=" + rating +
                '}';
    }
}

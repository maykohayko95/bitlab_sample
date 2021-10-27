package thread1;

import javax.swing.*;

public class Location extends Thread{
    JLabel sign;

    public Location() {
    }

    public Location(JLabel sign) {
        this.sign = sign;
    }

    public void run() {
        try{
            int x = 100;
            int y = 100;
            for(int i=0;i<390;i++){
                sign.setLocation(x+i,y+i);
                Thread.sleep(100);
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

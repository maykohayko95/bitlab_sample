package thread3;

import java.util.ArrayList;

public class Car extends Thread{
    String name;
    int speed;
    int distance;

    public Car(String name, int speed, int distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public Car(String name) {
        this.name = name;
    }


    public void run(){
        try{
            System.out.println(this.name+" started");
            for(int i = 0; i < 11; i++){
                System.out.println(this.name+" "+" is in "+this.distance+" meters");
                this.distance+=100;
                Thread.sleep(1000);
            }
            System.out.println(this.name+" finished");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

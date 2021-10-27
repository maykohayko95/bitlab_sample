package thread3;

import java.util.ArrayList;

public class threadMain3 {
    public static void main(String[] args) {
        Car car1 = new Car("Ferrari");
        Car car2 = new Car("Lamborghini");
        Car car3 = new Car("McLaren");
        Car car4 = new Car("Maseratti");
        Car car5 = new Car("Porsche");
        Car car6 = new Car("BMW");
        Car car7 = new Car("Nissan");
        Car car8 = new Car("Ford");
        Car car9 = new Car("Mercedes");
        Car car10 = new Car("Aston Martin");
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();
        car8.start();
        car9.start();
        car10.start();

        /*ArrayList<Car> cars = new ArrayList<>();
        for(int i = 0; i<10;i++){
            cars.add(cars.get(i));
            i++;
        }*/

    }
}

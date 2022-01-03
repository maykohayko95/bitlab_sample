package BigProjectAvia;

import java.io.Serializable;

public class Aircrafts implements Serializable {
    int id;
    String name;
    String model;
    int busclasscap;
    int ecoclasscap;

    public Aircrafts() {

    }

    public Aircrafts(int id, String name, String model, int busclasscap, int ecoclasscap) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.busclasscap = busclasscap;
        this.ecoclasscap = ecoclasscap;
    }

    public Aircrafts(String name, String model, int busclasscap, int ecoclasscap) {
        this.name = name;
        this.model = model;
        this.busclasscap = busclasscap;
        this.ecoclasscap = ecoclasscap;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBusclasscap() {
        return busclasscap;
    }

    public void setBusclasscap(int busclasscap) {
        this.busclasscap = busclasscap;
    }

    public int getEcoclasscap() {
        return ecoclasscap;
    }

    public void setEcoclasscap(int ecoclasscap) {
        this.ecoclasscap = ecoclasscap;
    }

    @Override
    public String toString() {
        return "Aircrafts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", busclasscap=" + busclasscap +
                ", ecoclasscap=" + ecoclasscap +
                '}';
    }
}

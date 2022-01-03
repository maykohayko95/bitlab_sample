package BigProjectAvia;

import java.io.Serializable;

public class Cities implements Serializable {
    int id;
    String name;
    String country;
    String shortName;

    public Cities() {
    }

    public Cities(int id, String name, String country, String shortName) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.shortName = shortName;
    }

    public Cities(String name, String country, String shortName) {
        this.name = name;
        this.country = country;
        this.shortName = shortName;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}

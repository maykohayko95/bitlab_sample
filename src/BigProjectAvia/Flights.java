package BigProjectAvia;

import java.io.Serializable;

public class Flights implements Serializable {
    int id;
    int aircraftId;
    int departureCityId;
    int arrivalCityId;
    String departureTime;
    int ecoprice;
    int busprice;

    public Flights() {
    }

    public Flights(int id, int aircraftId, int departureCityId, int arrivalCityId, String departureTime, int ecoprice, int busprice) {
        this.id = id;
        this.aircraftId = aircraftId;
        this.departureCityId = departureCityId;
        this.arrivalCityId = arrivalCityId;
        this.departureTime = departureTime;
        this.ecoprice = ecoprice;
        this.busprice = busprice;
    }

    public Flights(int aircraftId, int departureCityId, int arrivalCityId, String departureTime, int ecoprice, int busprice) {
        this.aircraftId = aircraftId;
        this.departureCityId = departureCityId;
        this.arrivalCityId = arrivalCityId;
        this.departureTime = departureTime;
        this.ecoprice = ecoprice;
        this.busprice = busprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraftId = aircraftId;
    }

    public int getDepartureCityId() {
        return departureCityId;
    }

    public void setDepartureCityId(int departureCityId) {
        this.departureCityId = departureCityId;
    }

    public int getArrivalCityId() {
        return arrivalCityId;
    }

    public void setArrivalCityId(int arrivalCityId) {
        this.arrivalCityId = arrivalCityId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getEcoprice() {
        return ecoprice;
    }

    public void setEcoprice(int ecoprice) {
        this.ecoprice = ecoprice;
    }

    public int getBusprice() {
        return busprice;
    }

    public void setBusprice(int busprice) {
        this.busprice = busprice;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", aircraftId=" + aircraftId +
                ", departureCityId=" + departureCityId +
                ", arrivalCityId=" + arrivalCityId +
                ", departureTime='" + departureTime + '\'' +
                ", ecoprice=" + ecoprice +
                ", busprice=" + busprice +
                '}';
    }
}

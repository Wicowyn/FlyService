package bean;

import javax.persistence.*;


import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by KaadArloon on 13/02/2015.
 */

@Entity
@Table(name="flights")
@NamedNativeQuery(name = "Flight.findAll", query = "SELECT * FROM flights")

public class Flight {
    private String departure = new String();
    private String arrival = new String();
    private Date dateDeparture = new Date();
    private Date dateArrival = new Date();
    private List<Hotel> hotels = new ArrayList<Hotel>();

    public Flight(String departure, String arrival, Date dateDeparture, Date dateArrival) {
        this.departure = departure;
        this.arrival = arrival;
        this.dateDeparture = dateDeparture;
        this.dateArrival = dateArrival;
    }

    public String getDeparture() {
        return departure;
    }
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public Date getDateDeparture() {
        return dateDeparture;
    }
    public void setDateDeparture(Date dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public Date getDateArrival() {
        return dateArrival;
    }
    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }
    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public Flight addHotel(Hotel h){
        hotels.add(h);
        return this;
    }
    public Flight addAllHotels(List<Hotel> lh){
        hotels.addAll(lh);
        return this;
    }
}

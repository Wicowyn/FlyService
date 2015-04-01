package entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="flights")
@NamedNativeQuery(name = "Flight.findAll", query = "SELECT * FROM flights")

public class Flight {
    @Id
    @GeneratedValue
    private int id;
    private String departure;
    private String arrival;
    private Date dateDeparture;
    private Date dateArrival;
    @ManyToMany
    private List<Hotel> hotels = new ArrayList<Hotel>();


    public Flight() {
    }

    public Flight(String departure, String arrival, Date dateDeparture, Date dateArrival) {
        this.departure = departure;
        this.arrival = arrival;
        this.dateDeparture = dateDeparture;
        this.dateArrival = dateArrival;
    }

    @JsonProperty("start")
    public String getDeparture() {
        return departure;
    }
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @JsonProperty("end")
    public String getArrival() {
        return arrival;
    }
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    @JsonProperty("start_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy")
    public Date getDateDeparture() {
        return dateDeparture;
    }
    public void setDateDeparture(Date dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    @JsonProperty("end_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy")
    public Date getDateArrival() {
        return dateArrival;
    }
    public void setDateArrival(Date dateArrival) {
        this.dateArrival = dateArrival;
    }

    @JsonProperty("hotels")
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

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

package entity;

import javax.persistence.*;

@Entity
@Table(name = "advertising")
@NamedNativeQuery(name = "Advertising.findAll", query = "SELECT * FROM advertising")
public class Advertising {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Flight flight;
    private String text;


    public Advertising() {}

    public Advertising(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void previsualisationAdvertising(){
        String depart = "Le vol au départ de " + flight.getDeparture() + " s'envole le " + flight.getDeparture();
        String arrive = "Le vol pour " + flight.getArrival() + " arrivera le " + flight.getDateArrival();
//        for (Hotel h : flight.getHotels()){
//            String hotel = "L'hotel " + h.getName() + " à l'adresse " + h.getAdresse()
//                    + " à encore des chambres disponnible";
//        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

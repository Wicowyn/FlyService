package entity;

import javax.persistence.*;

/**
 * Created by KaadArloon on 13/02/2015.
 */

@Entity
@Table(name="hotels")
@NamedNativeQuery(name = "Hotel.findAll", query = "SELECT * FROM hotels")
public class Hotel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;


    public Hotel() {

    }

    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

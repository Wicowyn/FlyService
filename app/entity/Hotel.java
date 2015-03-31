package entity;

import javax.persistence.*;

@Entity
@Table(name="hotels")
@NamedNativeQuery(name = "Hotel.findAll", query = "SELECT * FROM hotels")
public class Hotel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private String description;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

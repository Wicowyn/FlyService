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

    private String name = new String();
    private String adress = new String();

    public Hotel(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
}

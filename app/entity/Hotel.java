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
    private String adresse = new String();

    public Hotel(String name, String adresse) {
        this.name = name;
        this.adresse = adresse;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}

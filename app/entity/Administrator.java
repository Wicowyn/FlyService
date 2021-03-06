package entity;

import javax.persistence.*;

@Entity
@Table(name="administrators")
@NamedNativeQuery(name = "Administrator.findAll", query = "SELECT * FROM administrators")
@Deprecated
public class Administrator {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    private int id;

    private String firstName = new String();
    private String lastName = new String();
    private String email = new String();
    private String login = new String();
    private String password = new String();

    public Administrator(String firstName, String lastName, String email, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void connect(){}
    public void disconnect(){}
}

package entity;

import org.hibernate.annotations.Index;
import play.db.jpa.JPA;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedNativeQuery(name = "User.findAll", query = "SELECT * FROM users")
//@UniqueConstraint(name = "idx_login", columnNames = "login")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Index(name = "idx_login")
    @Column(unique = true)
    private String login;

    private String name;

    private String password;
    private String token;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static User find(String login, String password) {
        User user= (User) JPA.em().createQuery("FROM users WHERE login=?1 AND password=?2")
                .setParameter(1, login)
                .setParameter(2, password)
                .getSingleResult();
        /*
        CriteriaQuery<User> query=JPA.em().getCriteriaBuilder().createQuery(User.class);
        Root<User> root=query.from(User.class);

        Metamodel metamodel=JPA.em().getMetamodel();
        EntityType<User> entityType=metamodel.entity(User.class);

        entityType.
        query.where(root.get())*/
        return user;
    }

    public static User find(String login) {
        try {
            return (User) JPA.em().createQuery("FROM User WHERE login=?1")
                    .setParameter(1, login)
                    .getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public static User findByToken(String token) {
        return (User) JPA.em().createQuery("FROM User WHERE token=?1")
                .setParameter(1, token)
                .getSingleResult();
//        try {
//        }
//        catch (NoResultException e){ }

//        return null;
    }
}

package controllers;

import entity.User;
import org.mindrot.jbcrypt.BCrypt;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import java.util.List;
import java.util.Map;

/**
 * Created by yapiti on 13/02/15.
 */
public class UserController extends Controller {

    public static final String AUTH_KEY="X-Session-Token";

    @Transactional(readOnly = true)
    public static Result getUser(int id) {
        User user= JPA.em().find(User.class, id);

        if(user==null) {
            return ok("null");
        }
        else {
            return ok(Json.toJson(user));
        }
    }

    @Transactional
    public static Result createUser() {
        User user=new User();
        user.setLogin(request().body().asFormUrlEncoded().get("login")[0]);

        String password=request().body().asFormUrlEncoded().get("password")[0];
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));

        JPA.em().persist(user);

        user.setToken(BCrypt.hashpw(user.getId()+user.getLogin(), BCrypt.gensalt()));
        JPA.em().persist(user);

        return ok(Json.toJson(user));
    }

    @Transactional
    public static Result login() {
        Map<String, String[]> map=request().body().asFormUrlEncoded();
        User user=User.find(map.get("login")[0]);

        if(user!=null && BCrypt.checkpw(map.get("password")[0], user.getPassword())) {
            user.setToken(BCrypt.hashpw(user.getId()+user.getLogin(), BCrypt.gensalt()));
            JPA.em().persist(user);

            return ok(Json.toJson(user));
        }
        else return forbidden();
    }

    @Transactional(readOnly = true)
    @Security.Authenticated(Secured.class)
    public static Result getAllUser() {
        List<User> list=JPA.em().createQuery("FROM User").getResultList();
//        List<User> list=JPA.em().createNamedQuery("User.findAll").getResultList();

        return ok(Json.toJson(list));
    }
}

package controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import entity.User;
import org.mindrot.jbcrypt.BCrypt;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import views.html.angular;
import views.html.index;

import java.util.List;
import java.util.Map;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready. KIKOO"));
    }

    public static Result angular() {
        return ok(angular.render());
    }

    @With(MyAction.class)
    @FirstAnnotation
    public static Result plop() {
        Logger.info("Call plop");
        Lol lol=new Lol();
        lol.setAge(54);

        return ok(Json.toJson(lol));
    }

    @Transactional(readOnly = true)
    public static Result getUser(int id) {
        User user=JPA.em().find(User.class, id);

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
        String crypted=BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(crypted);

        Logger.info("crypted ; "+crypted);

        JPA.em().persist(user);
        return ok("ok");
    }

    @Transactional
    public static Result login() {
        Map<String, String[]> map=request().body().asFormUrlEncoded();
        User user=User.find(map.get("login")[0]);

        if(user!=null && BCrypt.checkpw(map.get("password")[0], user.getPassword())) {
            return ok(Json.toJson(user));
        }
        else return forbidden();
    }

    @Transactional(readOnly = true)
    @MustAuthenticate
    public static Result getAllUser() {
        List<User> list=JPA.em().createQuery("FROM User").getResultList();
//        List<User> list=JPA.em().createNamedQuery("User.findAll").getResultList();

        return ok(Json.toJson(list));
    }

    public static class Lol {
        private int age;

        @JsonProperty("yolo")
        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

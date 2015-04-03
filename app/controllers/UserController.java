package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entity.OutputResult;
import entity.User;
import org.mindrot.jbcrypt.BCrypt;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import java.io.IOException;
import java.util.List;

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
        JsonNode jsonNode=request().body().asJson();
        UserInput input=Json.fromJson(jsonNode, UserInput.class);

        if(input.login==null || input.password==null){
            return ok(Json.toJson(new OutputResult(OutputResult.FIELD_MISSING)));
        }

        User checkUser=User.find(input.login);
        if(checkUser!=null) {
            return ok(Json.toJson(new OutputResult(OutputResult.ENTITY_ALREADY_EXIST)));
        }

        User user=new User();
        user.setName(input.name);
        user.setLogin(input.login);
        user.setPassword(BCrypt.hashpw(input.password, BCrypt.gensalt()));

        JPA.em().persist(user);

        user.setToken(BCrypt.hashpw(user.getId()+user.getLogin(), BCrypt.gensalt()));
        JPA.em().persist(user);

        return ok(Json.toJson(new CreateOutput(user)));
    }

    @Transactional
    public static Result login() throws IOException {
        JsonNode jsonNode=request().body().asJson();
        UserInput input=Json.fromJson(jsonNode, UserInput.class);

        if(input.login==null || input.password==null){
            return ok(Json.toJson(new OutputResult(OutputResult.FIELD_MISSING)));
        }

        User user=User.find(input.login);

        if(user!=null && BCrypt.checkpw(input.password, user.getPassword())) {
            user.setToken(BCrypt.hashpw(user.getId()+user.getLogin(), BCrypt.gensalt()));
            JPA.em().persist(user);

            return ok(Json.toJson(new CreateOutput(user)));
        }
        else return ok(Json.toJson(new OutputResult(OutputResult.BAD_PASSWORD)));
    }

    @Transactional(readOnly = true)
    @Security.Authenticated(Secured.class)
    public static Result getAllUser() {
        List<User> list=JPA.em().createQuery("FROM User").getResultList();
//        List<User> list=JPA.em().createNamedQuery("User.findAll").getResultList();

        return ok(Json.toJson(list));
    }

    public static class UserInput {
        public String login;
        public String password;
        public String name;
    }

    public static class CreateOutput extends OutputResult {
        public User user;

        public CreateOutput(User user) {
            super();
            this.user = user;
        }
    }
}

package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entity.Hotel;
import entity.User;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by Jeremie on 13/03/2015.
 */
public class HotelController extends Controller {

    @Transactional(readOnly = true)
    public static Result get(int id) {
        Hotel hotel= JPA.em().find(Hotel.class, id);

        if(hotel==null) {
            return ok("null");
        }
        else {
            return ok(Json.toJson(hotel));
        }
    }

    @Transactional
    public static Result delete(int id) {
        Hotel hotel= JPA.em().find(Hotel.class, id);

        if(hotel!=null) {
            JPA.em().remove(hotel);

            return ok();
        }
        else {
            return noContent();
        }
    }

    @Transactional
    public static Result create() {
        JsonNode jsonNode=request().body().asJson();
        Hotel input=Json.fromJson(jsonNode, Hotel.class);

        input.setId(0);

        JPA.em().persist(input);

        return ok(Json.toJson(input.getId()));
    }

    @Transactional(readOnly = true)
//    @Security.Authenticated(Secured.class)
    public static Result getAll() {
        List<User> list=JPA.em().createQuery("FROM Hotel").getResultList();

        return ok(Json.toJson(list));
    }

//    public static class HotelInput {
//        public String login;
//        public String password;
//        public String name;
//    }
}

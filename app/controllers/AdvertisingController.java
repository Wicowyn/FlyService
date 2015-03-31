package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entity.Advertising;
import entity.Flight;
import entity.User;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;


/**
 * Created by Jeremie on 13/03/2015 and modified by Nicolas.
 */
public class AdvertisingController extends Controller {

    @Transactional(readOnly = true)
    public static Result get(int id) {
        Advertising pub= JPA.em().find(Advertising.class, id);

        if(pub==null) {
            return ok("null");
        }
        else {
            return ok(Json.toJson(pub));
        }
    }

    @Transactional
    public static Result delete(int id) {
        Advertising pub= JPA.em().find(Advertising.class, id);

        if(pub!=null) {
            JPA.em().remove(pub);

            return ok();
        }
        else {
            return noContent();
        }
    }

    @Transactional
    public static Result create() {
        JsonNode jsonNode=request().body().asJson();
        AdvertisingInput input=Json.fromJson(jsonNode, AdvertisingInput.class);

        Flight flight=input.flight!=null ?
                input.flight
                : JPA.em().find(Flight.class, input.flightId);

        if(flight!=null) {
            Advertising advertising=new Advertising();

            advertising.setFlight(flight);
            advertising.setText(input.text);

            return ok(Json.toJson(advertising.getId()));
        }
        else {
            return badRequest("Flight id "+input.flightId+" not found");
        }
    }

    @Transactional(readOnly = true)
//    @Security.Authenticated(Secured.class)
    public static Result getAll() {
        List<User> list=JPA.em().createQuery("FROM Advertising").getResultList();

        return ok(Json.toJson(list));
    }

    public static class AdvertisingInput {
        public int flightId;
        public Flight flight;
        public String text;
    }

}

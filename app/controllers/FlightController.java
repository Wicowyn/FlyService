package controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import entity.Flight;
import entity.Hotel;
import entity.User;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jeremie on 13/03/2015.
 */
public class FlightController extends Controller {

    @Transactional(readOnly = true)
    public static Result get(int id) {
        Flight flight= JPA.em().find(Flight.class, id);

        if(flight==null) {
            return ok("null");
        }
        else {
            return ok(Json.toJson(flight));
        }
    }

    @Transactional
    public static Result delete(int id) {
        Flight flight= JPA.em().find(Flight.class, id);

        if(flight!=null) {
            JPA.em().remove(flight);

            return ok();
        }
        else {
            return noContent();
        }
    }

    @Transactional
    public static Result create() {
        JsonNode jsonNode=request().body().asJson();
        FlightInput input=Json.fromJson(jsonNode, FlightInput.class);

        Flight flight=new Flight();

        flight.setArrival(input.end);
        flight.setDateArrival(input.endDate);
        flight.setDateDeparture(input.startDate);
        flight.setDeparture(input.start);

        ArrayList<Hotel> hotels=new ArrayList<>(input.hotels.length);

        for(int id : input.hotels) {
            Hotel hotel=JPA.em().find(Hotel.class, id);

            if(hotel!=null) hotels.add(hotel);
        }

        if(hotels.size()==0) {
            return badRequest("You need at least one hotel");
        }

        if(input.endDate.before(input.startDate)) {
            return badRequest("end date can't be after start date");
        }

        flight.setHotels(hotels);

        JPA.em().persist(flight);

        return ok(Json.toJson(flight.getId()));
    }

    @Transactional(readOnly = true)
//    @Security.Authenticated(Secured.class)
    public static Result getAll() {
        List<User> list=JPA.em().createQuery("FROM Flight").getResultList();

        return ok(Json.toJson(list));
    }

    public static class FlightInput {
        public String start;
        public String end;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy")
        @JsonProperty("start_date")
        public Date startDate;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyy")
        @JsonProperty("end_date")
        public Date endDate;
        public int[] hotels;
    }
}
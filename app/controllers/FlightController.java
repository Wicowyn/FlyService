package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import entity.Flight;
import play.Logger;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

import java.util.Date;
import java.util.List;

/**
 * Created by Jeremie on 13/03/2015.
 */
public class FlightController extends Controller {

    public static final String AUTH_KEY="X-Session-Token";

    @Transactional
    public static Result createFlight() {
        JsonNode jsonNode=request().body().asJson();
        FlightCreationInput input=Json.fromJson(jsonNode, FlightCreationInput.class);

        Logger.debug("Arrival: " + input.arrival + " | Departure: " + input.departure);

        // Create flight entity
        Flight flight=new Flight( input.departure, input.arrival, input.dateDeparture, input.dateArrival);

        // Store it in DB
        JPA.em().persist(flight);

        return ok(Json.toJson(flight));
    }

    @Transactional(readOnly = true)
    public static Result getFlight(int id) {
        Flight flight= JPA.em().find(Flight.class, id);

        if(flight==null) {
            return ok("null");
        }
        else {
            return ok(Json.toJson(flight));
        }
    }

    @Transactional(readOnly = true)
    @Security.Authenticated(Secured.class)
    public static Result getAllFlight() {
        List<Flight> list=JPA.em().createQuery("FROM Flight").getResultList();
//        List<Flight> list=JPA.em().createNamedQuery("Flight.findAll").getResultList();

        return ok(Json.toJson(list));
    }

    public static class FlightCreationInput {
        public String departure;
        public String arrival;
        public Date dateDeparture;
        public Date dateArrival;
    }
}
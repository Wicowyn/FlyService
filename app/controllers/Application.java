package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(main.render("FlyService - The service full of flies", login_template.render()));
    }

    public static Result angular() {
        return ok(angular.render());
    }

    public static Result inscriptionTemplate() {
        return ok(inscription_template.render());
    }

    public static Result loginTemplate() {
        return ok(login_template.render());
    }

    public static Result flyTemplate() {
        return ok(fly_template.render());
    }

    public static Result hotelTemplate() {
        return ok(hotel_template.render());
    }

    public static Result routing() {
        return ok(routing.render());
    }
}

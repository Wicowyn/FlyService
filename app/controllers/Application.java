package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return redirect("/app#/fly");
    }

    public static Result angular() {
        return ok(angular.render());
    }

    public static Result inscriptionTemplate() {
        return ok(inscription_template.render());
    }

    public static Result contactTemplate() {
        return ok(contact.render());
    }

    public static Result aboutTemplate() {
        return ok(about.render());
    }

    public static Result loginTemplate() {
        return ok(login_template.render());
    }

    public static Result flyTemplate() {
        return ok(fly_template.render());
    }

    public static Result hotelListTemplate() {
        return ok(hotelList_template.render());
    }

    public static Result hotelCreateTemplate() {
        return ok(hotelCreate_template.render());
    }

    public static Result routing() {
        return ok(routing.render());
    }
}

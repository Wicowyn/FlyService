package controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready. KIKOO"));
    }

    public static Result angular() {
        return ok(angular.render());
    }

    public static Result inscription() { return ok(inscription.render());
    }

    public static Result loginTemplate() {
        return ok(login_template.render());
    }

    public static Result routing() {
        return ok(routing.render());
    }


    @With(MyAction.class)
    @FirstAnnotation
    public static Result plop() {
        Logger.info("Call plop");
        Lol lol=new Lol();
        lol.setAge(54);

        return ok(Json.toJson(lol));
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

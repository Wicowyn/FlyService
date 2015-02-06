package controllers;

import play.mvc.Http;
import play.mvc.Security;

/**
 * Created by yapiti on 17/12/14.
 */
public class MySecurity extends Security.Authenticator {
    @Override
    public String getUsername(Http.Context context) {
        return super.getUsername(context);
    }
}

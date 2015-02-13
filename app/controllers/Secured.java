package controllers;

import entity.User;
import play.Logger;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by yapiti on 13/02/15.
 */
public class Secured extends Security.Authenticator {

    public static final String USER="user";

    @Override
    public String getUsername(Http.Context ctx) {
        String[] headerValues=ctx.request(). headers().get(UserController.AUTH_KEY);

        if(headerValues!=null && headerValues.length>0 && headerValues[0]!=null){
            Logger.info(headerValues[0]);
            User user=User.findByToken(headerValues[0]);

            if(user!=null) {
                ctx.args.put(USER, user);
                return user.getLogin();
            }
        }
        return null;
    }

    @Override
    public Result onUnauthorized(Http.Context ctx) {
        return forbidden("Must be authenticate");
    }
}

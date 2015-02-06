package controllers;

import entity.User;
import play.Logger;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

/**
 * Created by yapiti on 08/01/15.
 */
public class MustAuthenticatedAction extends Action.Simple {

    @Override
    public F.Promise<Result> call(Http.Context context) throws Throwable {
        Logger.info("Context " + context);
        Logger.info("Context " + context.args);
        Logger.info("Context " + context._requestHeader().headers().get("token").get());
        User.findByToken(context._requestHeader().headers().get("token").get());

        return delegate.call(context);
    }
}

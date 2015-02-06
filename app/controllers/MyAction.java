package controllers;

import play.Logger;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;


/**
 * Created by yapiti on 16/12/14.
 */
public class MyAction extends Action.Simple {

    @Override
    public F.Promise<Result> call(Http.Context context) throws Throwable {
        Logger.info("Context "+context);

        return delegate.call(context);
    }
}

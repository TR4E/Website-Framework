package me.trae.website.framework.types;

import me.trae.website.framework.Page;
import me.trae.website.framework.types.interfaces.IRedirectPage;
import spark.Request;
import spark.Response;

public abstract class RedirectPage extends Page implements IRedirectPage {

    @Override
    public Object getContent(final Request request, final Response response) {
        response.redirect(this.getRedirectedURL());
        return null;
    }
}
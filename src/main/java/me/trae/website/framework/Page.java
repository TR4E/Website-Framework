package me.trae.website.framework;

import me.trae.website.framework.interfaces.IPage;
import me.trae.website.utility.UtilFile;
import spark.Request;
import spark.Response;

import java.io.File;
import java.util.List;

public abstract class Page implements IPage {

    public static Page createHTMLPage(final String route, final String path) {
        return new Page() {
            @Override
            public String getRoute() {
                return route;
            }

            @Override
            public Object getContent(final Request request, final Response response) {
                final File file = new File(UtilFile.toPath("views/" + path));
                final List<String> content = UtilFile.read(file);

                return String.join("\n", content);
            }
        };
    }

    public static Page createRedirectPage(final String route, final String url) {
        return new Page() {
            @Override
            public String getRoute() {
                return route;
            }

            @Override
            public Object getContent(final Request request, final Response response) {
                response.redirect(url);
                return null;
            }
        };
    }
}
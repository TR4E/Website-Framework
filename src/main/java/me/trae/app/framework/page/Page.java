package me.trae.app.framework.page;

import me.trae.app.framework.page.interfaces.IPage;
import me.trae.app.framework.page.types.RedirectionPage;
import me.trae.app.framework.page.types.RenderingPage;
import me.trae.app.utility.UtilFile;
import me.trae.app.utility.UtilJava;
import me.trae.app.utility.UtilWebsite;
import spark.Spark;

import java.util.List;

public abstract class Page implements IPage {

    @Override
    public void initialize() {
        Spark.get(this.getRoute(), (request, response) -> {
            if (this instanceof RedirectionPage) {
                response.redirect(UtilJava.cast(RedirectionPage.class, this).getURL());
                return null;
            }

            if (this instanceof RenderingPage) {
                response.type("text/html");

                String path = UtilJava.cast(RenderingPage.class, this).getPath();
                path = UtilWebsite.getFilePath(path);

                final List<String> content = UtilFile.read(path);

                if (content.isEmpty()) {
                    response.status(500);
                    return "Internal Server Error: Unable to read the file content";
                }

                return String.join("\n", content);
            }

            return "Internal Server Error: Page not found";
        });
    }
}
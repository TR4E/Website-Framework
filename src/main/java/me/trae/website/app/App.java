package me.trae.website.app;

import me.trae.website.framework.Page;
import me.trae.website.framework.Website;
import me.trae.website.utility.UtilFile;
import me.trae.website.utility.UtilJson;

import java.io.File;
import java.util.Map;

public class App extends Website {

    @Override
    public void registerPages() {
        addPage(Page.createHTMLPage("/", "index.html"));

        for (final Map.Entry<String, Object> entry : UtilJson.get(new File(UtilFile.toPath("redirects.json")), ".").entrySet()) {
            addPage(Page.createRedirectPage(entry.getKey().toLowerCase(), entry.getValue().toString()));
        }
    }
}
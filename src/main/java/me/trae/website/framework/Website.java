package me.trae.website.framework;

import me.trae.website.framework.interfaces.IWebsite;
import me.trae.website.utility.UtilMessage;
import spark.Spark;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Website implements IWebsite {

    private final LinkedHashMap<String, Page> PAGES = new LinkedHashMap<>();

    @Override
    public String getAddress() {
        return "0.0.0.0";
    }

    @Override
    public int getPort() {
        return 80;
    }

    @Override
    public LinkedHashMap<String, Page> getPages() {
        return this.PAGES;
    }

    @Override
    public void addPage(final Page page) {
        this.getPages().put(page.getRoute(), page);
    }

    @Override
    public void start() {
        this.registerPages();

        UtilMessage.log("Website", String.format("Added %s Pages: [%s]", this.getPages().size(), String.join(", ", this.getPages().keySet())));

        Spark.ipAddress(this.getAddress());
        Spark.port(this.getPort());

        for (final Map.Entry<String, Page> entry : this.getPages().entrySet()) {
            Spark.get(entry.getKey(), (request, response) -> entry.getValue().getContent(request, response));
        }

        UtilMessage.log("Website", String.format("Running on (%s:%s)", this.getAddress(), this.getPort()));

        Spark.awaitInitialization();
    }
}
package me.trae.app.framework.website;

import me.trae.app.App;
import me.trae.app.framework.page.Page;
import me.trae.app.framework.page.models.HomePage;
import me.trae.app.framework.website.interfaces.IWebsite;
import me.trae.app.utility.UtilMessage;
import spark.Spark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Website implements IWebsite {

    private final List<Page> PAGES = new ArrayList<>();

    @Override
    public List<Page> getPages() {
        return this.PAGES;
    }

    @Override
    public void addPage(final Page page) {
        this.getPages().add(page);
    }

    @Override
    public void run() {
        Spark.ipAddress(this.getAddress());
        Spark.port(this.getPort());

        this.addPage(new HomePage());
        this.registerPages();

        for (final Page page : this.getPages()) {
            page.initialize();
        }

        if (!(this.getPages().isEmpty())) {
            UtilMessage.simpleLog("Website", "Registered Pages: [<var>]", Collections.singletonList(this.getPages().stream().map(Page::getRoute).collect(Collectors.joining(", "))));
        }

        Spark.init();

        UtilMessage.simpleLog("Website", "Listening: http://<var>:<var>", Arrays.asList(this.getAddress(), String.valueOf(this.getPort())));
    }

    public static void main(final String[] args) {
        final App app = new App();

        app.run();
    }
}
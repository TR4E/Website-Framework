package me.trae.website;

import me.trae.website.framework.website.Website;
import me.trae.website.pages.AboutPage;
import me.trae.website.pages.DiscordPage;

public class App extends Website {

    @Override
    public String getAddress() {
        return "0.0.0.0";
    }

    @Override
    public int getPort() {
        return 80;
    }

    @Override
    public void registerPages() {
        addPage(new DiscordPage());
        addPage(new AboutPage());
    }

    public static void main(final String[] args) {
        new App().run();
    }
}
package me.trae.app;

import me.trae.app.framework.website.Website;

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
    }
}
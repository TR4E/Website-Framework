package me.trae.app;

import me.trae.app.framework.website.Website;

public class TestApp extends Website {

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

    public static void main(final String[] args) {
        new TestApp().run();
    }
}
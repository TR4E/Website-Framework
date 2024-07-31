package me.trae.app.framework.page.models;

import me.trae.app.framework.page.Page;
import me.trae.app.framework.page.types.RenderingPage;

public class HomePage extends Page implements RenderingPage {

    @Override
    public String getRoute() {
        return "/";
    }

    @Override
    public String getPath() {
        return "index.html";
    }
}
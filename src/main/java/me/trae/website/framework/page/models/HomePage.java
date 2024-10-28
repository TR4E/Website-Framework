package me.trae.website.framework.page.models;

import me.trae.website.framework.page.Page;
import me.trae.website.framework.page.types.RenderingPage;

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
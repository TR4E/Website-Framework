package me.trae.website.pages;

import me.trae.website.framework.page.Page;
import me.trae.website.framework.page.types.RenderingPage;

public class AboutPage extends Page implements RenderingPage {

    @Override
    public String getRoute() {
        return "about";
    }

    @Override
    public String getPath() {
        return "about.html";
    }
}
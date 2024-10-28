package me.trae.website.pages;

import me.trae.website.framework.page.Page;
import me.trae.website.framework.page.types.RedirectionPage;

public class DiscordPage extends Page implements RedirectionPage {

    @Override
    public String getRoute() {
        return "discord";
    }

    @Override
    public String getURL() {
        return "https://discord.com";
    }
}
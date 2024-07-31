package me.trae.app.framework.website.interfaces;

import me.trae.app.framework.page.Page;

import java.util.List;

public interface IWebsite {

    String getAddress();

    int getPort();

    List<Page> getPages();

    void registerPages();

    void addPage(final Page page);

    void run();
}
package me.trae.website.framework.website.interfaces;

import me.trae.website.framework.page.Page;

import java.util.List;

public interface IWebsite {

    String getAddress();

    int getPort();

    List<Page> getPages();

    void registerPages();

    void addPage(final Page page);

    void run();
}
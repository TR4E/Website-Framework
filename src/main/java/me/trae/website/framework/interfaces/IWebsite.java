package me.trae.website.framework.interfaces;

import me.trae.website.framework.Page;

import java.util.LinkedHashMap;

public interface IWebsite {

    String getAddress();

    int getPort();

    void registerPages();

    LinkedHashMap<String, Page> getPages();

    void addPage(final Page page);

    void start();
}
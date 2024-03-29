package me.trae.website.framework.interfaces;

import spark.Request;
import spark.Response;

public interface IPage {

    String getRoute();

    Object getContent(final Request request, final Response response);
}
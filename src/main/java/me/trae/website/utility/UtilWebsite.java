package me.trae.website.utility;

public class UtilWebsite {

    public static final String PUBLIC_PATH = "resources/public";

    public static String getFilePath(final Type type, final String fileName) {
        return String.format("%s/%s/%s", PUBLIC_PATH, type.name().toLowerCase(), fileName);
    }

    public enum Type {
        HTML, CSS, JS
    }
}
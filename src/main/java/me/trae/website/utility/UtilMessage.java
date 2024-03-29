package me.trae.website.utility;

public class UtilMessage {

    private static String getPrefix(final String prefix) {
        if (prefix == null) {
            return "";
        }

        return (prefix + ">") + " ";
    }

    public static void log(final String prefix, final String message) {
        System.out.println(getPrefix(prefix) + message);
    }

    public static void log(final String message) {
        log(null, message);
    }
}
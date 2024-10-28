package me.trae.website.utility;

import java.util.List;

public class UtilMessage {

    private static String getPrefix(final String prefix) {
        if (prefix == null) {
            return "";
        }

        return String.format("%s> ", prefix);
    }

    public static void log(final String prefix, final String message) {
        System.out.println(getPrefix(prefix) + message);
    }

    public static void log(final String message) {
        log(null, message);
    }

    public static void simpleLog(final String prefix, String message, final List<String> variables) {
        message = serialize(message, variables);

        log(prefix, message);
    }

    public static void simpleLog(final String message, final List<String> variables) {
        simpleLog(null, message, variables);
    }

    private static String serialize(String message, final List<String> variables) {
        if (variables != null) {
            for (final String variable : variables) {
                message = message.replaceFirst("<var>", variable);
            }
        }

        return message;
    }
}
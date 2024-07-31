package me.trae.app.utility;

public class UtilWebsite {

    public static String getFilePath(final String fileName) {
        return String.format("src\\main\\resources\\pages\\%s", fileName);
    }
}
package me.trae.app.utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilFile {

    public static List<String> read(final String path) {
        final List<String> lines = new ArrayList<>();

        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
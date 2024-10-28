package me.trae.website.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UtilFile {

    public static List<String> read(final File file) {
        List<String> lines = new ArrayList<>();

        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (final Exception e) {
            e.printStackTrace();
        }

        if (!(lines.isEmpty())) {
            lines.removeIf(line -> line == null || line.isEmpty());
        }

        return lines;
    }
}
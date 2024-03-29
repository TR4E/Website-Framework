package me.trae.website.utility;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class UtilFile {

    public static String toPath(String path) {
        if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            path = "resources/" + path;
        } else {
            path = "F:/Java-Projects/Website-Framework/resources/" + path;
        }

        return path;
    }

    public static List<String> read(final File file) {
        List<String> lines = new ArrayList<>();

        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (final Exception ignored) {
        }

        if (!(lines.isEmpty())) {
            lines.removeIf(line -> line == null || line.isEmpty());
        }

        return lines;
    }


    public static void write(final File file, final List<String> lines, final boolean append) {
        if (!(file.exists())) {
            try {
                file.createNewFile();
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }

        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append))) {
            if (!(lines.isEmpty())) {
                bufferedWriter.write(String.join("\n", lines) + "\n");
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void walk(final File directory, final Consumer<File> consumer) {
        final File[] files = directory.listFiles();
        if (files != null) {
            final List<File> list = new ArrayList<>(Arrays.asList(files));

            list.sort(Comparator.comparing(File::length));

            for (final File file : list) {
                if (file.isDirectory()) {
                    walk(file, consumer);
                    continue;
                }

                if (!(file.getName().endsWith(".txt"))) {
                    continue;
                }

                if (file.getParentFile().isDirectory() && file.getParentFile().getName().equalsIgnoreCase("ignored")) {
                    continue;
                }

                consumer.accept(file);
            }
        }
    }
}
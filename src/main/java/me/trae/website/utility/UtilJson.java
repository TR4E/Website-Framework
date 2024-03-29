package me.trae.website.utility;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class UtilJson {

    public static Map<String, Object> get(final File file, final String key) {
        try {
            final String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
            final JSONObject json = new JSONObject(content);
            final String[] keys = key.split("\\.");

            JSONObject current = json;

            for (final String k : keys) {
                if (current.has(k)) {
                    final Object obj = current.get(k);
                    if (obj instanceof JSONObject) {
                        current = (JSONObject) obj;
                    } else {
                        throw new JSONException("Key path does not lead to an object.");
                    }
                } else {
                    throw new JSONException("Key path not found.");
                }
            }

            return current.toMap();
        } catch (final Exception e) {
            e.printStackTrace();
        }

        return new HashMap<>();
    }
}
package com.thirtyk.sdcc;



import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class VDFParser {
    public static Map<String, String> parseVDF(File file) {
        Map<String, String> data = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.contains("\"")) { // Process key-value pairs
                    String[] parts = line.split("\"");
                    if (parts.length >= 3) {
                        data.put(parts[1], parts[2].trim());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
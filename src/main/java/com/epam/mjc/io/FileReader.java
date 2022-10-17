package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Map<String, String> map = new HashMap<>();

        try (BufferedReader inputFile = new BufferedReader(new java.io.FileReader(file));) {
            String s = inputFile.readLine();
            while (s != null) {
                String[] res = s.split("[:|\\n]");
                map.put(res[0].trim(), res[1].trim());
                s = inputFile.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Profile(map.get("Name"), Integer.parseInt(map.get("Age")), map.get("Email"), Long.parseLong(map.get("Phone")));
    }
}

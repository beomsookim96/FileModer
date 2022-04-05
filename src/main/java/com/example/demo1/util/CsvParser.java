package com.example.demo1.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CsvParser {

    public Map<String, Map<String,String>> parseCsvToMap(String path) throws FileNotFoundException {

        BufferedReader br = null;
        File file = new File(path);
        FileReader fr = new FileReader(file);
        br = new BufferedReader(fr);
        String line = "";
        Map<String, Map<String,String>> map = new HashMap<>();

        while (true){
            try {
                if (!((line = br.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] columns = line.split(",");
            Map<String,String> tmp = map.getOrDefault(columns[0],new HashMap<>());
            tmp.put(columns[1],columns[2]);
            map.put(columns[0],tmp);
        }

        return map;
    }
}

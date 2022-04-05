package com.example.demo1.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.google.gson.*;

public class FileExplorer {


    public List<String> getFileList(String path){

        File dir = new File(path);
        String[] filenames = dir.list();

        List<String> list = new ArrayList<>();

        list.addAll(Arrays.asList(filenames));

        return list;
    }

    public boolean addLineToFile(String path, String property, String value){

        try {
            Reader reader = new FileReader(path);

            Gson gson= new Gson();
            JsonObject obj = gson.fromJson(reader,JsonObject.class);

            obj.add(property,JsonParser.parseString(value));
            FileWriter fw = new FileWriter(path);
            fw.write(obj.toString());
            fw.flush();
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean subtractLineToFile(String path, String property){

        try {
            Reader reader = new FileReader(path);

            Gson gson= new Gson();

            JsonObject obj = gson.fromJson(reader,JsonObject.class);

            obj.remove(property);
            FileWriter fw = new FileWriter(path);
            fw.write(obj.toString());
            fw.flush();
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }



}

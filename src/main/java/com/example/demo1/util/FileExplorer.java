package com.example.demo1.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.google.gson.*;

public class FileExplorer {


    public List<String> getFileList(String path){

        File dir = new File(path);
        String[] filenames = dir.list();

        List<String> list = new ArrayList<>();

        for (String s :
                filenames) {
            list.add(s);
        }

        return list;
    }

    public boolean addLineToFile(String path, String property, String value){

        try {
            Reader reader = new FileReader(path);

            Gson gson= new Gson();
            JsonObject obj = gson.fromJson(reader,JsonObject.class);
            System.out.println("p : " + property);
            System.out.println("v : " + value);
            System.out.println(obj);

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

    public boolean substractLineToFile(String path, String property){

        try {
            Reader reader = new FileReader(path);

            Gson gson= new Gson();

            JsonObject obj = gson.fromJson(reader,JsonObject.class);
            System.out.println("p : " + property);
            System.out.println(obj);

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

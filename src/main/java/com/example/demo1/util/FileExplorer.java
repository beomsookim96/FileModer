package com.example.demo1.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
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

    public boolean addLineToFile(String path) throws FileNotFoundException {

        Reader reader = new FileReader(path);

        Gson gson= new Gson();
        JsonObject obj = gson.fromJson(reader,JsonObject.class);

        System.out.println(obj);

        return false;
    }



}

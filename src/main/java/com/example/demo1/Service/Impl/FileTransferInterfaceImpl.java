package com.example.demo1.Service.Impl;

import com.example.demo1.Service.FileTransferInterface;
import com.example.demo1.util.CsvParser;
import com.example.demo1.util.FileExplorer;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class FileTransferInterfaceImpl implements FileTransferInterface {

    FileExplorer fe = new FileExplorer();
    CsvParser cp = new CsvParser();

    @Override
    public List<String> getFileList(String path) {
        return fe.getFileList(path);
    }

    @Override
    public boolean addLineToFile(List<String> list, String path,String property, String value) throws FileNotFoundException {

        for (String s:
             list) {
            fe.addLineToFile(path+"/"+s,property,value);
        }

        return false;

    }

    @Override
    public boolean subtractLineToFile(List<String> list, String path, String property) {

        for (String s :
                list) {
            fe.subtractLineToFile(path+"/"+s,property);
        }

        return false;
    }

    @Override
    public boolean csvToJSON(List<String> list, String path) throws FileNotFoundException {

        Gson gson = new Gson();

        for (String s :
                list) {
            Map<String, Map<String,String>> map = cp.parseCsvToMap(path+"/"+s);

            for (String k : map.keySet()) {
                String obj = gson.toJson(map.get(k));
                System.out.println(obj);

            }
        }
        return false;
    }
}

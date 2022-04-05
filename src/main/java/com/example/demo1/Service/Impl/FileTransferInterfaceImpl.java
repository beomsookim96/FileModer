package com.example.demo1.Service.Impl;

import com.example.demo1.Service.FileTransferInterface;
import com.example.demo1.util.FileExplorer;

import java.io.FileNotFoundException;
import java.util.List;

public class FileTransferInterfaceImpl implements FileTransferInterface {

    FileExplorer fe = new FileExplorer();

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
            fe.substractLineToFile(path+"/"+s,property);
        }

        return false;
    }
}

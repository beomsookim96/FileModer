package com.example.demo1.Service;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileTransferInterface {

    public List<String> getFileList(String path);

    public boolean addLineToFile(List<String> list,String path,String property, String value) throws FileNotFoundException;

    public boolean subtractLineToFile(List<String> list,String path,String property);

    public boolean csvToJSON(List<String> list,String path) throws FileNotFoundException;

}

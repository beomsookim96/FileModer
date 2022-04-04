package com.example.demo1.Service;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileTransferInterface {

    public List<String> getFileList(String path);

    public boolean addLineToFile(List<String> list,String path) throws FileNotFoundException;

}

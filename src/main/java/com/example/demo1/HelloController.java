package com.example.demo1;

import com.example.demo1.Service.Impl.FileTransferInterfaceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.controlsfx.control.CheckListView;

import java.io.FileNotFoundException;

public class HelloController {

    FileTransferInterfaceImpl fileTransferInterface = new FileTransferInterfaceImpl();

    @FXML
    private CheckListView<String> filelist;

    @FXML
    private Label welcomeText;

    @FXML
    private TextField jsonpath;


    @FXML
    protected void onHelloButtonClick() {


        /* checked된 항목 초기화 */
        /*  반드시 앞에 있어야함  */
        filelist.getCheckModel().clearChecks();

        /* 이전 Path 목록 초기화 */
        filelist.getItems().clear();

        /* filelist에 checkBoxList 추가 */
        filelist.getItems().addAll(fileTransferInterface.getFileList(jsonpath.getText()));
    }

    @FXML
    protected void onAddButtonClick() throws FileNotFoundException {
        
        /* 개발시에만 사용 *////////////////////////////////////
        for (String s :
                filelist.getCheckModel().getCheckedItems()) {
            System.out.println(s);
        }
        /////////////////////////////////////////////////////

        fileTransferInterface.addLineToFile(filelist.getCheckModel().getCheckedItems(),jsonpath.getText());
    }

}
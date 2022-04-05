package com.example.demo1;

import com.example.demo1.Service.Impl.FileTransferInterfaceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.controlsfx.control.CheckListView;

import java.io.FileNotFoundException;

public class HelloController {

    FileTransferInterfaceImpl fileTransferInterface = new FileTransferInterfaceImpl();

    @FXML
    private Text result;

    @FXML
    private CheckListView<String> filelist;

    @FXML
    private TextField addProperty;

    @FXML
    private TextField addValue;

    @FXML
    private TextField subtractProperty;

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

        fileTransferInterface.addLineToFile(filelist.getCheckModel().getCheckedItems(),
                jsonpath.getText(),
                addProperty.getText(),
                addValue.getText());


    }

    public void onSubtractButtonClick(ActionEvent event) {

        /* 개발시에만 사용 *////////////////////////////////////
        for (String s :
                filelist.getCheckModel().getCheckedItems()) {
            System.out.println(s);
        }
        /////////////////////////////////////////////////////

        fileTransferInterface.subtractLineToFile(filelist.getCheckModel().getCheckedItems(),
                jsonpath.getText(),
                subtractProperty.getText());

    }

    public void onCsvParsingButtonClick(ActionEvent event) throws FileNotFoundException {

        /* 개발시에만 사용 *////////////////////////////////////
        for (String s :
                filelist.getCheckModel().getCheckedItems()) {
            System.out.println(s);
        }
        /////////////////////////////////////////////////////

        fileTransferInterface.csvToJSON(filelist.getCheckModel().getCheckedItems(),jsonpath.getText());
    }
}
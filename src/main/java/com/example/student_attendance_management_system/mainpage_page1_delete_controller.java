package com.example.student_attendance_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class mainpage_page1_delete_controller {

    @FXML
    private Button baou;

    @FXML
    private Label sccmsg;

    @FXML
    private TextField delcls;

    @FXML
    private DatePicker deldte;

    @FXML
    void outbck(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage_page1.fxml"));
        Stage window = (Stage) baou.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void delact(ActionEvent event) {
        DB_file connectnow = new DB_file();
        Connection connectDB = connectnow.getConnection();
        String verifylogin = "DELETE FROM attendance WHERE Date = ('"+ delcls.getText() +"') AND Class = ('"+ delcls.getText() +"');";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(verifylogin);
            sccmsg.setText("DATA DELETED SUCCESSFULLY..!!");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

}

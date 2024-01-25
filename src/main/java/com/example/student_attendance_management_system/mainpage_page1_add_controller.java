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

public class mainpage_page1_add_controller {

    @FXML
    private TextField a1;

    @FXML
    private TextField a2;

    @FXML
    private TextField a3;

    @FXML
    private TextField a4;

    @FXML
    private TextField a5;

    @FXML
    private TextField a6;

    @FXML
    private TextField a7;

    @FXML
    private Button bkot;

    @FXML
    private DatePicker dte;

    @FXML
    private TextField o1;

    @FXML
    private TextField o2;

    @FXML
    private TextField o3;

    @FXML
    private TextField o4;

    @FXML
    private TextField o5;

    @FXML
    private TextField o6;

    @FXML
    private TextField o7;

    @FXML
    private Button sbt;

    @FXML
    private TextField adcs;

    @FXML
    private Label sumsg;

    @FXML
    void bkout(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage_page1.fxml"));
        Stage window = (Stage) bkot.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void sbtsave(ActionEvent event) throws IOException{
        if(adcs.getText()!=null && dte.getValue()!=null) {
            DB_file connectnow = new DB_file();
            Connection connectDB = connectnow.getConnection();
            String verifylogin = "INSERT INTO attendance VALUES('" + dte.getValue() + "','" + adcs.getText() + "','"  + a1.getText() + "','" + a2.getText() + "','" + a3.getText() + "','" + a4.getText() + "','" + a5.getText() + "','" + a6.getText() + "','" + a7.getText() + "','" + o1.getText() + "','" + o2.getText() + "','" + o3.getText() + "','" + o4.getText() + "','" + o5.getText() + "','" + o6.getText() +  "','" + o7.getText() + "');";
            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(verifylogin);
                sumsg.setText("NEW DATA ADDED SUCCESSFULLY.!!");

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        else if(adcs.getText()==null || dte.getValue()==null) {
            sumsg.setText("DATE OR CLASS IS MISSING..!!");
        }

    }

}

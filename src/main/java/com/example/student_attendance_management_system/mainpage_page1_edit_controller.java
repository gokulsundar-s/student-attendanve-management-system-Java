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
import java.sql.ResultSet;
import java.sql.Statement;

public class mainpage_page1_edit_controller {

    @FXML
    private TextField clsed;

    @FXML
    private DatePicker dteed;

    @FXML
    private Button eatbk;

    @FXML
    private TextField eda1;

    @FXML
    private TextField eda2;

    @FXML
    private TextField eda3;

    @FXML
    private TextField eda4;

    @FXML
    private TextField eda5;

    @FXML
    private TextField eda6;

    @FXML
    private TextField eda7;

    @FXML
    private TextField edo1;

    @FXML
    private TextField edo2;

    @FXML
    private TextField edo3;

    @FXML
    private TextField edo4;

    @FXML
    private TextField edo5;

    @FXML
    private TextField edo6;

    @FXML
    private TextField edo7;

    @FXML
    private Button edok;

    @FXML
    private Button edsub;

    @FXML
    private Label ermss;

    @FXML
    void bkk(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage_page1.fxml"));
        Stage window = (Stage) eatbk.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void edsave(ActionEvent event) {
        DB_file connectnow = new DB_file();
        Connection connectDB = connectnow.getConnection();
        String verifylogin = "UPDATE attendance SET AB1 = ('" + eda1.getText() + "'), AB2 = ('" + eda2.getText() + "'), AB3 = ('" + eda3.getText() + "'), AB4 = ('" + eda4.getText() + "'), AB5 = ('" + eda5.getText() + "'), AB6 = ('" + eda6.getText() + "'), AB7 = ('" + eda7.getText() + "'),OD1 = ('" + edo1.getText() + "'), OD2 = ('" + edo2.getText() + "'), OD3 = ('" + edo3.getText() + "'), OD4 = ('" + edo4.getText() + "'), OD5 = ('" + edo5.getText() + "'), OD6 = ('" + edo6.getText() + "'), OD7 = ('" + edo7.getText() + "') WHERE Date = ('" + dteed.getValue() + "') AND Class = ('" + clsed.getText() + "');";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(verifylogin);
            ermss.setText("EDITED DATA UPDATED..!!");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    @FXML
    void edsv(ActionEvent event)  {
        DB_file connectnow = new DB_file();
        Connection connectDB = connectnow.getConnection();
        String verifylogin = "SELECT * FROM attendance WHERE Class = ('" + clsed.getText() + "') AND Date = ('" + dteed.getValue()+"');";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);
            String date = dteed.getValue().toString();
            String Class = clsed.getText();

            while (queryResult.next()) {
                if (queryResult.getString("Date").equals(date) || queryResult.getString("Class").equals(Class)) {
                    String a1 = queryResult.getString("AB1");
                    String a2 = queryResult.getString("AB2");
                    String a3 = queryResult.getString("AB3");
                    String a4 = queryResult.getString("AB4");
                    String a5 = queryResult.getString("AB5");
                    String a6 = queryResult.getString("AB6");
                    String a7 = queryResult.getString("AB7");
                    String o1 = queryResult.getString("OD1");
                    String o2 = queryResult.getString("OD2");
                    String o3 = queryResult.getString("OD3");
                    String o4 = queryResult.getString("OD4");
                    String o5 = queryResult.getString("OD5");
                    String o6 = queryResult.getString("OD6");
                    String o7 = queryResult.getString("OD7");

                    eda1.setText(a1);
                    eda2.setText(a2);
                    eda3.setText(a3);
                    eda4.setText(a4);
                    eda5.setText(a5);
                    eda6.setText(a6);
                    eda7.setText(a7);
                    edo1.setText(o1);
                    edo2.setText(o2);
                    edo3.setText(o3);
                    edo4.setText(o4);
                    edo5.setText(o5);
                    edo6.setText(o6);
                    edo7.setText(o7);

                }

                else{
                    ermss.setText("INVALID DATE OD CLASS..!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}

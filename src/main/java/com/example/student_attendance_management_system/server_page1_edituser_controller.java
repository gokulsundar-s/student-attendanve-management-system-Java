package com.example.student_attendance_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class server_page1_edituser_controller {

    @FXML
    private Button backbut;

    @FXML
    private TextField edfn;

    @FXML
    private TextField edln;

    @FXML
    private TextField edml;

    @FXML
    private PasswordField edpss;

    @FXML
    private Button ok;

    @FXML
    private Button submit;

    @FXML
    private Label erms;

    @FXML
    private Label smsg;

    @FXML
    void backout(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("server_page1.fxml"));
        Stage window = (Stage) backbut.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void gosave(ActionEvent event)throws IOException {
        DB_file connectnow = new DB_file();
        Connection connectDB = connectnow.getConnection();
        String verifylogin = "SELECT * FROM users WHERE Mail_ID = '"+edml.getText()+"';";
        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);
            while (queryResult.next()) {
                if (queryResult.getString(3).equals(edml.getText())) {
                    String fname = queryResult.getString("First_name");
                    String lname = queryResult.getString("Last_name");

                    edfn.setText(fname);
                    edln.setText(lname);
                }

                else{
                    erms.setText("ENTER A VALID MAIL..!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void saveuser(ActionEvent event) throws IOException {
        DB_file connectnow = new DB_file();
        Connection connectDB = connectnow.getConnection();
        String verifylogin = "UPDATE users SET First_Name = ('" + edfn.getText() + "'), Last_Name = ('" + edln.getText() + "') WHERE Mail_ID = ('" + edml.getText() + "');";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(verifylogin);
            smsg.setText("USER DATA UPDATED..!!");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}

package com.example.student_attendance_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

public class server_page1_deleteuser_controller {

    @FXML
    private Button bback;

    @FXML
    private Button deluser;

    @FXML
    private TextField mid;

    @FXML
    private Label demsg;

    @FXML
    void duser(ActionEvent event) throws IOException {
        DB_file connectnow = new DB_file();
        Connection connectDB = connectnow.getConnection();
        String verifylogin = "DELETE FROM users WHERE Mail_ID=('"+ mid.getText() + "');";

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(verifylogin);
            demsg.setText("USER DELETED SUCCESSFULLY..!!");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    @FXML
    void prevpage(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("server_page1.fxml"));
        Stage window = (Stage) bback.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

}

package com.example.student_attendance_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class server_page1_controller {

    @FXML
    private Button addbutton;

    @FXML
    private Button backbutton;

    @FXML
    private Button deletebutton;

    @FXML
    private Button editbutton;

    @FXML
    private Button reportbutton;

    @FXML
    private Button logoutbutton;

    @FXML
    private Button reset;

    @FXML
    private Button seeusers;

    @FXML
    void adduser(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("server_page1_adduser.fxml"));
        Stage window = (Stage) addbutton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void deleteuser(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("server_page1_deleteuser.fxml"));
        Stage window = (Stage) deletebutton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));

    }

    @FXML
    void edituser(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("server_page1_edituser.fxml"));
        Stage window = (Stage) editbutton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void goback(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage.fxml"));
            Stage window = (Stage) backbutton.getScene().getWindow();
            window.setScene(new Scene(fxmlLoader.load(), 1530, 790));

    }

    @FXML
    void signout(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage.fxml"));
        Stage window = (Stage) logoutbutton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 15380, 790));

    }

    @FXML
    void reportgen(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("server_page1_report.fxml"));
        Stage window = (Stage) reportbutton.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void resetpwd(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("server_page1_forget_password.fxml"));
        Stage window = (Stage) reset.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void userslist(ActionEvent event) {

    }

}

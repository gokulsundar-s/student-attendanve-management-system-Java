package com.example.student_attendance_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class mainpage_page1_controller {

    @FXML
    private Button addat;

    @FXML
    private Button back;

    @FXML
    private Button delat;

    @FXML
    private Button dologout;

    @FXML
    private Button edat;

    @FXML
    private Button gere;

    @FXML
    void goout(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage.fxml"));
        Stage window = (Stage) dologout.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));

    }

    @FXML
    void out(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage.fxml"));
        Stage window = (Stage) back.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void add(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage_page1_add.fxml"));
        Stage window = (Stage) addat.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void delete(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage_page1_delete.fxml"));
        Stage window = (Stage) delat.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage_page1_edit.fxml"));
        Stage window = (Stage) edat.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void repo(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage_page1_report.fxml"));
        Stage window = (Stage) gere.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }
}

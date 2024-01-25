package com.example.student_attendance_management_system;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class mainpage extends Application {

    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1530,790);
        stage.setTitle("Student Attendence Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

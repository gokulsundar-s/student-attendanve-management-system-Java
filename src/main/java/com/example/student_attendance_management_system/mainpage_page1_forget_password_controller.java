package com.example.student_attendance_management_system;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;

public class mainpage_page1_forget_password_controller {

    @FXML
    private Label mpermsh;

    @FXML
    private TextField mpfpmid;

    @FXML
    private Button mpreset;

    @FXML
    private Button mpbk;

    @FXML
    void mprebut(ActionEvent event) throws IOException {
        String pword = "";
        DB_file connectnow = new DB_file();
        Connection connectDB = connectnow.getConnection();
        String verifylogin = "SELECT * FROM users WHERE Mail_ID = '"+mpfpmid.getText()+"';";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifylogin);

            while (queryResult.next()) {
                if (queryResult.getString(3).equals(mpfpmid.getText())) {
                    String fname = queryResult.getString("First_name");

                    int len = 8;
                    String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    String Small_chars = "abcdefghijklmnopqrstuvwxyz";
                    String numbers = "0123456789";
                    String symbols = "!@#$%^&*_=+-/.?<>)";
                    String values = Capital_chars + Small_chars + numbers + symbols;
                    Random rndm_method = new Random();
                    char[] pwd = new char[len];
                    for (int i = 0; i < len; i++)
                    {
                        pwd[i] = values.charAt(rndm_method.nextInt(values.length()));
                        pword = pword+pwd[i];
                    }

                    String verifylog = "UPDATE users SET Password = ('" + pword + "') WHERE Mail_ID = ('" + mpfpmid.getText() + "');";

                    try {
                        Statement statement1 = connectDB.createStatement();
                        statement1.executeUpdate(verifylog);
                        mpermsh.setText("Password Reseted..!!");

                        String host="gokulsundars.21cse@kongu.edu";
                        final String user="gokulsundars.21cse@kongu.edu";
                        final String password="gokulsundars.21cse";

                        String to=mpfpmid.getText();

                        Properties props = new Properties();
                        props.put("mail.smtp.ssl.trust", "*");
                        props.put("mail.smtp.auth", "true");
                        props.put("mail.smtp.port", "587");
                        props.put("mail.smtp.host", "smtp.gmail.com");
                        props.put("mail.smtp.starttls.enable", "true");

                        Session session = Session.getDefaultInstance(props,
                                new javax.mail.Authenticator() {
                                    protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                                        return new PasswordAuthentication(user,password);
                                    }
                                });

                        try {
                            MimeMessage message = new MimeMessage(session);
                            message.setFrom(new InternetAddress(user));
                            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
                            message.setSubject("Reset Password!!");
                            message.setText("Hello "+ fname +"!"+"\n"+"You password have been successfully reseted.\n\nYour login credentials:\nMail ID: "+mpfpmid.getText()+"\nPassword: "+pword+"\n\nHave a happy journey with us!!");

                            Transport.send(message);

                        } catch (MessagingException e) {e.printStackTrace();}

                    } catch (Exception e) {
                        e.printStackTrace();
                        e.getCause();
                    }
                }
                else{
                    mpermsh.setText("ENTER A VALID MAIL..!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    void mpfpbk(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("mainpage.fxml"));
        Stage window = (Stage) mpbk.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }
}

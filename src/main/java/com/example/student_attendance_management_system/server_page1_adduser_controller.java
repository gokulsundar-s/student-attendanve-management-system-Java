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

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import static com.sun.tools.classfile.Module_attribute.RequiresEntry.length;

public class server_page1_adduser_controller {

    @FXML
    private Button adduser;

    @FXML
    private Button backpage;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private TextField mailid;

    @FXML
    private Label inmsg;

    @FXML
    void backto (ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainpage.class.getResource("server_page1.fxml"));
        Stage window = (Stage) backpage.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1530, 790));
    }

    @FXML
    void useradd(ActionEvent event) throws IOException {
        int len = 8;
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String values = Capital_chars + Small_chars + numbers + symbols;
        Random rndm_method = new Random();
        char[] pwd = new char[len];
        String pword = "";
        for (int i = 0; i < len; i++)
        {
            pwd[i] = values.charAt(rndm_method.nextInt(values.length()));
            pword = pword+pwd[i];
        }

        if(fname.getText()!=null && lname.getText()!=null && mailid.getText()!=null && (mailid.getText().contains("@kongu.edu") || mailid.getText().contains("@kongu.ac.in"))) {
            DB_file connectnow = new DB_file();
            Connection connectDB = connectnow.getConnection();
            String verifylogin = "INSERT INTO users VALUES('" + fname.getText() + "','" + lname.getText() + "','"  + mailid.getText() + "','" + pword + "');";
            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(verifylogin);
                inmsg.setText("NEW USER CREATED SUCCESSFULLY.!!");

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }

            String host="gokulsundars.21cse@kongu.edu";
            final String user="gokulsundars.21cse@kongu.edu";
            final String password="gokulsundars.21cse";

            String to=mailid.getText();

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
                message.setSubject("Account Activation!!");
                message.setText("Hello "+ fname.getText()+"!"+"\n"+"You have been successfully added to the student attendance application.\n\nYour login credentials:\nMail ID: "+mailid.getText()+"\nPassword: "+pword+"\n\nHave a happy journey with us!!");

                Transport.send(message);
            } catch (MessagingException e) {e.printStackTrace();}
        }

        else if(fname.getText()==null || lname.getText()==null || mailid.getText()==null){
            inmsg.setText("SOME OF THE FIELDS ARE EMPTY.!");
        }

        else if(!mailid.getText().contains("@kongu.edu")){
            inmsg.setText("INVALID MAIL ID..!!!");
        }
    }
}

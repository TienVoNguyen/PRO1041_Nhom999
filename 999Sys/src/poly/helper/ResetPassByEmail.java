/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poly.helper;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Admin
 */
public class ResetPassByEmail {

    public static int resetPass() {
        int codeSMS = (int) (Math.random() * (999999 - 111110 + 1) + 111110);
        final String iDMail = "nongvandat111097@gmail.com";
        final String passMail = "01646321997a";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(iDMail, passMail);
            }
        });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sendmail.fpttext@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("datnvph18618@fpt.edu.vn")
            );
            message.setSubject("Quản Lý Sinh Viên");
            message.setText("Xin chào Anh Dat Dep Troai \n"
                    + "Mã xác nhận của bạn là: " + codeSMS);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return codeSMS;
    }
}
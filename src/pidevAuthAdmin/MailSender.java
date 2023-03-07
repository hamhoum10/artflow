/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevAuthAdmin;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author kanza
 */
public class MailSender {
    
    
     
         
         public void sendVerificationCode(String recipientEmail, String verificationCode) {
        String senderEmail = "katerennada.kanzari@esprit.tn"; // Change this to your own email address
        String senderPassword = "pqujwornegmvnwah"; // Change this to your own email password
        String subject = "Verification Code";
        String message =  verificationCode;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); // Change this to your own SMTP server host if not using Gmail
        props.put("mail.smtp.port", "587"); // Change this to your own SMTP server port if not using Gmail

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress(senderEmail));
            email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            email.setSubject(subject);
            email.setText(message);
            Transport.send(email);
            System.out.println("Verification code sent to " + recipientEmail);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    }


package com.example.PortfolioLukaszKolacz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Lukasz Kolacz on 05.06.2017.
 */

@Service
public class ContactService {
    @Autowired
    private JavaMailSender javaMailSender;


    public void sendEmail(String message, String reply){
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo("lukaszkolacz15@gmail.com");
            helper.setFrom("portfolio.testmaill@gmail.com");
            helper.setSubject("PortfolioContact");
            helper.setText(message, true);
            helper.setReplyTo(reply);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);

    }
}

package com.example.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * 
 * class to send java mail
 *
 */
@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(String to, String subject, String body) {
		
		 MimeMessage message = mailSender.createMimeMessage();
	      
		    MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(message, true);
				
				    helper.setTo(to);
				    helper.setSubject(subject);
				    helper.setText(body,true);
				    
				    mailSender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		     
		   
		    
		   
		         
		
	}
		
}

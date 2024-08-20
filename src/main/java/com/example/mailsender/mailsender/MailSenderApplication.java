package com.example.mailsender.mailsender;

import com.example.mailsender.mailsender.service.EmailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MailSenderApplication {

	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(MailSenderApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

		service.sendEmailWithAttachment("email",
				"This is Email Body with Attachment...",
				"This email has attachment",
				"/Users/indianrenters/Desktop/personal _projects/mailsender/src/main/resources/panda.jpeg");

	}

}

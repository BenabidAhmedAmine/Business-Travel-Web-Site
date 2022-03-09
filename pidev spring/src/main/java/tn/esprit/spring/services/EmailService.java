package tn.esprit.spring.services;

import java.io.FileNotFoundException;

import javax.mail.MessagingException;

public interface EmailService {
	public void sendSimpleEmail(String toAddress, String subject, String message);
	public void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, FileNotFoundException;
}

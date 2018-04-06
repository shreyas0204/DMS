package com.tendrilla.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	/*
	 * public static void main(String[] args) {
	 * 
	 * final String username = "anishsingh7852@gmail.com"; final String password
	 * = "Password_7852";
	 * 
	 * Properties props = new Properties(); props.put("mail.smtp.auth", "true");
	 * // props.put("mail.smtp.starttls.enable", "true");
	 * props.put("mail.smtp.host", "smtp.gmail.com");
	 * props.put("mail.smtp.port", "587");
	 * 
	 * Session session = Session.getInstance(props, new
	 * javax.mail.Authenticator() { protected PasswordAuthentication
	 * getPasswordAuthentication() { return new PasswordAuthentication(username,
	 * password); } });
	 * 
	 * try {
	 * 
	 * Message message = new MimeMessage(session); message.setFrom(new
	 * InternetAddress("anishsingh7852@gmail.com"));
	 * message.setRecipients(Message.RecipientType.TO,
	 * InternetAddress.parse("anish.singh@srslive.in")); message.setSubject(
	 * "Testing Subject"); message.setText("Dear Mail Crawler," +
	 * "\n\n No spam to my email, please!");
	 * 
	 * Transport.send(message);
	 * 
	 * System.out.println("Done");
	 * 
	 * } catch (MessagingException e) { throw new RuntimeException(e); } }
	 */

	public static void main(String[] args) {
		MailSender ms=new MailSender();
		//ms.send("anish.singh@srslive.in", "abc", "123", "Anish");
	}

	public void send(String to, String uId, String psw, String name) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("anishsingh7852@gmail.com", "");
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("anishsingh7852@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Registration Conformation");
			message.setContent("<p><strong>Dear " + name
					+ ",</strong></p><p><strong>Thank you for sign up with Tendrilla<br /> Your credential are as follows</strong></p>"
					+"<table border= '1' width='350'><tbody><tr><td style='width: 200x;'"
					+ "><p><strong>User ID</strong></p></td><td style=" + "width: 410px;" + "><p>" + uId
					+ "</p></td></tr><tr><td style=" + "width: 200px;"
					+ "><p><strong>Password</strong></p></td><td style=" + "width: 410px;" + "><p>" + psw
					+ "</p></td></tr></tbody></table>", "text/html");
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

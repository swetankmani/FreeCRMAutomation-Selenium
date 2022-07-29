package com.crm.qa.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendsimpleTextEmail {
	
	public static void sendEmail() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("nautankibachpan@gmail.com", "hhnzhojheofmtjcl"));
		email.setSSLOnConnect(true);
		email.setFrom("swetankmani02@gmail.com");
		email.setSubject("FreeCRM Test");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("homoguru@learn.com");
		email.send();
		System.out.println("Email Send");
	}
}


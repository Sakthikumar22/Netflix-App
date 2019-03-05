package com.chainsys.model;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class Validation {
	
	public static void sendSimpleMail() throws Exception {
	     Email email = new SimpleEmail();
	     email.setSmtpPort(587);
	     email.setAuthenticator(new DefaultAuthenticator("robinratheya@gmail.com",
	             "googlechrome"));
	     email.setDebug(false);
	     email.setHostName("smtp.gmail.com");
	     email.setFrom("sakthimahesh.sakthi@gmail.com");
	     email.setSubject("Hi");
	     email.setMsg("This is a test mail ... :-)");
	     email.addTo("sakthimahesh.kumar@chainsys.com");
	     email.setStartTLSEnabled(true);
	     email.send();
	     System.out.println("Mail sent!");
	 }

}

package com.chainsys.validation;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class Validation {
	public static void sendSimpleMail() throws Exception {
	     Email email = new SimpleEmail();
	     email.setSmtpPort(587);
	     email.setAuthenticator(new DefaultAuthenticator("chainsys1997@gmail.com",
	             "sama4sadu"));
	     email.setDebug(false);
	     email.setHostName("smtp.gmail.com");
	     email.setFrom("chainsys1997@gmail.com");
	     email.setSubject("Hi");
	     email.setMsg("This is a test mail ... :-)");
	     email.addTo("sakthimahesh.sakthi@gmail.com");
	     email.setStartTLSEnabled(true);
	     email.send();
	     System.out.println("Mail sent!");
	 }
	

}

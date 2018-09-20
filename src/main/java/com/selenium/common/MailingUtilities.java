package com.selenium.common;


import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.SubjectTerm;



public class MailingUtilities {
	Message[] messages = null;
	boolean mailFound = false;
	Message email = null;
	
	public Message getEmail(String emailID, String password, String subjectToBeSearched) throws Exception {
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");

		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imaps");
		store.connect("imap.gmail.com", emailID, password);

		Folder folder = store.getFolder("INBOX");
		folder.open(Folder.READ_WRITE);

		

		for (int i = 0; i < 30; i++) {
		    messages = folder.search(new SubjectTerm(subjectToBeSearched), folder.getMessages());

		    if (messages.length == 0) {
		        Thread.sleep(10000);
		    }
		}

		for (Message mail : messages) {
		    if (!mail.isSet(Flags.Flag.SEEN)) {
		        email = mail;
		        mailFound = true;
		    }
		}

		if (!mailFound) {
		    throw new Exception("Could not found Email, It is now present.");
		}

		return email;
		}
 
  
	public String getTextFromMimeMultipart(
	        MimeMultipart mimeMultipart)  throws MessagingException, IOException{
	    String result = "";
	    int count = mimeMultipart.getCount();
	    for (int i = 0; i < count; i++) {
	        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
	        if (bodyPart.isMimeType("text/plain")) {
	            result = result + "\n" + bodyPart.getContent();
	            break; // without break same text appears twice in my tests
	        } else if (bodyPart.isMimeType("text/html")) {
	            String html = (String) bodyPart.getContent();
	           // result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
	        } else if (bodyPart.getContent() instanceof MimeMultipart){
	            result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
	        }
	    }
	    return result;
	}
	  
	public void Delete() throws MessagingException{
		for (int i = 0; i < messages.length; i++) {
            Message message = messages[i];
         //  System.out.println("Subject: " + message.getSubject());
         message.setFlag(Flags.Flag.DELETED, true);
	      break;
		
	}
}
}

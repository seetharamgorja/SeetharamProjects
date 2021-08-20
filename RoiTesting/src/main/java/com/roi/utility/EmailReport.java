package com.roi.utility;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.ISuite;
import org.testng.reporters.EmailableReporter;
import org.testng.xml.XmlSuite;


public class EmailReport extends EmailableReporter{

	//public  static void main(String args[]){
	@Override
	public void generateReport(List<XmlSuite> xml, List<ISuite> suites, String outdir) {
		
		super.generateReport(xml, suites, outdir);
		final String username = "seetharamunaidu.gorja@pena4tech.com";
	    final String password = "P@ss0rdpena";
	
	    Properties props = new Properties();
	    props.put("mail.smtp.auth", true);
	  //  props.put("mail.smtp.starttls.enable", true);
	    props.put("mail.smtp.host", "mail.pena4tech.com");
	 
	    props.put("mail.smtp.port", "587");
	
	    Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });
	
	    try {
	
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(username));
	        
	        String address = "seetharam.gorja@gmail.com";
	        InternetAddress[] iAdressArray = InternetAddress.parse(address);
	        message.setRecipients(Message.RecipientType.TO, iAdressArray);
	        
	       // message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("To Address"));
	        
	        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
  
	        
			message.setSubject("RoiTest Results on:" +sdf.format(new Date()));
	        message.setText("PFA");
	  	
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	
	        Multipart multipart = new MimeMultipart();
	
	        messageBodyPart = new MimeBodyPart();
	        String file = "path of file to be attached";
	        String fileName = "emailable-report.html";
	        DataSource source = new FileDataSource("C:/Users/GorjaS/eclipse-workspace/RoiTesting/test-output/emailable-report.html");
	       
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName);
	        multipart.addBodyPart(messageBodyPart);
	
	        message.setContent(multipart);
	
	        System.out.println("Sending");
	
	        Transport.send(message);
	
	        System.out.println("Done");
	
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	}
}

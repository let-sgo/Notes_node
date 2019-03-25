package project.com.util;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
public class EmailSend {
	private  String password;
	private  long login_id;
	private  String email;
	private  String fname;
	
   
	public EmailSend(String password, long login_id, String email, String fname) {
		super();
		this.password = password;
		this.login_id = login_id;
		this.email = email;
		this.fname = fname;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public long getLogin_id() {
		return login_id;
	}


	public void setLogin_id(long login_id) {
		this.login_id = login_id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}

public boolean sendMail(){
		 try{
	            String host ="smtp.gmail.com" ;
	            String user = "studytime061@gmail.com";
	            String pass = "stime123#";
	            String to = getEmail();
	            String from = "studytime061@gmail.com";
	            String subject = "Regarding login id and password of study time";
	            String messageText = "Dear, "+getFname()+"\nyour login id for study time  is your roll no "
	            		+getLogin_id()+" and your password is "+getPassword()+"\n Follow this link for login link:"+"\nhttp://localhost:8081/study_time/index.jsp";
	            boolean sessionDebug = false;

	            Properties props = System.getProperties();

	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.host", host);
	            props.put("mail.smtp.port", "587");
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.starttls.required", "true");

	            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	            Session mailSession = Session.getDefaultInstance(props, null);
	            mailSession.setDebug(sessionDebug);
	            Message msg = new MimeMessage(mailSession);
	            msg.setFrom(new InternetAddress(from));
	            InternetAddress[] address = {new InternetAddress(to)};
	            msg.setRecipients(Message.RecipientType.TO, address);
	            msg.setSubject(subject); msg.setSentDate(new Date());
	            msg.setText(messageText);

	           Transport transport=mailSession.getTransport("smtp");
	           transport.connect(host, user, pass);
	           transport.sendMessage(msg, msg.getAllRecipients());
	           transport.close();
	           System.out.println("message send successfully");
	        }catch(Exception ex)
	        {
	            System.out.println(ex);
	            return false;
	        }

	    return true;
	}//method body

}//class


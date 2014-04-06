package dds.kit;

import java.io.File;
import java.io.FileNotFoundException;
import com.github.sendgrid.SendGrid;

/**
 * 
 * @author hzhou
 * 
 */
public class SendMailKit {
	private static SendGrid sendgrid = new SendGrid("zhouhao", "luyuan950288");
	
	/**
	 * 
	 * @param toEmail
	 * @param toName
	 * @param fromEmail
	 * @param fromName
	 * @param subject
	 * @param message
	 * @param filePath
	 * @return request.body()
	 * @see https://github.com/sendgrid/sendgrid-java/blob/master/src/main/java/com/github/sendgrid/SendGrid.java
	 */
	public static String send(
						String toEmail,
						String toName,
						String fromEmail,
						String fromName,
						String subject,
						String message,
						String filePath	){
		
		sendgrid.addTo(toEmail);
		sendgrid.addToName(toName);
		sendgrid.setFrom(fromEmail);
		sendgrid.setFromName(fromName);
		sendgrid.setSubject(subject);
		//sendgrid.setText("My first email through SendGrid");
		sendgrid.setHtml(message);
		if(!filePath.trim().equals("")) {
			try {
				sendgrid.addFile(new File(filePath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return sendgrid.send();
	}
	
	
	public static void main(String[] args){
		SendMailKit.send(
				"royhzhou@gmail.com",
				"Hao Zhou",
				"zhouhao@wpilife.org",
				"Zhou Hao",
				"Hello World",
				"<h1 style='color:red'>Hello World!</h1>",
				" "
				);
	}

	
}
package dds.common;

import com.github.sendgrid.SendGrid;
public class SendMail {
	private SendGrid sendgrid = new SendGrid("zhouhao", "luyuan950288");
	
	public void send(){
		sendgrid.addTo("royhzhou@gmail.com");
		sendgrid.addToName("Hao Zhou");
		sendgrid.setFrom("other@example.com");
		sendgrid.setSubject("Hello World");
		sendgrid.setText("My first email through SendGrid");
		sendgrid.send();
	}
	
	
	public static void main(String[] args){
		SendMail sm = new SendMail();
		sm.send();
	}
	
}
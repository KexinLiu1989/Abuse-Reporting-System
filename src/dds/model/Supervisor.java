package dds.model;

import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("serial")
public class Supervisor extends AbstractUser {
	public static final Supervisor dao = new Supervisor();
	
	public static void main(String[] args) {
		
		AbstractUser supervisor =  Supervisor.dao.findById(1); 
		
		System.out.println(supervisor.get("user_id"));

	}

}

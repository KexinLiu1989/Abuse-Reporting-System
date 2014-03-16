package dds.common;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

/**
 * User model.
 */
@SuppressWarnings("serial")
public class User extends Model<User> {
	public static final User dao = new User();
	
	public User getUserRecordByID(int user_id){
		return dao.findById(user_id);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

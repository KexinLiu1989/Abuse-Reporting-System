package dds.model;

import dds.ext.jfinal.Model;
import com.jfinal.plugin.activerecord.Record;

/**
 * User model.
 */
@SuppressWarnings("serial")
public class User extends Model<User> {
	
	public static final User dao = new User();
	private static final String USER_CACHE = "user";
	
	public User() {
        super(USER_CACHE);
    }
	
	//public User getUserRecordByID(int user_id){
		//return dao.findById(user_id);
	//}
	


}

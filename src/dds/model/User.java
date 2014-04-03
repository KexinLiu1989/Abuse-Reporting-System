package dds.model;

import dds.ext.jfinal.Model;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.ehcache.CacheKit;

/**
 * Author: Hao Zhou
 * Date: 04-02-2014
 * User model.
 */
@SuppressWarnings("serial")
public class User extends Model<User> {
	
	public static final User dao = new User();
	private static final String USER_CACHE = "user";
	
	public User() {
        super(USER_CACHE);
    }
	

}

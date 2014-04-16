package dds.model;

import dds.ext.jfinal.Model;


/**
 * 
 * @author Guanxiong Liu
 * @date 4/16/2014
 * @model Role
 *
 */
@SuppressWarnings("serial")
public class Role extends Model<Role> {
	public static final Role dao = new Role();
	private static final String ROLE_CACHE = "role";
	
	public Role() {
		super(ROLE_CACHE);
	}
	
	/**
	 * get
	 */
	public Role getById (int id) {
		return loadModel(id);
	}
	
	

}

package dds.common;

import java.util.Date;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

/**
 * User model.
 */
@SuppressWarnings("serial")
public abstract class User extends Model<User> {
	private int id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String sex;
	private String telephone;
	private String password;
	private Role role;
	private Date dob;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email
				+ ", sex=" + sex + ", telephone=" + telephone + ", password="
				+ password + ", role=" + role + ", dob=" + dob + "]";
	}
	

	
	
	//public static final User dao = new User();
	
	//public User getUserRecordByID(int user_id){
		//return dao.findById(user_id);
	//}
	


}

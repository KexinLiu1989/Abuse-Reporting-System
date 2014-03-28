package dds.controller;


import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

import dds.common.User;
import dds.interceptor.UserInterceptor;

/**
 * UserController
 * Note: Real SQL Queries should be in Models, currently, I just do it for test
 */
@Before(UserInterceptor.class)
//@Before({UserInterceptor.class , Restful.class})
public class UserController extends Controller {
	public void index() {
		setAttr("users", User.dao.paginate(getParaToInt(0, 1), 10, "select *", "from user"));
		//renderJson();
		/*
		Page<User> page =  User.dao.paginate(getParaToInt(0, 1), 10, "select *", "from user"); 
		for(User user : page.getList()){
			System.out.println(user.get("user_id"));
		}
		*/
		//render("index.html");
	}
	
	public void id(){
		setAttr("users", User.dao.getUserRecordByID(getParaToInt()));
		renderJson();
		
		/* Very little difference between these two ways  */
		//User user = User.dao.getUserRecordByID(getParaToInt());
		//renderJson(user);
	}
	
	public void add() {
		
	}
	
	public void save() {
		getModel(User.class).save();
		redirect("/user");
	}
	
	public void edit() {
		setAttr("user", User.dao.findById(getParaToInt()));
	}
	
	public void update() {
		getModel(User.class).update();
		redirect("/user");
	}
	
	public void delete() {
		User.dao.deleteById(getParaToInt());
		redirect("/user");
	}
}



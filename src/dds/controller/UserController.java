package dds.controller;

import dds.model.User;
import dds.validator.LoginValidator;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;


import dds.interceptor.LoginInterceptor;

/**
 * UserController
 */
//@Before(LoginInterceptor.class)
public class UserController extends Controller {
	
	/**
	 * index page
	 * Display profile page for different roles of users
	 * 
	 * Currently, just display a users list
	 */
	public void index() {
		setAttr("users", User.dao.paginate(getParaToInt(0, 1), 10, "select *", "from user"));
		render("index.html");
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
	
	@Before(LoginValidator.class)
    public void login(){
        String email = getPara("email");
        String password = getPara("password");
        User user = User.dao.getByEmailAndPassword(email, password);
        if (user != null){
            setSessionAttr("user", user);
            setSessionAttr("userID", user.get("id"));
            //System.out.println(getSessionAttr("userID"));
            redirect("/");
        }else{
            setAttr("msg", "Username or password error");
            render("/user/login.html");
        }
    }

    public void logout(){
        removeSessionAttr("user");
        removeSessionAttr("userID");
        redirect("/");
    }
}



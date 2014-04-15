package dds.controller;

import dds.model.User;
import dds.validator.LoginValidator;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

import dds.interceptor.LoginInterceptor;

/**
 * UserController
 * Note: Real SQL Queries should be in Models, currently, I just do it for test
 */
//@Before(LoginInterceptor.class)
public class UserController extends Controller {
	public void index() {
		//setAttr("users", User.dao.paginate(getParaToInt(0, 1), 10, "select *", "from user"));
		//renderJson();
		User user = User.dao.findById(1);
		renderJson(user);
		/*
		Page<User> page =  User.dao.paginate(getParaToInt(0, 1), 10, "select *", "from user"); 
		for(User user : page.getList()){
			System.out.println(user.get("user_id"));
		}
		*/
		//render("index.html");
	}
	
	public void id(){
	//	setAttr("users", User.dao.getUserRecordByID(getParaToInt()));
		renderJson();
		
		/* Very little difference between these two ways  */
		//User user = User.dao.getUserRecordByID(getParaToInt());
		//renderJson(user);
	}
	
	public void add() {
		
	}
	
	public void save() {
		//getModel(User.class).save();
		redirect("/user");
	}
	
	public void edit() {
	//	setAttr("user", User.dao.findById(getParaToInt()));
	}
	
	public void update() {
		//getModel(User.class).update();
		redirect("/user");
	}
	
	public void delete() {
	//	User.dao.deleteById(getParaToInt());
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
        removeCookie("bbsID");
        redirect("/");
    }
}



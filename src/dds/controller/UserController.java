package dds.controller;

import com.jfinal.core.Controller;

import dds.common.User;

/**
 * UserController
 * Note: Real SQL Queries should be in Models, currently, I just do it for test
 */

public class UserController extends Controller {
	public void index() {
		setAttr("users", User.dao.paginate(getParaToInt(0, 1), 10, "select *", "from user"));
		renderJson();
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



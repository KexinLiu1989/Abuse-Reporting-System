package dds.controller;

import com.jfinal.core.Controller;

public class HelloController extends Controller{
	
	public void index(){
		renderJson("Hello String", "Hello JFinal World!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

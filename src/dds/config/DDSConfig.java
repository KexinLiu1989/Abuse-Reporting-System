package dds.config;

import dds.common.User;
import dds.controller.CommonController;
import dds.controller.HelloController;
import dds.controller.UserController;

import com.jfinal.core.JFinal;
import com.jfinal.render.ViewType;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers; 
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

public class DDSConfig extends JFinalConfig{

	public void configConstant(Constants me){
		loadPropertyFile("DatabaseConnection.txt");
		me.setDevMode(true);
		me.setEncoding("utf-8"); // Default is utf-8
		me.setViewType(ViewType.JSP);
		me.setError404View("common/404.html");
		me.setError500View("common/500.html");
	}
	
	public void configRoute(Routes me){
		me.add("/", CommonController.class);
		me.add("/user", UserController.class);
		me.add("/hello", HelloController.class);
	}
	public void configPlugin(Plugins me){
		// Configure C3p0 Database connection pool
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim());
		me.add(c3p0Plugin);
				
		// Configure ActiveRecord 
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("user", "user_id", User.class);	// Table Mapping
	}
	
	public void configInterceptor(Interceptors me){
		
	}
	
	public void configHandler(Handlers me){
		
	}


	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}

}

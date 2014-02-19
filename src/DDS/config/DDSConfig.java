package DDS.config;

import DDS.controller.HelloController;

import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.render.ViewType;

public class DDSConfig extends JFinalConfig{

	public void configConstant(Constants me){
		me.setDevMode(true);
		me.setViewType(ViewType.JSP);
	}
	
	public void configRoute(Routes me){
		me.add("/", HelloController.class);
		me.add("/hello", HelloController.class);
	}
	public void configPlugin(Plugins me){
		
	}
	
	public void configInterceptor(Interceptors me){
		
	}
	
	public void configHandler(Handlers me){
		
	}
	
	
	public static void main(String[] args) {
		JFinal.start("WebRoot", 8080, "/", 5);
	}

}

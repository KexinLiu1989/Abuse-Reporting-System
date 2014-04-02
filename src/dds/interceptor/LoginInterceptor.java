package dds.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

public class LoginInterceptor implements Interceptor {

	@Override
    public void intercept(ActionInvocation ai) {
        Controller controller = ai.getController();
        if(controller.getSessionAttr("user") != null){
            ai.invoke();
        }else{
            controller.setAttr("msg", "Please Login! :-)");
            controller.render("/user/login.html");
        }
    }

}

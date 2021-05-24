/*
 * interceptor class to verify sessions before
*/
package pvt.hob.csi_project.interceptor;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;


public class ValidateLogin implements Interceptor{

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession(false);  
        if(session==null || session.getAttribute("user")==null){  
        	System.out.println("Interceptor : ValidateLogin: \n");
            return "expired";   // if no session or expired; send to it
        }  
        else{
        	System.out.println("Interceptor : ValidateLogin: \n");
            return invocation.invoke(); 
        }  
	}

}



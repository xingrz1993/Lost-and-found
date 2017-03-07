package lostAndFound.com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
  
public class Login  extends ActionSupport implements SessionAware{  
private String username,userpass;  
SessionMap<String,String> sessionMap;  
//private HttpServletRequest request;

@Override
public void setSession(Map map) {  
    this.sessionMap=(SessionMap)map;  
    //this.sessionMap.put("login","true");  
}  
/*public void setServletRequest(HttpServletRequest arg0) {
	this.request = arg0;
}*/

public String getUsername() {  
    return username;  
}  
  
public void setUsername(String username) {  
    this.username = username;  
}  
  
public String getUserpass() {  
    return userpass;  
}  
  
public void setUserpass(String userpass) {  
    this.userpass = userpass;  
}  
 
public String excuteAjax(){ 
	 String loggedUserName = null;
	 String rst=ERROR;
	// String loggedPassword = null;
	 //username=request.getParameter("email");
	// userpass=request.getParameter("password");
	if (sessionMap.containsKey("Username")){//&&sessionMap.containsKey("Password")) {
        loggedUserName = (String) sessionMap.get("Username");
       // loggedPassword = (String) sessionMap.get("Password");
    }
	 if (loggedUserName != null ){//&& LoginDao.validate(loggedUserName, loggedPassword)) {
         rst=SUCCESS; // return welcome page
     }
	 if (username != null && userpass != null && LoginDao.validate(username,userpass)) {
          
         // add userName to the session
         sessionMap.put("Username", username);
         //sessionMap.put("Password", userpass);
         rst= SUCCESS; // return welcome page
     } 
    return rst;
}  
  

  
public String logout(){  
    sessionMap.invalidate();  
    return SUCCESS;  
}  
  
}  
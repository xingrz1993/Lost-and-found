package lostAndFound.com.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;

  
public class Signup extends ActionSupport{  
	private static final long serialVersionUID = 1L;
    private String username,password,email,mobile;  
/*
private HttpServletRequest request;

public void setServletRequest(HttpServletRequest arg0) {
	this.request = arg0;
}*/

    public String getUsername() {  
        return username;  
    }  
      
    public void setUsername(String username) {  
        this.username = username;  
    }  
    
    public String getPassword() {  
        return password;  
    }  
      
    public void setPassword(String password) {  
        this.password = password;  
    }  
    
    public String getEmail() {  
        return email;  
    }  
      
    public void setEmail(String email) {  
        this.email = email;  
    } 
    
    public String getMobile() {  
        return mobile;  
    }  
      
    public void setMobile(String mobile) {  
        this.mobile = mobile;  
    } 
    
public String excuteAjax(){
	 String ret = ERROR;
	 Connection conn = null;
	 //Statement stmt = null;
	 String URL = "jdbc:mysql://localhost/webapp";
	try{
		//open database
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(URL, "root", "yantian94");
        //stmt = conn.createStatement();
        PreparedStatement ps1=conn.prepareStatement(  
        	    "select * from user where userName=?");
        ps1.setString(1,username);
        ResultSet rs=ps1.executeQuery();  
        
        if(rs.next()){
        	ret=ERROR;
        }
        else{
        String sql ="INSERT INTO user (userName, password, email, phone) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, email);
        ps.setString(4, mobile);    
        ps.executeUpdate();
        ret=SUCCESS;
        }
        //postJump="{'name':'Successlalalala'}";
        
	}catch (Exception e) {
		e.printStackTrace();
		//postJump="error";
		ret=ERROR;
	}finally {
         if (conn != null) {
             try {
                conn.close();
             } catch (Exception e) {
             }
          }
       }
	return ret;
}
}
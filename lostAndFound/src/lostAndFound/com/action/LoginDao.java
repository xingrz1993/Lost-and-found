package lostAndFound.com.action;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
 
public class LoginDao {  
 
public static boolean validate(String username,String userpass){  
 boolean status=false;  
 Connection conn = null;
 String URL = "jdbc:mysql://localhost/webapp";
 try{  
	 Class.forName("com.mysql.jdbc.Driver");
     conn = DriverManager.getConnection(URL, "root", "yantian94");
  
    
  PreparedStatement ps=conn.prepareStatement(  
    "select * from user where userName=? and password=?");  
  ps.setString(1,username);  
  ps.setString(2,userpass);  
  ResultSet rs=ps.executeQuery();  
  status=rs.next();  
 }catch(Exception e){e.printStackTrace();}  
return status;  
}  
}  
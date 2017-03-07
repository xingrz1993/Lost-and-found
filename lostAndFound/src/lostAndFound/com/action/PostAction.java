package lostAndFound.com.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class PostAction extends ActionSupport implements ServletRequestAware{
		private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	//private String result;

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	/**
	 * ¥¶¿Ìajax«Î«Û
	 * @return SUCCESS
	 */
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
	        String sql ="INSERT INTO item (property, title, description, date,userID) VALUES (?, ?, ?, ?,1001)";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, request.getParameter("property"));
	        ps.setString(2, request.getParameter("title"));
	        ps.setString(4, request.getParameter("date"));
	        ps.setString(3, request.getParameter("description"));
	        ps.executeUpdate();
	        ret=SUCCESS;
		}catch (Exception e) {
			e.printStackTrace();
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

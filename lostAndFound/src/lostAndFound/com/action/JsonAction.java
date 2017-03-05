package lostAndFound.com.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import net.sf.json.JSONArray;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
import java.sql.*;
//import java.sql.ResultSet;

public class JsonAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	private String result;

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * 处理ajax请求
	 * @return SUCCESS
	 */
	/*public String excuteAjax(){
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
	}*/
	
	
	public String excuteAjax(){
		String ret = ERROR;
	    Connection conn = null;
	    String columnName, columnValue = null;
	    JSONArray json=new JSONArray();
	    JSONObject element = null;
		try {
			ResultSetMetaData rsmd = null;
			Statement stmt = null;
		    
			//获取数据
			String URL = "jdbc:mysql://localhost/webapp";
	        Class.forName("com.mysql.jdbc.Driver");
	        conn = DriverManager.getConnection(URL, "root", "yantian94");
	        stmt = conn.createStatement();
	        String sql = "SELECT * FROM item inner join user on item.userID=user.userID";
	        ResultSet rs = stmt.executeQuery(sql);
	        rsmd = rs.getMetaData();
			//将数据存储在map里，再转换成json类型数据，也可以自己手动构造json类型数据
	        Map<String,String> map = new HashMap<String,String>();
	        while (rs.next()) {
	        for (int i = 0; i < rsmd.getColumnCount(); i++) {
                columnName = rsmd.getColumnName(i + 1);
                columnValue = rs.getString(columnName);
                map.put(columnName, columnValue);
            }
	        element = JSONObject.fromObject(map);
	        json.add(element);
	        map.clear();
	        }
	       // JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
			result = json.toString();//给result赋值，传递给页面
			ret=SUCCESS;
		} catch (Exception e) {
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

package day22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;






public class TestDBA {
	
	   Connection con;
	   PreparedStatement ps;
	   String url, user, pwd ; 
	   //디비셋팅
	   public TestDBA() {      
	         try {
	               Class.forName("oracle.jdbc.driver.OracleDriver");
	               url="jdbc:oracle:thin:@localhost:1521:xe";
	               user = "scott";
	               pwd = "TIGER";       
	               con = DriverManager.getConnection(url, user, pwd);
	               } catch (ClassNotFoundException | SQLException e) {            
	                  e.printStackTrace();         
	               }
	         }
	   
	   public ArrayList<TestBean> testView(){
	         Connection con = null;
	         Statement st = null;
	         ResultSet rs =null;
	         ArrayList<TestBean> arr = new ArrayList<>();      
	         try {
	         con = DriverManager.getConnection(url, user, pwd);
	         String sql = "select * from nametest";
	         st = con.createStatement();
	         rs = st.executeQuery(sql);
	         while(rs.next()) {
	        	TestBean b = new TestBean();
	            b.setNum(rs.getInt("num"));
	            b.setName(rs.getString("name"));
	            b.setBirth(rs.getInt("birth"));
	            b.setTel(rs.getInt("tel"));
	            b.setAddr(rs.getString("addr"));
	            arr.add(b);
	         }      
	         }catch (SQLException e) {
	            e.printStackTrace();      
	         }finally{
	         try {
	            if(rs!=null)rs.close();
	            if(st!=null)st.close();
	            if(con!=null)con.close();      
	         
	         }catch (Exception e) {
	            e.printStackTrace();      
	         }
	         }
	         return arr;   
	   }
	   public void TestUpdate(TestBean b) {
		   Connection con;
		   PreparedStatement ps;
	       try {      
	           con = DriverManager.getConnection(url, user, pwd);
	           String sql ="UPDATE nametest SET name=?,Birth=?,Tel=?,Addr=? WHERE NUM=?";
	           ps = con.prepareStatement(sql);
	           ps.setString(1, b.getName());
	           ps.setInt(2, b.getBirth());         
	           ps.setInt(3, b.getTel());      
	           ps.setString(4, b.getAddr());   
	           ps.setInt(5, b.getNum());
	           ps.executeUpdate();         
	           } catch (SQLException e) {            
	              e.printStackTrace();         
	           }         
		   
		   
	   }
	   public void testInsert(TestBean b) {     
	         
		   try {               
	         String sql ="insert into nametest values(TESTNAME_SEQ.nextval,?,?,?,?)";
	         ps = con.prepareStatement(sql);
	         ps.setString(1, b.getName());
	         ps.setInt(2, b.getBirth());         
	         ps.setInt(3, b.getTel());      
	         ps.setString(4, b.getAddr());   
	         ps.executeUpdate();
	         
	         } catch (SQLException e) {            
	            e.printStackTrace();          
	         }               
	   }

}

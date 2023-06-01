package model;
import java.sql.*;

public class DBHelp {
  private static String url="jdbc:mysql://localhost:3306/mydb";
  //private static String url="jdbc:mysql://localhost:3306/infocharacterEncoding=utf8&useSSL=false&serverTimezone=GMT";
  private static String username="root";
  private static String password="123456";
  //���췽��
  public DBHelp(){
	  
  }
  
  //������Ӷ���
  public static Connection getConnection() throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.jdbc.Driver");
	//Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,username,password);
	return con;
  }
  
  //�������
  public static void close(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException{
	 if(con!=null) con.close();
	 if(ps!=null) ps.close();
	 if(rs!=null) rs.close();
  }
}

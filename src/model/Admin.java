package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {

    private String username;
    private String password;

    private String role;

    public Admin() {
    }

	public Admin(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


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

    
    //mvc模式接口实现应再建立一个接口层，这里显得冗余
    public boolean login(String username, String password, String role) throws SQLException, ClassNotFoundException {
        Connection conn = DBHelp.getConnection();
        String sql = "select * from admin where username = ? and password = ? and role = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,username);
        ps.setObject(2,password);
        
        ps.setObject(3,role);
        ResultSet rs = ps.executeQuery();
        Admin admin = null;
        while (rs.next()){
            admin = new Admin(rs.getString("username"),rs.getString("password"),rs.getString("role"));
        }
        DBHelp.close(conn,ps,rs);
        return admin != null;
        
        /*
         String SQL = "insert into test (name, password) values (?, ?)";

    String sql= "INSERT INTO test(name,password) VALUES(?,?)";
    int update = jdbcTemplateObject.update(SQL,user.getName(),user.getPassword());
        if(update<=0) {
        System.out.println("添加失败");
    }else {
        System.out.println("添加成功");
    }
         * */
    }
    
    public boolean register(String username, String password, String role) throws SQLException, ClassNotFoundException {
        Connection conn = DBHelp.getConnection();
        String sql = "insert into admin(username,password,role) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,username);
        ps.setObject(2,password);
        ps.setObject(3,role);
        //DBHelp.close(conn,ps,null);
        Integer rs = ps.executeUpdate();
        if(rs>0){
        	 DBHelp.close(conn,ps,null);
    		return true;
    	}else{
    		return false;
    	}
        /*Admin admin = null;
        while (rs.next()){
            admin = new Admin(rs.getString("username"),rs.getString("password"),rs.getString("role"));
        }
       DBHelp.close(conn,ps,rs);*/
        
    }
}

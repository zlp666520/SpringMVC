package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Info {

    private String no;
    private String date;
    private String name;
    private String sex;
    private Integer age;
    private String bodyInfo;
    private String totals;

    public Info() {
    }

    public Info(String no, String date, String name, String sex, Integer age) {
        this.no = no;
        this.date = date;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getTotals() {
		return totals;
	}

	public void setTotals(String totals) {
		this.totals = totals;
	}

	public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    
    public String getBodyInfo() {
		return bodyInfo;
	}

	public void setBodyInfo(String bodyInfo) {
		this.bodyInfo = bodyInfo;
	}

	
	public Info(String no, String date, String name, String sex, Integer age, String bodyInfo) {
		super();
		this.no = no;
		this.date = date;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.bodyInfo = bodyInfo;
	}

	//list
    public List<Info> list() throws SQLException, ClassNotFoundException {
        Connection conn = DBHelp.getConnection();
        String sql = "select * from info";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Info> infos = new ArrayList<>();
        while (rs.next()){
            Info info = new Info();
            info.setNo(rs.getString(1));
            info.setDate(rs.getString(2));
            info.setName(rs.getString(3));
            info.setSex(rs.getString(4));
            info.setAge(rs.getInt(5));
            infos.add(info);
        }
        DBHelp.close(conn,ps,rs);
        return infos;
    }

    public void add() throws SQLException, ClassNotFoundException {
        Connection conn = DBHelp.getConnection();
        String sql = "insert into info(no,date,name,sex,age) values(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,no);
        ps.setObject(2,date);
        ps.setObject(3,name);
        ps.setObject(4,sex);
        ps.setObject(5,age);
        ps.executeUpdate();
        DBHelp.close(conn,ps,null);
    }
    public void addInfo(Info info) throws SQLException, ClassNotFoundException {
        Connection conn = DBHelp.getConnection();
        String sql = "insert into info(no,date,name,sex,age) values(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,info.getNo());
        ps.setObject(2,info.getDate());
        ps.setObject(3,info.getName());
        ps.setObject(4,info.getSex());
        ps.setObject(5,info.getAge());
        ps.executeUpdate();
        DBHelp.close(conn,ps,null);
    }
    public void delete() throws SQLException, ClassNotFoundException {
        Connection conn = DBHelp.getConnection();
        String sql = "delete from info where no = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,no);
        ps.executeUpdate();
        DBHelp.close(conn,ps,null);
    }
    public void deleteByNo(String no) throws SQLException, ClassNotFoundException {
        Connection conn = DBHelp.getConnection();
        String sql = "delete from info where no = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1,no);
        ps.executeUpdate();
        DBHelp.close(conn,ps,null);
    }

    public Info findById(String no) throws SQLException, ClassNotFoundException {
        Connection con = DBHelp.getConnection();
        String sql = "select * from info where no = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1,no);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Info info = new Info();
            info.setNo(rs.getString(1));
            info.setDate(rs.getString(2));
            info.setName(rs.getString(3));
            info.setSex(rs.getString(4));
            info.setAge(rs.getInt(5));
            return info;
        }
        DBHelp.close(con,ps,null);
        return null;
    }

    public void update(Info info) throws SQLException, ClassNotFoundException {
    	System.out.println(info.getNo()+"dsadsa");
        Connection con = DBHelp.getConnection();
        String sql = "update info set date = ?, name = ?, sex = ?, age = ? where no = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setObject(1,info.getDate());
        ps.setObject(2,info.getName());
        ps.setObject(3,info.getSex());
        ps.setObject(4,info.getAge());
        ps.setObject(5,info.getNo());
        ps.executeUpdate();
        DBHelp.close(con,ps,null);
    }

//inner query
public ArrayList<Map> queryBySex(String sex) throws ClassNotFoundException,SQLException{
		Connection con = DBHelp.getConnection();
		Statement st = con.createStatement();
		String sql="select no,health.date,name,sex,age,health.body_info bodyInfo from info,health"+" where info.no=health.info_no ";
		String sexAB="";
		if(sex!=null&&sex!=""){
		if(sex.equals("A")){ sexAB="男";}else {sexAB="女";}
		 sql+=" and sex='"+sexAB+"'";
		 }
		System.out.println("通过sex查询"+sql);
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		ArrayList<Map> list = new ArrayList<Map>();
		while(rs.next()){//
			Map map=new HashMap();
			map.put("no",rs.getString(1));
			map.put("date",rs.getString(2));
			map.put("name",rs.getString(3));
			map.put("sex",rs.getString(4));
			map.put("age",rs.getString(5));
			map.put("bodyInfo",rs.getString(6));
			list.add(map);
		}
		DBHelp.close(con, ps, rs);
		return list;
}
public ArrayList<Info> queryBySexList(String sex) throws ClassNotFoundException,SQLException{
	Connection con = DBHelp.getConnection();
	Statement st = con.createStatement();
	String sql="select no,health.date,name,sex,age,health.body_info bodyInfo from info,health"+" where info.no=health.info_no ";
	String sexAB="";
	if(sex!=null&&sex!=""){
	if(sex.equals("A")){ sexAB="男";}else {sexAB="女";}
	 sql+=" and sex='"+sexAB+"'";
	 }
	System.out.println("通过sex查询"+sql);
	PreparedStatement ps = con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	ArrayList<Info> infos = new ArrayList<>();
    while (rs.next()){
        Info info = new Info();
        info.setNo(rs.getString(1));
        info.setDate(rs.getString(2));
        info.setName(rs.getString(3));
        info.setSex(rs.getString(4));
        info.setAge(rs.getInt(5));
        info.setBodyInfo(rs.getString(6));
        infos.add(info);
    }
	DBHelp.close(con,null, rs);
	return infos;
}
//combination query
public ArrayList<Map> queryByNoName(String no,String name) throws ClassNotFoundException,SQLException{
	Connection con = DBHelp.getConnection();
	String sql="select no,health.date,name,sex,age,health.body_info bodyInfo from info,health"+
			 " where info.no=health.info_no ";
	if(no!=null&&no!="") sql=sql+" and no='"+no+"'";
	if(name!=null&&name!="") sql=sql+" and name like '%"+name+"%'";
	System.out.println("通过no和name查询"+sql);
	Statement st = con.createStatement();
	ResultSet rs=st.executeQuery(sql);
	ArrayList<Map> list = new ArrayList<Map>();
	while(rs.next()){
		Map map=new HashMap();
		map.put("no",rs.getString(1));
		map.put("date",rs.getString(2));
		map.put("name",rs.getString(3));
		map.put("sex",rs.getString(4));
		map.put("age",rs.getString(5));
		map.put("bodyInfo",rs.getString(6));
		list.add(map);
	}
	DBHelp.close(con,null, rs);
	return list;
}

public ArrayList<Info> queryByNoNameList(String no,String name) throws ClassNotFoundException,SQLException{
	Connection con = DBHelp.getConnection();
	String sql="select no,health.date,name,sex,age,health.body_info bodyInfo from info,health"+
			 " where info.no=health.info_no ";
	if(no!=null&&no!="") sql=sql+" and no='"+no+"'";
	if(name!=null&&name!="") sql=sql+" and name like '%"+name+"%'";
	System.out.println("通过no和name查询"+sql);
	Statement st = con.createStatement();
	ResultSet rs=st.executeQuery(sql);
	ArrayList<Info> infos = new ArrayList<>();
      while (rs.next()){
          Info info = new Info();
          info.setNo(rs.getString(1));
          info.setDate(rs.getString(2));
          info.setName(rs.getString(3));
          info.setSex(rs.getString(4));
          info.setAge(rs.getInt(5));
          info.setBodyInfo(rs.getString(6));
          infos.add(info);
      }
	DBHelp.close(con,null, rs);
	return infos;
}
//static query
public ArrayList<Map> queryByStatic() throws ClassNotFoundException,SQLException{
	Connection con = DBHelp.getConnection();
	Statement st = con.createStatement();
	String sql="select health.date,sex,count(*) from info,health"+
				" where info.no=health.info_no "+
				" group by health.date,sex";

	System.out.println("通过date和date分组查询"+sql);
	ResultSet rs=st.executeQuery(sql);
	ArrayList<Map> list = new ArrayList<Map>();
	while(rs.next()){
		Map map=new HashMap();
		map.put("date",rs.getString(1));
		map.put("sex",rs.getString(2));
		map.put("totals",rs.getString(3));
		list.add(map);
	}
	DBHelp.close(con,null, rs);
	return list;
}
public ArrayList<Info> queryByStaticList() throws ClassNotFoundException,SQLException{
	Connection con = DBHelp.getConnection();
	Statement st = con.createStatement();
	String sql="select health.date,sex,count(*) from info,health"+
				" where info.no=health.info_no "+
				" group by health.date,sex";

	System.out.println("通过date和date分组查询"+sql);
	ResultSet rs=st.executeQuery(sql);
	ArrayList<Info> infos = new ArrayList<>();
    while (rs.next()){
        Info info = new Info();
        info.setDate(rs.getString(1));
        info.setSex(rs.getString(2));
        info.setTotals(rs.getString(3));
        infos.add(info);
    }
	DBHelp.close(con,null, rs);
	return infos;
}


//总记录数
public static int getTotalRow() throws ClassNotFoundException, SQLException{
	Connection con=DBHelp.getConnection();
	String sql="select * from info order by no";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	int rowcount=0;
	while(rs.next())
		rowcount++;
	return rowcount;
}
    //获取某一页的数据
    public static ArrayList<Info> listByPage(int pageNo,int pageSize) throws ClassNotFoundException, SQLException{
    Connection con=DBHelp.getConnection();
	String sql="select * from info order by no";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	int start=(pageNo-1)*pageSize+1;//要取的记录的开始位置
	rs.absolute(start);//定位到开始位置
	ArrayList<Info> list=new ArrayList<Info>();
	int i=0; //控制读取几条记录
	do{
		Info info=new Info();
		info.setNo(rs.getString(1));
		info.setDate(rs.getString(2));
		info.setName(rs.getString(3));
		info.setSex(rs.getString(4));
		info.setAge(rs.getInt(5));
		list.add(info);
		i++;
	}while(rs.next()&&i<pageSize);
	DBHelp.close(con, ps, rs);
	return list;
		
	}
	

	
}




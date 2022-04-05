package gui;

import java.sql.*;

public class Example02 {
	private String name;
	private String student_number;
	private String sex;
	private String birthday;
	private String address;
	private String phone;
	private String password;
	
	public Example02(){
		
	}
	
	public Example02(String name,String student_number,String sex,
			String birthday,String address,String phone,String password){
		this.name = name;
		this.student_number =student_number;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.password=password;
	}
	
	public void JDBCshooter() throws SQLException{//main(String[] args) static
		Connection conn = null;
		PreparedStatement preStmt = null;
		try {
			//注册数据库的驱动
			Class.forName("com.mysql.jdbc.Driver");
			//通过DriverManager连接数据库
			String url = "jdbc:mysql://localhost:3306/shooter";
			String username = "root";
			String password = "zzh1998";
			conn = DriverManager.getConnection(url, username, password);
			//创建想要执行的SQL语句
			//UserData userData = new UserData();
			String sql = "INSERT INTO users(name,student_number,sex,birthday,address,phone,password)"
					+"VALUES(?,?,?,?,?,?,?)";
			//创建执行SQL语句的PreparedStatement对象
			preStmt = conn.prepareStatement(sql);
			//为SQL语句赋值
			
			 preStmt.setString(1, name);//"home"userData.getName()
			 preStmt.setString(2, student_number);//"201701081002"userData.getStudent_number()
			 preStmt.setString(3, sex);//"男"userData.getSex()
			 preStmt.setString(4, birthday);//"1998-11-12"userData.getBirthday()
			 preStmt.setString(5, address);//"中国四川"userData.getAddress()
			 preStmt.setString(6, phone);//"15984429665"userData.getPhone()
			 preStmt.setString(7, this.password);//"zzh123"userData.getPassword()
			 
			
			//执行SQL
			preStmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally{
			if(preStmt != null){
				try{
					preStmt.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
				preStmt = null;
			}
			if(conn != null){
				try{
					conn.close();
				} catch(SQLException e){
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
}

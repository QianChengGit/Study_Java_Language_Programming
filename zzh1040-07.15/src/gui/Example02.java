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
			//ע�����ݿ������
			Class.forName("com.mysql.jdbc.Driver");
			//ͨ��DriverManager�������ݿ�
			String url = "jdbc:mysql://localhost:3306/shooter";
			String username = "root";
			String password = "zzh1998";
			conn = DriverManager.getConnection(url, username, password);
			//������Ҫִ�е�SQL���
			//UserData userData = new UserData();
			String sql = "INSERT INTO users(name,student_number,sex,birthday,address,phone,password)"
					+"VALUES(?,?,?,?,?,?,?)";
			//����ִ��SQL����PreparedStatement����
			preStmt = conn.prepareStatement(sql);
			//ΪSQL��丳ֵ
			
			 preStmt.setString(1, name);//"home"userData.getName()
			 preStmt.setString(2, student_number);//"201701081002"userData.getStudent_number()
			 preStmt.setString(3, sex);//"��"userData.getSex()
			 preStmt.setString(4, birthday);//"1998-11-12"userData.getBirthday()
			 preStmt.setString(5, address);//"�й��Ĵ�"userData.getAddress()
			 preStmt.setString(6, phone);//"15984429665"userData.getPhone()
			 preStmt.setString(7, this.password);//"zzh123"userData.getPassword()
			 
			
			//ִ��SQL
			preStmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
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

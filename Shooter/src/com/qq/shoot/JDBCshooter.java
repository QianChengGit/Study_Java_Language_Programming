package com.qq.shoot;

import java.sql.*;


public class JDBCshooter {
	public  void JdbcShooter() throws SQLException{// main(String[] args)static
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
			String sql = "INSERT INTO users(name,student_number,sex,birthday,address,phone,password)"
					+"VALUES(?,?,?,?,?,?,?)";
			preStmt = conn.prepareStatement(sql);
			//ΪSQL��丳ֵ
			UserData userData = new UserData();
			preStmt.setString(1, userData.getName());//"home"
			preStmt.setString(2, userData.getStudent_number());//"201701081002"
			preStmt.setString(3, userData.getSex());//"��"
			preStmt.setString(4, userData.getBirthday());//"1998-11-12"
			preStmt.setString(5, userData.getAddress());//"�й��Ĵ�"
			preStmt.setString(6, userData.getPhone());//"15984429665"
			preStmt.setString(7, userData.getPassword());//"zzh123"
			//ִ��SQL
			preStmt.executeUpdate(sql);
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

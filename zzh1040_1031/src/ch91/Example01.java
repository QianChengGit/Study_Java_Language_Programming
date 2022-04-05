package ch91;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 1.ע�����ݿ�����
 * 2.ͨ��DriverManager��ȡ���ݿ����ӡ�
 * 3.ͨ��Connection�����ȡStatement����
 * 4.ʹ��Statementִ��SQL���
 * 5.����ResultSet�����
 * 6.�������ݿ���Դ
 */
public class Example01 {
	private static int numberId;
	private static String name;
	private static String password;
	private static String email;
	private static String birthday;
	public static void main(String[] args) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try{
			//1.ע�����ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			//2.ͨ��DriverManager��ȡ���ݿ����ӡ�
			String url = "jdbc:mysql://localhost:3306/test";
			String username = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, username, password);
			//3.ͨ��Connection�����ȡStatement����
			stmt = conn.createStatement();
			//4.ʹ��Statementִ��SQL���
			String sql = "select * from student";
			rs = stmt.executeQuery(sql);
			//5.����ResultSet�����
			Scanner sc = new Scanner(System.in);
			System.out.println("  id \t        name \t password \t email \t birthday");
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String psw = rs.getString("password");
				String email = rs.getString("email");
				Date birthday = rs.getDate("birthday");
				System.out.println(id+"\t"+name+"\t  "+psw+"\t "+email+"\t "+birthday);
			}
			/*
			 * sql = "update student set name = 'tom' where id=20171002";
			stmt.execute(sql);
			 */
			System.out.println("������Ҫ��ӵ�id:");
			numberId = sc.nextInt();
			System.out.println("������Ҫ��ӵ�name:");
			name = sc.next();
			System.out.println("������Ҫ��ӵ�password:");
			password = sc.next();
			System.out.println("������Ҫ��ӵ�email:");
			email= sc.next();
			System.out.println("������Ҫ��ӵ�birthday:");
			birthday= sc.next();
			sql = "INSERT INTO student(id,name,password,email,birthday)"
					+ "VALUES(numberId,name,password,email,birthday)";
			stmt.execute(sql);
			 
			
			System.out.println("��������Ҫɾ����¼��id��");
			numberId = sc.nextInt();
			sql = "DELETE FROM student WHERE id="+numberId;
			stmt.execute(sql);
			
			
			System.out.println("ɾ����Ľ��Ϊ��");
			sql = "select * from student";
			stmt.execute(sql);
			rs = stmt.executeQuery(sql);
			System.out.println("  id \t        name \t password \t email \t birthday");
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String psw = rs.getString("password");
				String email = rs.getString("email");
				Date birthday = rs.getDate("birthday");
				System.out.println(id+"\t"+name+"\t  "+psw+"\t "+email+"\t "+birthday);
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			//6.�������ݿ���Դ
			if(rs != null){
				try{
					rs.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				rs = null;
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				stmt = null;
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
}

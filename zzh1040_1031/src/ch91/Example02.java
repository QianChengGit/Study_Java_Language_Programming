package ch91;
import java.sql.*;
public class Example02 {
	public static void main(String[] args) throws SQLException{
		Connection conn = null;
		PreparedStatement preStmt = null;
		try{
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/test";
			String username="root";
			String password="root";
			//创建应用程序与数据库连接Connection对象
			conn= DriverManager.getConnection(url, username, password);
			//执行SQL语句
			String sql = "INSERT INTO student(id,name,password,email,birthday)"
					+"VALUES(?,?,?,?,?)";
			//1、创建执行SQL语句的preparedStatement对象
			preStmt= conn.prepareStatement(sql);
			//2、为SQL语句中参数赋值
			preStmt.setString(1, "20171008");
			preStmt.setString(2, "zl");
			preStmt.setString(3, "123456");
			preStmt.setString(4, "zl@sina.com");
			preStmt.setString(5, "1789-12-23");
			//3、执行SQL
			preStmt.executeUpdate();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			if(preStmt != null){
				try{
					preStmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
				preStmt = null;
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

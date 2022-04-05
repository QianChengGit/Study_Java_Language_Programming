package cn.itcast.jdbc.example;
import java.sql.*;
public class Example03 {
	public static void main(String[] args) {
		Connection conn= null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");//注册数据库驱动
			String url = "jdbc:mysql://localhost:3306/jdbc";//数据库的地址
			String username = "root";//登录数据库的用户名
			String password = "zzh1998";//登录数据库的密码
			//获取Connection对象
			conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from users";
			//创建Statement对象并设置常量
			Statement st = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,//表示结果集可滚动
					ResultSet.CONCUR_READ_ONLY);//表示以只读形式打开结果集
			//执行SQL并将获取的数据信息存放在ResultSet中
			ResultSet rs = st.executeQuery(sql);
			//取出ResultSet中指定数据信息
			System.out.print("第2条数据的name为：");
			rs.absolute(2);//将指针定位到结果集中第2行数据
			System.out.println(rs.getString("name"));
			System.out.print("第1条数据的name为：");
			rs.beforeFirst();   //将指针定位到结果集中第1行数据之前
			rs.next();          //将指针向后滚动
			System.out.println(rs.getString("name"));
			System.out.print("第3条数据的name为：");
			rs.afterLast();     //将指针定位到结果集中第3行数据之后
			rs.previous();      //将指针向前滚动
			System.out.println(rs.getString("name"));
		}catch(Exception e){
			e.printStackTrace();
		} finally {            //释放资源
			if(stmt != null){
				try{
					stmt.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
				stmt = null;
			}
			if(conn != null){
				try{
					conn.close();
				} catch (SQLException e){
					e.printStackTrace();
				}
				conn = null;
			}
		}
	}
}

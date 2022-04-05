package studentManagement_Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import studentManagement_Data.Data;
import studentManagement_Tool.JDBCUtils;

public class AdministratorDao {
	//获取所有数据
	public ArrayList<Data> queryAllData(String personnel){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Data> list = new ArrayList<Data>();
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT * FROM "+personnel;
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Data teacherData = new Data();
				teacherData.setStudentNumber(rs.getString("StudentNumber"));
				teacherData.setPassword(rs.getString("Password"));
				teacherData.setName(rs.getString("Name"));
				teacherData.setSex(rs.getString("Sex"));
				teacherData.setCollege(rs.getString("College"));
				teacherData.setMajor(rs.getString("Major"));
				teacherData.setStudentClass(rs.getString("StudentClass"));
				list.add(teacherData);	
			}
			//return list;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return list;
	}
	//添加数据
	public void addTeacher(Data teacherData,String table){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "INSERT INTO "+table+"(StudentNumber,Password,Name,Sex,College,Major,StudentClass)"
					+"VALUES('"+teacherData.getStudentNumber()+"','"
					+teacherData.getPassword()+"','"+teacherData.getName()+"','"+teacherData.getSex()
					+"','"+teacherData.getCollege()+"','"+teacherData.getMajor()
					+"','"+teacherData.getStudentClass()+"')";
			int num = stmt.executeUpdate(sql);
			if(num>0){
				System.out.println("插入数据成功！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
	}
	//添加成绩
		public void addScores(Data teacherData,String table){
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try{
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				String sql = "INSERT INTO "+table+"(StudentNumber,Name,Java,MySQL,Andriod,Web,English)"
						+"VALUES('"+teacherData.getStudentNumber()+"','"
						+teacherData.getPassword()+"','"+teacherData.getName()+"','"+teacherData.getSex()
						+"','"+teacherData.getCollege()+"','"+teacherData.getMajor()
						+"','"+teacherData.getStudentClass()+"')";
				int num = stmt.executeUpdate(sql);
				if(num>0){
					System.out.println("插入数据成功！");
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCUtils.release(rs, stmt, conn);
			}
		}
	//删除数据
	public void delTeacher(String table,String delNumber){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "DELETE FROM "+table+" WHERE StudentNumber= '"+delNumber+"';";
			int num = stmt.executeUpdate(sql);
			if(num>0){
				System.out.println("删除数据成功！");
			}
		}catch(Exception e){
					e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
	}
	//更新数据
	public void updateTeacher(String table,String StudentNumber,String field,String content){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "Update "+table+" set "+field+"='"+content+"' WHERE StudentNumber= '"+StudentNumber+"'";
			stmt.executeUpdate(sql);
			System.out.println("更新数据成功！");

		}catch(Exception e){
					e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
	}
	//修改密码
		public void updatePassword(String table,String StudentNumber,String content){
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try{
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				String sql = "Update "+table+" set Password ='"+content+"' WHERE StudentNumber= '"+StudentNumber+"'";
				stmt.executeUpdate(sql);
				System.out.println("更新数据成功！");

			}catch(Exception e){
						e.printStackTrace();
			}finally{
				JDBCUtils.release(rs, stmt, conn);
			}
		}
	//登录查询数据
	public String SelectTeacher(String table,String StudentNumber,String user,String password){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String StudentN = null;
		String PSW = null;
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "SELECT "+user+","+password+" FROM "+table+" WHERE StudentNumber = '"+StudentNumber+"'";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Data teacherData = new Data();
				StudentN = rs.getString("StudentNumber");
				PSW = rs.getString("Password");
				teacherData.setStudentNumber(rs.getString("StudentNumber"));
				teacherData.setPassword(rs.getString("Password"));
				System.out.println(teacherData.getStudentNumber()+" "+teacherData.getPassword());
			}
			System.out.println("查询数据成功！");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return StudentN+PSW;
	}
	//获取课表所有数据
		public ArrayList<Data> queryclassscheduleData(String personnel){
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			ArrayList<Data> list = new ArrayList<Data>();
			try{
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				String sql = "SELECT * FROM "+personnel;
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					Data teacherData = new Data();
					teacherData.setStudentNumber(rs.getString("Time"));
					teacherData.setPassword(rs.getString("Monday"));
					teacherData.setName(rs.getString("Tuesday"));
					teacherData.setSex(rs.getString("Wednesday"));
					teacherData.setCollege(rs.getString("Thursday"));
					teacherData.setMajor(rs.getString("Friday"));
					teacherData.setStudentClass(rs.getString("Saturday"));
					teacherData.setState(rs.getString("Sunday"));
					list.add(teacherData);	
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCUtils.release(rs, stmt, conn);
			}
			return list;
		}
	
		//查询学生个人信息
		public ArrayList<Data> SelectStudent(String personnel,String StudentNumber){
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			ArrayList<Data> list = new ArrayList<Data>();
			try{
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				String sql = "SELECT * FROM "+personnel+" WHERE StudentNumber = '"+StudentNumber+"'";
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					Data teacherData = new Data();
					teacherData.setStudentNumber(rs.getString("StudentNumber"));
					teacherData.setPassword(rs.getString("Password"));
					teacherData.setName(rs.getString("Name"));
					teacherData.setSex(rs.getString("Sex"));
					teacherData.setCollege(rs.getString("College"));
					teacherData.setMajor(rs.getString("Major"));
					teacherData.setStudentClass(rs.getString("StudentClass"));
					list.add(teacherData);
				}
				System.out.println("查询数据成功！");
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCUtils.release(rs, stmt, conn);
			}
			return list;
		}
		//获取所有学生成绩
		public ArrayList<Data> queryStudentScores(String personnel){
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			ArrayList<Data> list = new ArrayList<Data>();
			try{
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				String sql = "SELECT * FROM "+personnel;
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					Data data = new Data();
					data.setStudentNumber(rs.getString("StudentNumber"));
					data.setPassword(rs.getString("Name"));
					data.setName(rs.getString("Java"));
					data.setSex(rs.getString("MySQL"));
					data.setCollege(rs.getString("Andriod"));
					data.setMajor(rs.getString("Web"));
					data.setStudentClass(rs.getString("English"));
					
					list.add(data);	
				}
				//return list;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCUtils.release(rs, stmt, conn);
			}
			return list;
		}
		
		//查询学生成绩
				public ArrayList<Data> SelectStudentScores(String personnel,String StudentNumber){
					Connection conn = null;
					Statement stmt = null;
					ResultSet rs = null;
					ArrayList<Data> list = new ArrayList<Data>();
					try{
						conn = JDBCUtils.getConnection();
						stmt = conn.createStatement();
						String sql = "SELECT * FROM "+personnel+" WHERE StudentNumber = '"+StudentNumber+"'";
						rs = stmt.executeQuery(sql);
						while(rs.next()){
							Data teacherData = new Data();
							teacherData.setStudentNumber(rs.getString("StudentNumber"));
							teacherData.setPassword(rs.getString("Name"));
							teacherData.setName(rs.getString("Java"));
							teacherData.setSex(rs.getString("MySQL"));
							teacherData.setCollege(rs.getString("Andriod"));
							teacherData.setMajor(rs.getString("Web"));
							teacherData.setStudentClass(rs.getString("English"));
							list.add(teacherData);
						}
						System.out.println("查询数据成功！");
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						JDBCUtils.release(rs, stmt, conn);
					}
					return list;
				}
//	public static void main(String[] args) {
//		AdministratorDao administratorDao = new AdministratorDao();
//		administratorDao.SelectTeacher("teacher","201701081002z","StudentNumber","Password");
//		administratorDao.updateTeacher("201701081001n", "Name", "哈哈哈");
//		administratorDao.delTeacher("201701081001n");
//	}
}

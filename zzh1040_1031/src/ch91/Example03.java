package ch91;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Example03 {
	public static void main(String[] args) {
		Connection conn= null;
		Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");//ע�����ݿ�����
			String url = "jdbc:mysql://localhost:3306/test";//���ݿ�ĵ�ַ
			String username = "root";//��¼���ݿ���û���
			String password = "root";//��¼���ݿ������
			//��ȡConnection����
			conn = DriverManager.getConnection(url, username, password);
			String sql = "select * from student";
			//����Statement�������ó���
			Statement st = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,//��ʾ������ɹ���
					ResultSet.CONCUR_READ_ONLY);//��ʾ��ֻ����ʽ�򿪽����
			//ִ��SQL������ȡ��������Ϣ�����ResultSet��
			ResultSet rs = st.executeQuery(sql);
			//ȡ��ResultSet��ָ��������Ϣ
			System.out.print("��2�����ݵ�nameΪ��");
			rs.absolute(2);//��ָ�붨λ��������е�2������
			System.out.println(rs.getString("name"));
			System.out.print("��1�����ݵ�nameΪ��");
			rs.beforeFirst();   //��ָ�붨λ��������е�1������֮ǰ
			rs.next();          //��ָ��������
			System.out.println(rs.getString("name"));
			System.out.print("��3�����ݵ�nameΪ��");
			rs.afterLast();     //��ָ�붨λ��������е�3������֮��
			rs.previous();      //��ָ����ǰ����
			System.out.println(rs.getString("name"));
		}catch(Exception e){
			e.printStackTrace();
		} finally {            //�ͷ���Դ
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

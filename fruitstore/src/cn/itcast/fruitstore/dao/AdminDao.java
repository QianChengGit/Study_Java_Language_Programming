package cn.itcast.fruitstore.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import cn.itcast.fruitstore.tools.JDBCUtils;
import cn.itcast.fruitstore.domain.FruitItem;
public class AdminDao {
	//��ȡ��������
		public ArrayList<FruitItem> queryAllData(){
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			ArrayList<FruitItem> list = new ArrayList<FruitItem>();
			try{
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				String sql = "SELECT * FROM fruit";
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					FruitItem fruitItem = new FruitItem();
					fruitItem.setNumber(rs.getString("number"));
					fruitItem.setName(rs.getString("fruitname"));
					fruitItem.setPrice(rs.getDouble("price"));
					fruitItem.setUnit(rs.getString("unit"));
					list.add(fruitItem);	
				}
				return list;
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCUtils.release(rs, stmt, conn);
			}
			return null;
		}
		//�������
		public void addFruitItem(FruitItem fruitItem){
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try{
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				String sql = "INSERT INTO fruit(number,fruitname,price,unit)"
						+"VALUES("+fruitItem.getNumber()+",'"
						+fruitItem.getName()+"','"+fruitItem.getPrice()
						+"','"+fruitItem.getUnit()+"')";
				int num = stmt.executeUpdate(sql);
				if(num>0){
					System.out.println("�������ݳɹ���");
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCUtils.release(rs, stmt, conn);
			}
		}
		//ɾ������
		public void delFruitItem(String delNumber){
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try{
				conn = JDBCUtils.getConnection();
				stmt = conn.createStatement();
				String sql = "DELETE FROM fruit WHERE number="+delNumber;
				int num = stmt.executeUpdate(sql);
				if(num>0){
					System.out.println("ɾ�����ݳɹ���");
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				JDBCUtils.release(rs, stmt, conn);
			}
		}
}

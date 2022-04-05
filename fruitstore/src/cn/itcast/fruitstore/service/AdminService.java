package cn.itcast.fruitstore.service;
import java.util.ArrayList;
import cn.itcast.fruitstore.dao.AdminDao;
import cn.itcast.fruitstore.domain.FruitItem;
public class AdminService {
	private AdminDao adminDao=new AdminDao();
	//查询服务
	public ArrayList<FruitItem> queryFruitItem(){
		//调用Dao层获取所有数据方法获取所有数据
		ArrayList<FruitItem> data=adminDao.queryAllData();
		return data;
	}
	//添加服务
	public boolean addFruitItem(String number,String name,String price,String unit){
		ArrayList<FruitItem> data=queryFruitItem();
		for(int i=0;i<data.size();i++){
			FruitItem fruitItem=data.get(i);
			if(number.equals(fruitItem.getNumber())){
				return false;
			}
		}
		FruitItem thisFruitItem=new FruitItem(number,name,Double.parseDouble(price),unit);
		adminDao.addFruitItem(thisFruitItem);
		return true;
	}
	//修改服务
	public boolean updateFruitItem(String number,String name,String price,String unit){
		ArrayList<FruitItem> data=queryFruitItem();
		for(int i=0;i<data.size();i++){
			FruitItem fruitItem=data.get(i);
			if(number.equals(fruitItem.getNumber())){
				adminDao.delFruitItem(number);
				FruitItem thisFruitItem=new FruitItem(number,name,Double.parseDouble(price),unit);
				adminDao.addFruitItem(thisFruitItem);
				return true;
			}
		}
		
		return false;
	}
	//删除服务
	public boolean delFruitItem(String delNumber){
		ArrayList<FruitItem> data=queryFruitItem();
		for(int i=0;i<data.size();i++){
			FruitItem fruitItem=data.get(i);
			if(delNumber.equals(fruitItem.getNumber())){
				adminDao.delFruitItem(delNumber);
				return true;
			}
		}
		return false;
	}
}

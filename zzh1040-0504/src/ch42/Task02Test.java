package ch42;

abstract class Transportation{
	private String number;
	private String model;
	private String admin;
	public Transportation(){
		super();
	}
	public Transportation(String number,String model,String admin){
		this.number=number;
		this.model=model;
		this.admin=admin;
	}
	//运输方法
	public abstract void transport();
	//编号
	public void setNumber(String number){
		this.number=number;
	}
	public String getNumber(){
		return number;
	}
	//型号
	public void setModel(String model){
		this.model=model;
	}
	public String getModel(){
		return model;
	}
	//负责人
	public void setAdmin(String admin){
		this.admin=admin;
	}
	public String getAdmin(){
		return admin;
	}
}
/*
 * 定义保养接口，具备保养功能
 */
interface Careable{
	public abstract void upkeep();//保养方法
}

class ZTransportation extends Transportation implements Careable{
	//无参构造
	public ZTransportation(){
		super();
	}
	//有参构造：车辆编号，型号，负责人
	public ZTransportation(String number,String model,String admin){
		super(number,model,admin);
	}
	//运输方法
	public void transport(){
		System.out.println("运输进行中。。。");
	}
	//重写车辆保养方法
	public void upkeep(){
		System.out.println("货物运输车辆保养完毕！");
	}
}


class SendTask{
	private String number;//快递单号
	private double goodsWeight;//货物重量
	public SendTask(){
		super();//可省略
	}
	public SendTask(String number,double goodsWeight){
		this.number=number;
		this.goodsWeight=goodsWeight;
	}
	//送前准备
	public void sendBefore(){
		System.out.println("订单开始处理，仓库验货中。。。");
		System.out.println("货物重量："+this.getGoodsWeight()+"kg");
		System.out.println("货物检验完毕！");
		System.out.println("货物填装完毕！");
		System.out.println("运货人已通知！");
		System.out.println("快递单号："+this.getNumber());
	}
	//发送货物
	public void send(Transportation t,GPS tool){
		System.out.println("运货人"+t.getAdmin()+"正在驾驶编号为"+t.getNumber()+"的"+t.getModel()+"发送货物！");
		t.transport();
		String showCoordinate=tool.showCoordinate();
		System.out.println("货物当前的坐标为："+showCoordinate);
	}
	
	//送后操作
	public void sendAfter(Transportation t){
		System.out.println("货物运输任务已完成！");
		System.out.println("运货人"+t.getAdmin()+"所驾驶的编号为"+t.getNumber()+"的"+t.getModel()+"已归还！");
	}
	public String getNumber(){
		return number;
	}
	public void setNumber(String number){
		this.number=number;
	}
	public double getGoodsWeight(){
		return goodsWeight;
	}
	public void setGoodsWeight(double goodsWeight){
		this.goodsWeight=goodsWeight;
	}
}

interface GPS{
	public String showCoordinate();
}


class Phone implements GPS{
	public Phone(){
		super();
	}
	public String showCoordinate(){
		String location="193,485";
		return location;
	}
}


public class Task02Test {
	public static void main(String[] args) {
		SendTask task=new SendTask("HYX600235",76.34);
		task.sendBefore();
		System.out.println("===========================");
		ZTransportation t=new ZTransportation("z025","大奔","小韩");
		Phone p=new Phone();
		task.send(t,p);
		System.out.println("===========================");
		task.sendAfter(t);
		t.upkeep();
	}
}

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
	//���䷽��
	public abstract void transport();
	//���
	public void setNumber(String number){
		this.number=number;
	}
	public String getNumber(){
		return number;
	}
	//�ͺ�
	public void setModel(String model){
		this.model=model;
	}
	public String getModel(){
		return model;
	}
	//������
	public void setAdmin(String admin){
		this.admin=admin;
	}
	public String getAdmin(){
		return admin;
	}
}
/*
 * ���屣���ӿڣ��߱���������
 */
interface Careable{
	public abstract void upkeep();//��������
}

class ZTransportation extends Transportation implements Careable{
	//�޲ι���
	public ZTransportation(){
		super();
	}
	//�вι��죺������ţ��ͺţ�������
	public ZTransportation(String number,String model,String admin){
		super(number,model,admin);
	}
	//���䷽��
	public void transport(){
		System.out.println("��������С�����");
	}
	//��д������������
	public void upkeep(){
		System.out.println("�������䳵��������ϣ�");
	}
}


class SendTask{
	private String number;//��ݵ���
	private double goodsWeight;//��������
	public SendTask(){
		super();//��ʡ��
	}
	public SendTask(String number,double goodsWeight){
		this.number=number;
		this.goodsWeight=goodsWeight;
	}
	//��ǰ׼��
	public void sendBefore(){
		System.out.println("������ʼ�����ֿ�����С�����");
		System.out.println("����������"+this.getGoodsWeight()+"kg");
		System.out.println("���������ϣ�");
		System.out.println("������װ��ϣ�");
		System.out.println("�˻�����֪ͨ��");
		System.out.println("��ݵ��ţ�"+this.getNumber());
	}
	//���ͻ���
	public void send(Transportation t,GPS tool){
		System.out.println("�˻���"+t.getAdmin()+"���ڼ�ʻ���Ϊ"+t.getNumber()+"��"+t.getModel()+"���ͻ��");
		t.transport();
		String showCoordinate=tool.showCoordinate();
		System.out.println("���ﵱǰ������Ϊ��"+showCoordinate);
	}
	
	//�ͺ����
	public void sendAfter(Transportation t){
		System.out.println("����������������ɣ�");
		System.out.println("�˻���"+t.getAdmin()+"����ʻ�ı��Ϊ"+t.getNumber()+"��"+t.getModel()+"�ѹ黹��");
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
		ZTransportation t=new ZTransportation("z025","��","С��");
		Phone p=new Phone();
		task.send(t,p);
		System.out.println("===========================");
		task.sendAfter(t);
		t.upkeep();
	}
}

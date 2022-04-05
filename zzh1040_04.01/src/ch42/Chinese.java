package ch42;
public class Chinese extends Person{
	public Chinese(){
		super("中国");
	}
	public Chinese(String name){
		System.out.println("省份："+name);
	}
	public Chinese(String name,String ID,String sex){
		super(name,ID,sex);
		//super("张三","201701081010","男");
	}
//	public Chinese(String name,String ID,String sex){
//		System.out.println("姓名："+name+"\n学号："+ID+"\n性别："+sex);
//	}
	
}
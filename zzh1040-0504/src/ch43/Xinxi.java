package ch43;
class Person {
	private String name;
	private String ID;
	private String sex;
	private String Gj;
	public Person(){
		
	}
	public Person(String gj){
		this.Gj=gj;
		System.out.println("国籍："+Gj);
	}
	public Person(String name,String ID,String sex){
		this.name=name;
		this.ID=ID;
		this.sex=sex;
		System.out.println("姓名："+name+"\n学号："+ID+"\n性别："+sex);
	}
}

class Chinese extends Person{
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
}	
class Americans  extends Person{
	public Americans(){
		super("美国人");
	}
	public Americans(String name,String ID,String sex){
		super(name,ID,sex);
		//super("Amiy","201701081010","女");
	}
}
	
class SiChuan extends Chinese{
	public SiChuan(String name){
		super(name);
		//	super("四川人");
		//	super("张三","201701081010","男");
		}

	public SiChuan(){
		//	super("四川人");
			super("张三","201701081010","男");
		}
}
public class Xinxi {
	public static void main(String[] args){
		Chinese chinese=new Chinese();
		SiChuan sichuan=new SiChuan("四川");
		SiChuan sichuan1=new SiChuan();
		
		Americans americans=new Americans();
		Americans americans1=new Americans("Amiy","201701081011","女");
	}
}

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
		System.out.println("������"+Gj);
	}
	public Person(String name,String ID,String sex){
		this.name=name;
		this.ID=ID;
		this.sex=sex;
		System.out.println("������"+name+"\nѧ�ţ�"+ID+"\n�Ա�"+sex);
	}
}

class Chinese extends Person{
	public Chinese(){
		super("�й�");
	}
	public Chinese(String name){
		System.out.println("ʡ�ݣ�"+name);
	}
	public Chinese(String name,String ID,String sex){
		super(name,ID,sex);
		//super("����","201701081010","��");
	}
}	
class Americans  extends Person{
	public Americans(){
		super("������");
	}
	public Americans(String name,String ID,String sex){
		super(name,ID,sex);
		//super("Amiy","201701081010","Ů");
	}
}
	
class SiChuan extends Chinese{
	public SiChuan(String name){
		super(name);
		//	super("�Ĵ���");
		//	super("����","201701081010","��");
		}

	public SiChuan(){
		//	super("�Ĵ���");
			super("����","201701081010","��");
		}
}
public class Xinxi {
	public static void main(String[] args){
		Chinese chinese=new Chinese();
		SiChuan sichuan=new SiChuan("�Ĵ�");
		SiChuan sichuan1=new SiChuan();
		
		Americans americans=new Americans();
		Americans americans1=new Americans("Amiy","201701081011","Ů");
	}
}

package ch42;
public class Chinese extends Person{
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
//	public Chinese(String name,String ID,String sex){
//		System.out.println("������"+name+"\nѧ�ţ�"+ID+"\n�Ա�"+sex);
//	}
	
}
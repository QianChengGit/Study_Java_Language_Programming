package ch26;

public class Student {
	
	private String stuID;//˽��
	public String stuName;//����
	private char stuSex;
	int stuE,stuM,stuC;
	
	public Student(String id,String name){
		this.stuID=id;
		this.stuName=name;
	}
	
	public Student(String id,String name,char sex,int e,int m,int c){
		this.stuID=id;
		this.stuName=name;
		this.stuSex=sex;
		this.stuC=c;
		this.stuM=m;
		this.stuE=e;
		
	}
	public void setStuID(String ID){
		stuID=ID;
	}
	public void setStuName(String name){
		stuName=name;
	}
	public void setSex(char sex){
		stuSex=sex;
	}
	
	public void showStu(){
		System.out.println("ѧ��������"+stuName+" ѧ�ţ�"+stuID+"  �Ա�"+stuSex+"   Ӣ��ɼ���"+stuE+"  ��ѧ�ɼ���"+stuM+"  c���Գɼ���"+stuC);
	}
	
	
}

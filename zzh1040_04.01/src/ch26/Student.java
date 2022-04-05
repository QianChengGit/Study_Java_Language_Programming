package ch26;

public class Student {
	
	private String stuID;//私有
	public String stuName;//公有
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
		System.out.println("学生姓名："+stuName+" 学号："+stuID+"  性别："+stuSex+"   英语成绩："+stuE+"  数学成绩："+stuM+"  c语言成绩："+stuC);
	}
	
	
}

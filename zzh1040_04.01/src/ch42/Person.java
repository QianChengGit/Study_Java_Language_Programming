package ch42;

public class Person {
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
/*
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getID(){
		return ID;
	}
	public void setID(String ID){
		this.ID=ID;
	}
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex=sex;
	}*/
}

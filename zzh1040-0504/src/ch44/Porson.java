package ch44;

public class Porson extends Exception{
	private String name;
	private String sex;
	private String year;
	public Porson(){
		super();
	}
	public Porson(String message){
		super(message);
	}
	public Porson(String name,String sex,String year){
		this.name=name;
		this.sex=sex;
		this.year=year;
		System.out.println("姓名："+name);
		System.out.println("性别："+sex);
		System.out.println("年龄："+year);
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public String getSex(){
		return sex;
	}
	public void setYear(String year){
		this.year=year;
	}
	public String getYear(){
		return year;
	}
}


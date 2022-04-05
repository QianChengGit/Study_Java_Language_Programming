package task2;

import java.util.HashMap;
import java.util.Scanner;

class StudentInformation{
	
	private String studentName;
	private String studentNumber;
	private String studentMajor;
	private String studentClass;
	private String studentSex;
	private String studentPhone;
	private String studentDormitory;
	
	public StudentInformation() {
		
	}
	public StudentInformation(String studentNumber,String studentName,String studentSex,String studentMajor,
			String studentClass,String studentPhone,String studentDormitory) {
		this.studentName = studentName;
		this.studentNumber =studentNumber;
		this.studentMajor = studentMajor;
		this.studentClass = studentClass;
		this.studentPhone = studentPhone;
		this.studentDormitory = studentDormitory;
		this.studentSex = studentSex;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	
	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}
	public String getStudentSex() {
		return studentSex;
	}
	
	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}
	public String getStudentMajor() {
		return studentMajor;
	}
	
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getStudentClass() {
		return studentClass;
	}
	
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	
	public void setStudentDormitory(String studentDormitory) {
		this.studentDormitory = studentDormitory;
	}
	public String getStudentDormitory() {
		return studentDormitory;
	}
	
	public String outInformation(){
		
		return "姓名："+studentName+"\n学号："+studentNumber+"\n性别："+studentSex+"\n专业："+studentMajor+"\n班级："+studentClass+"\n手机号："+studentPhone+"\n寝室号："+studentDormitory;
	}
}

public class Student {
	public static void main(String[] args) {
		String i;
		Scanner scan = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<String, String>();
		do{
			System.out.println("请输入学号：");
			String studentNumber = scan.nextLine();
			System.out.println("请输入姓名：");
			String studentName = scan.nextLine();
			System.out.println("请输入性别：");
			String studentSex = scan.nextLine();
			System.out.println("请输入专业：");
			String studentMajor = scan.nextLine();
			System.out.println("请输入班级：");
			String studentClass = scan.nextLine();
			System.out.println("请输入电话：");
			String studentPhone = scan.nextLine();
			System.out.println("请输入寝室号：");
			String studentDormitory = scan.nextLine();
			StudentInformation student = new StudentInformation(studentNumber,studentName,studentSex,studentMajor,studentClass,studentPhone,studentDormitory);
			map.put(studentNumber, student.outInformation());
			System.out.println("如果继续请输入1，结束请输入2：");
			i = scan.nextLine();
		}while(i.equals("1"));
		do{
		System.out.print("请输入您想查询的学生学号：");
		String number = scan.nextLine();
		System.out.println(map.get(number));
		System.out.println("是否继续查找，如果继续请输入1，结束请输入2：");
		i = scan.nextLine();
		}while(i.equals("1"));
	}
}

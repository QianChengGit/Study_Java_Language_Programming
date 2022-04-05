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
		
		return "������"+studentName+"\nѧ�ţ�"+studentNumber+"\n�Ա�"+studentSex+"\nרҵ��"+studentMajor+"\n�༶��"+studentClass+"\n�ֻ��ţ�"+studentPhone+"\n���Һţ�"+studentDormitory;
	}
}

public class Student {
	public static void main(String[] args) {
		String i;
		Scanner scan = new Scanner(System.in);
		HashMap<String, String> map = new HashMap<String, String>();
		do{
			System.out.println("������ѧ�ţ�");
			String studentNumber = scan.nextLine();
			System.out.println("������������");
			String studentName = scan.nextLine();
			System.out.println("�������Ա�");
			String studentSex = scan.nextLine();
			System.out.println("������רҵ��");
			String studentMajor = scan.nextLine();
			System.out.println("������༶��");
			String studentClass = scan.nextLine();
			System.out.println("������绰��");
			String studentPhone = scan.nextLine();
			System.out.println("���������Һţ�");
			String studentDormitory = scan.nextLine();
			StudentInformation student = new StudentInformation(studentNumber,studentName,studentSex,studentMajor,studentClass,studentPhone,studentDormitory);
			map.put(studentNumber, student.outInformation());
			System.out.println("�������������1������������2��");
			i = scan.nextLine();
		}while(i.equals("1"));
		do{
		System.out.print("�����������ѯ��ѧ��ѧ�ţ�");
		String number = scan.nextLine();
		System.out.println(map.get(number));
		System.out.println("�Ƿ�������ң��������������1������������2��");
		i = scan.nextLine();
		}while(i.equals("1"));
	}
}

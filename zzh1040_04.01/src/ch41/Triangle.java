package ch41;
import java.util.Scanner;
public class Triangle extends Shape{
	public void out(){
		System.out.println("��״��"+name);
	}
	public void circularTriangle(){
		//double p;
		//double s;
		int a,b,c;
		Scanner s = new Scanner(System.in);
		try {
		System.out.print("�����������ε�1���߳�(�س�����):");
		a = s.nextInt(); 
		System.out.print("�����������ε�2���߳�(�س�����):"); 
		b = s.nextInt(); 
		System.out.print("�����������ε�3���߳�(�س�����):"); 
		c = s.nextInt(); 
		} 
		catch (Exception ex) { 
		System.out.println("����Ĳ�������"); 
		return; 
		} 
		if (a + b > c && b + c > a && a + c > b) { 
		System.out.println("���Թ���������");
		double d = (a + b + c) / 2; 
		double e = Math.sqrt(d * (d - a) * (d - b) * (d - c)); 
		System.out.println("���Ϊ:" + e); 
		}
		else { System.out.println("�����Թ���������!"); 
		System.out.println(s);
		}
	}
}

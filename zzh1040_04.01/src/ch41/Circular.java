package ch41;
import java.util.Scanner;
public class Circular extends Shape{
	public void out(){
		System.out.println("��״��"+name);
	}
	public void circularArea(){
		int a;
		double z;
		Scanner s = new Scanner(System.in);
		System.out.print("������Բ�ΰ뾶(�س�����):");
		a = s.nextInt();
		z=3.14*a*a;
		System.out.println(z);
		
	}
}

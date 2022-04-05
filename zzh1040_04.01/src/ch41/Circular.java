package ch41;
import java.util.Scanner;
public class Circular extends Shape{
	public void out(){
		System.out.println("形状："+name);
	}
	public void circularArea(){
		int a;
		double z;
		Scanner s = new Scanner(System.in);
		System.out.print("请输入圆形半径(回车继续):");
		a = s.nextInt();
		z=3.14*a*a;
		System.out.println(z);
		
	}
}

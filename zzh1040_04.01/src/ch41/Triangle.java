package ch41;
import java.util.Scanner;
public class Triangle extends Shape{
	public void out(){
		System.out.println("形状："+name);
	}
	public void circularTriangle(){
		//double p;
		//double s;
		int a,b,c;
		Scanner s = new Scanner(System.in);
		try {
		System.out.print("请输入三角形第1个边长(回车继续):");
		a = s.nextInt(); 
		System.out.print("请输入三角形第2个边长(回车继续):"); 
		b = s.nextInt(); 
		System.out.print("请输入三角形第3个边长(回车继续):"); 
		c = s.nextInt(); 
		} 
		catch (Exception ex) { 
		System.out.println("输入的不是数字"); 
		return; 
		} 
		if (a + b > c && b + c > a && a + c > b) { 
		System.out.println("可以构成三角形");
		double d = (a + b + c) / 2; 
		double e = Math.sqrt(d * (d - a) * (d - b) * (d - c)); 
		System.out.println("面积为:" + e); 
		}
		else { System.out.println("不可以构成三角形!"); 
		System.out.println(s);
		}
	}
}

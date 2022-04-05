package ch26;
import java.util.Random;
import java.util.Scanner;
public class File28 {
	public static void main(String[] args) {
		int randomNumber = new Random() .nextInt(101);
		System.out.println("随机数已生成！");
		System.out.println("----请输入您猜的数字:----");
		Scanner sc=new Scanner (System.in);
		int enterNumber = sc.nextInt();
		while (enterNumber != randomNumber){
			if(enterNumber>randomNumber){
				System.out.println("sorry ,您猜大了！");
			}
			else{
				System.out.println("soeey,您猜小了！");
			}
			System.out.println("----请输入您猜的数字:----");
			enterNumber = sc.nextInt();
		}
		System.out.println("恭喜您，答对了!");
	}
}

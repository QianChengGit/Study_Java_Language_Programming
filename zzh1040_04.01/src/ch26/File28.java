package ch26;
import java.util.Random;
import java.util.Scanner;
public class File28 {
	public static void main(String[] args) {
		int randomNumber = new Random() .nextInt(101);
		System.out.println("����������ɣ�");
		System.out.println("----���������µ�����:----");
		Scanner sc=new Scanner (System.in);
		int enterNumber = sc.nextInt();
		while (enterNumber != randomNumber){
			if(enterNumber>randomNumber){
				System.out.println("sorry ,���´��ˣ�");
			}
			else{
				System.out.println("soeey,����С�ˣ�");
			}
			System.out.println("----���������µ�����:----");
			enterNumber = sc.nextInt();
		}
		System.out.println("��ϲ���������!");
	}
}

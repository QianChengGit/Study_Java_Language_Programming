package ch26;

import java.util.Scanner;

public class File29 {
	public static void main(String[] args) {
		System.out.println("��������ݣ�");
		int y=getScanner();
		System.out.println("�������·ݣ�");
		int m=getScanner();
		System.out.println("���������ڣ�");
		int d=getScanner();
		YearMonthDay day=new YearMonthDay(y,m,d);
		System.out.println("���������ǣ�"+day.getYear()+"��"+day.getMonth()+"��"+day.getDay()+"��");
		day.isExits();
		System.out.println("��"+day.totleDays()+"��");
		}
		public static int getScanner(){
		Scanner sc= new Scanner(System.in);
		return sc.nextInt();
		}
}
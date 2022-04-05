package ch26;

import java.util.Scanner;

public class File29 {
	public static void main(String[] args) {
		System.out.println("请输入年份：");
		int y=getScanner();
		System.out.println("请输入月份：");
		int m=getScanner();
		System.out.println("请输入日期：");
		int d=getScanner();
		YearMonthDay day=new YearMonthDay(y,m,d);
		System.out.println("输入日期是："+day.getYear()+"年"+day.getMonth()+"月"+day.getDay()+"日");
		day.isExits();
		System.out.println("第"+day.totleDays()+"天");
		}
		public static int getScanner(){
		Scanner sc= new Scanner(System.in);
		return sc.nextInt();
		}
}
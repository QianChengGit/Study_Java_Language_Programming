package leaner;

import java.util.Scanner;

public class Main17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a= sc.nextInt();
		int sum = f(a);
		System.out.println(sum%10007);
	}
	public static int f(int a){
		if(a == 1 || a == 2) return 1;
		return f(a-1)+f(a-2);
	}

}

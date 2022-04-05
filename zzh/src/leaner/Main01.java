package leaner;

import java.util.Scanner;

public class Main01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		double n;
		double PI=3.14159265358979323;
		n = PI*r*r;
		String s = new String().format("%.7f", n);
		System.out.println(s);
	}

}

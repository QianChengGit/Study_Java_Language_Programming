package leaner;

import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) {
		long n,sum=0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		m(n);

	}
	public static void m(long n) {
		long sum = 0;
		if(n%2 == 0){
			sum = n*((int)n/2)+n/2;
		}else{
			sum = n*((n+1)/2);
		}
		System.out.println(sum);
	}

}

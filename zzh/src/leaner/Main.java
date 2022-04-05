package leaner;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] m=new int[1000000];
		m[0]=1;
		m[1]=1;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n>0){
			if(n<=2){
				System.out.println(1);
			}else{
				for(int i = 2;i<n;i++){
					m[i] = (m[i-1]+m[i-2])%10007;
				}
				System.out.println(m[n-1]);
			}
		}
	}
}

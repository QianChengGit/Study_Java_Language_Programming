package leaner;

import java.util.Scanner;

public class Main11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,a;
		n = sc.nextInt();
		int[] m = new int[n];
		for(int i = 0;i<n;i++){
			m[i] = sc.nextInt();
		}
		a = sc.nextInt();
		for(int i=0;i<n;i++){
			if(a == m[i]){
				System.out.println(i+1);
				break;
			}else if(i+1 == n){
				System.out.println(-1);
			}
		}
	}
	
}

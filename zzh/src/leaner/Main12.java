package leaner;

import java.util.Scanner;

public class Main12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int[] m = new int[n];
		for(int i = 0;i<n;i++){
			m[i] = sc.nextInt();
		}
		int max=m[0],min=m[0],sum=0;

		for(int i = 0;i<n;i++){
			if(max<m[i]){
				max = m[i];
			}
			if(min>m[i]){
				min = m[i];
			}
			sum = sum+m[i];
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(sum);
	}

}

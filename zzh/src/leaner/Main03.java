package leaner;

import java.util.Scanner;

public class Main03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,t=0;
		n = sc.nextInt();
		int[] m = new int[200];
		for(int i = 0;i<n;i++){
			m[i]=sc.nextInt();
		}
		for(int i = 0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				if(m[i]>m[j]){
					t=m[i];
					m[i]=m[j];
					m[j]=t;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.print(m[i]+" ");
		}
	}

}

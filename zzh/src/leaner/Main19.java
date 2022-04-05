package leaner;

import java.util.Scanner;

public class Main19 {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] m = new int[n];
		for(int i=0;i<n;i++){
			m[i] = sc.nextInt();
		}
		int s = 0;
		s = s(m,n,s);
		System.out.println(s);
		
	}
	public static int s(int[] m,int n,int s){
		int k=m[0];
		for(int i = 0;i<n;i++){
			if(i == n-1){
				m[i] = m[i]/2+k/2;
				if(m[i]%2!=0){
					m[i] = m[i]+1;
					s++;
				}
			}else{
				m[i] = m[i]/2+m[i+1]/2;
				if(m[i]%2!=0){
					m[i] = m[i]+1;
					s++;
				}
			}
		}
		for(int i = 0;i<n-1;i++){
			if(m[i]!= m[i+1]){
				s=s(m,n,s);
			}
		}
		return s;
	}
}

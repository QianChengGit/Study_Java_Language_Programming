package leaner;

import java.util.Scanner;

public class Main16 {

	public static void main(String[] args) {
		int n,m,ans=0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] A = new int[n][m];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				A[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0;i<n-1;i++){
			int s=0;
			it:for(int j = 0;j<m;j++){
				if(A[i][j]!=A[i+1][j]){
					s++;
				}else{
					break it;
				}
				if(s == m){
					ans++;
				}
			}
		}
		System.out.println(ans);
	}

}

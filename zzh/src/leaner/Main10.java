package leaner;

import java.util.Scanner;

public class Main10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		int[][] m = new int[n][n];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<i+1;j++){
				if(j == 0 || j == i){
					m[i][j] = 1;
					System.out.print(m[i][j]+" ");
				}else{
					m[i][j] = m[i-1][j-1]+m[i-1][j];
					System.out.print(m[i][j]+" ");
				}
				
			}
			System.out.println();			
		}
	}

}

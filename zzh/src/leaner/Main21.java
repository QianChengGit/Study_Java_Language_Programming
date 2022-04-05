package leaner;

import java.util.Scanner;

public class Main21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] s = new int[n][m];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				s[i][j] = sc.nextInt();
			}
		}
		int max=0,b=0;
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				for(int x = i;i<n;i++){
					for(int y = j;j<m;j++){
						b+=s[x][y];
					}
				}
				if(max<b){
					max = b;
				}
				b=0;
			}
		}
			System.out.println(max);
//		for(int i = 0;i<n;i++){
//			for(int j = 0;j<m;j++){
//				System.out.print(s[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}

}

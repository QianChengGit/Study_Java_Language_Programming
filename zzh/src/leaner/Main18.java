package leaner;
/*
 * 1<=n,m<=26
 */
import java.util.Scanner;

public class Main18 {
static int askii = 65;
		static int askiii;
		static int q = 0;
		static int w = 0;
	public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);

			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] a = new char[n][m];

//			for (int i = 0; i < n; i++) {
//				for (int j = i; j < m; j++) {
//					a[i][j] = (char) (askii + q);
//					q++;
//				}
//				for (int k = i; k >= 0; k--) {
//					a[i][k] = (char) (askii + w);
//					w++;
//				}
//				q = 0;
//				w = 0;
//			}
			
			if(n <= m){
				for(int i = 0;i < n;i ++){
					for(int j = i ;j < m ;j ++){
						a[i][j] = (char) (askii + q);
						q++;
					}
					q = 0;
					for(int k = i;k >= 0;k --){
						a[i][k] = (char) (askii + w);
						w++;
					}
					w = 0;
				}
			}else{
				for(int i = 0;i < m;i ++){
					for(int j = i;j < n;j ++){
						a[j][i] = (char)(askii+q);
						q ++;
					}
					q = 0;
					for(int k = i;k >= 0;k --){
						a[k][i] = (char)(askii+w);
						w++;
					}
					w = 0;
				}
				
				
			}
			

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
	}

}

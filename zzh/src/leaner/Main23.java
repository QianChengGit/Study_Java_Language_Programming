package leaner;

import java.util.Scanner;
/*
 * 线段覆盖
 * 
 * 小A闲来无事，想在一块很长的木板上涂色。每次，他会选取木板上的一段，然后给它涂上颜色。涂上了新的颜色，是会覆盖旧颜色的。

他会涂到他累了为止，但是他也就最多涂100次。

请问，在木板上的x位置是什么颜色？


第一行是两个数字n和m，表示木板长度（n<=100000），和他涂色的次数（m<=100）

接下来n行，每行是三个数字l，r，c表示他涂的位置的左端和右端，以及颜色。（1<=l<=r<=n,1<=c<=20）

接下来一行是数字x，表示询问的位置。


输出一行，包含一个数，表示颜色。如果没涂色，输出0。
 */
public class Main23 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m,s=0;
		n=sc.nextInt();
		m=sc.nextInt();
		int[][] a = new int[m][3];
		for(int i=0;i<m;i++){
			for(int j=0;j<3;j++){
				a[i][j] = sc.nextInt();
			}
		}
		int x=sc.nextInt();
		
		for(int i=0;i<m;i++){
			for(int j=0;j<3;j++){
				if(a[i][0]<=x && a[i][1]>=x){
					s=a[i][2];
				}
			}
		}
		System.out.println(s);

	}

}

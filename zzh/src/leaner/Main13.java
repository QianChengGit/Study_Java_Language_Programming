package leaner;
/*
 * 1<=n,m<=26
 */
import java.util.Scanner;

public class Main13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m,a;
		char c;
		char[] s = new char[26];
		n = sc.nextInt();
		m = sc.nextInt();
		for(int i = 0;i<26;i++){
			c =(char) (65+i);
			s[i] = c;
		}
		for(int i = 0;i<n;i++){
			a = 0;
			it:for(int k = i;k>0;k--){
				System.out.print(s[k]);
				a++;
				if(a == m){
					break it;
				}		
			}
			for(int j = 0;j<m-i;j++){
				System.out.print(s[j]);
			}
			System.out.print("\n");
		}
	}
}

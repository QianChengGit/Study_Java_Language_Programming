import java.util.Scanner;
import java.util.Scanner;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		kind(n,m);
		
	}

	public static void kind(int n,int m){
		int blue = 0;
		int write = 0;
			for(int i=n;i<=m;i++){
				if(i%2 == 0){
					write++;
				}else{
					blue++;
				}
			}
		System.out.println("第"+n+"行到第"+m+"行共有"+blue+"行蓝色");
	}
}

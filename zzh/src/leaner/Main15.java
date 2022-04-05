package leaner;
/*
 * ÅĞ¶ÏÈòÄê
 */
import java.util.Scanner;

public class Main15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		if(n%4 == 0 && n%100!=0 || n%400 == 0){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}

	}

}

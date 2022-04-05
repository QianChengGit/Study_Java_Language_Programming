package leaner;

import java.util.Scanner;

public class Main07 {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int a,b,c,d,e,f,g;
		for(int i = 10000;i<1000000;i++){			
			if(i>=10000 && i<=99999){
				a = i%10;
				b = (i/10)%10;
				c = (i/100)%10;
				d = (i/1000)%10;
				e = (i/10000)%10;
				g = a+b+c+d+e;
				if(a == e && b == d){
					if(n == g){
						System.out.println(i);
					}
				}
			}
			else{
				a = i%10;
				b = (i/10)%10;
				c = (i/100)%10;
				d = (i/1000)%10;
				e = (i/10000)%10;
				f = (i/100000)%10;
				g = a+b+c+d+e+f;
				if(a == f && b == e && c == d){
					if(n == g){
						System.out.println(i);
					}
				}
			}			
		}
	}

}

package leaner;

public class Main06 {

	public static void main(String[] args) {
		
		for(int i = 1000;i<10000;i++){
			int a,b,c,d;
			a = i%10;
			b = (i/10)%10;
			c = (i/100)%10;
			d = (i/1000)%10;
			if(a == d && b == c){
				System.out.println(i);
			}
		}
	}

}

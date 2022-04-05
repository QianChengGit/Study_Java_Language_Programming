package leaner;

public class Main05 {

	public static void main(String[] args) {
		
		for(int i=100;i<1000;i++){
			int n,m,h;
			n = i%10;//取个位上的数
			m = (i/10)%10;//取十位上的数
			h = (i/100)%10;//取百位上的数
			if(i == n*n*n+m*m*m+h*h*h){
				System.out.println(i);
			}
		}

	}

}

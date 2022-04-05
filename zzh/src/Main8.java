import java.util.Scanner;
public class Main8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [][] A;
		int b,c,d=0,e,x,y;
		int a1 = 0,a2 = 0,b1 = 0,b2 = 0,sum = 0;
		b=sc.nextInt();
		x=sc.nextInt();
		y=sc.nextInt();
		e=b-1;
		c=10000/b;
		A=new int[c][b];
		for(int i=0;i<c;i++){
			for(int j=0;j<b;j++){
				d++;
				if(i%2!=0){
					A[i][e]=d;
					e--;
					if(e == -1){
						e=b-1;
					}
				}else{
					A[i][j]=d;
				}
				
			}
		}
		
		for(int i=0;i<c;i++){
			for(int j=0;j<b;j++){
				if(A[i][j]==x){
					a1=i;
					b1=j;
				}else if(A[i][j]==y){
					a2=i;
					b2=j;
				}
			}
		}	
		sum=Math.abs(a2-a1)+Math.abs(b2-b1);
		System.out.println(sum);
	}

}

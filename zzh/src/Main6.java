
public class Main6 {
	public static void main(String[] args) {
		int a,b,c,d,e,f,g,h,i,j,sum1=0,sum2=0;
		for(int x=50;x<=99;x++){
			sum1=x*x;
			sum2=x*x*x;
			a=sum1/1000%10;
			b=sum1/100%10;
			c=sum1/10%10;
			d=sum1%10;
			e=sum2/100000%10;
			f=sum2/10000%10;
			g=sum2/1000%10;
			h=sum2/100%10;
			i=sum2/10%10;
			j=sum2%10;
			int[] C={a,b,c,d,e,f,g,h,i,j};
			if(bubbleSort(C)==1){
				System.out.println(x+"   "+sum1+"   "+sum2);
			}
		}
	}
	public static int bubbleSort(int[] C){
		for(int i=0;i<C.length-1;i++){
			for(int j=i+1;j<C.length;j++){
				if(C[i]==C[j]){
					return 0;
				}
			}
		}
		return 1;
	}
}

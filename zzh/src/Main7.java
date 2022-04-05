
public class Main7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum=0,n=0,m=0;
		int [] N=new int[49];
		for(int i=0;i<49;i++){
			N[i]=i+1;
		}
		
		for(int i=1;i<50;i++){
			sum=sum+i;
		}
		for(int i=1;i<46;i++){
			for(int j=3;j<48;j++){
				n=N[i]*N[i+1];
				m=N[j]*N[j+1];
				sum=sum-(N[i]+N[i+1]+N[j]+N[j+1])+n+m;
				if(sum==2015){
					System.out.print(N[i]+" "+N[j]);
					System.out.println("");
				}else{
					sum=1225;
				}
			}
		}
	}

}

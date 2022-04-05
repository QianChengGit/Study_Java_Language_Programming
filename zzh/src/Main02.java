import java.math.BigInteger;


public class Main02 {
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			
			int x=10000;
			int count=0;
		
		for(int i=1;i<x;i++){
			BigInteger  big=new BigInteger(Integer.toString(i));
			BigInteger  f=big.pow(3);
			String st1=big.toString();
			String st2=f.toString();
					
			if(st2.substring(st2.length()-st1.length(), st2.length()).equals(st1)){
				count++;
				System.out.println(i);
			}
			
		}
		System.out.println(count);
		
		}
	 
}

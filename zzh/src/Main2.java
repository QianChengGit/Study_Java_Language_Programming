import java.math.BigInteger;


public class Main2 {
	public static void main(String[] args) {
		sum();
	}
	public static void sum(){
		 
		int sum=0,a;
		String n,m;
		for(int i=1;i<=10000;i++){
			a =i*i*i;
			n = String.valueOf(i);//将数字转换为子字符串
			m = String.valueOf(a);//将数字立方转换为字符串
			if(m.endsWith(n)){//m.endsWith(n)判断m字符串是否以子字符串n结束
				System.out.println(i);
				sum++;
			}
		}
		
		System.out.println(sum);
	}
}

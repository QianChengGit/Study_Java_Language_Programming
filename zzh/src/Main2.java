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
			n = String.valueOf(i);//������ת��Ϊ���ַ���
			m = String.valueOf(a);//����������ת��Ϊ�ַ���
			if(m.endsWith(n)){//m.endsWith(n)�ж�m�ַ����Ƿ������ַ���n����
				System.out.println(i);
				sum++;
			}
		}
		
		System.out.println(sum);
	}
}

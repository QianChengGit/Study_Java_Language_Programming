package leaner;

public class Main05 {

	public static void main(String[] args) {
		
		for(int i=100;i<1000;i++){
			int n,m,h;
			n = i%10;//ȡ��λ�ϵ���
			m = (i/10)%10;//ȡʮλ�ϵ���
			h = (i/100)%10;//ȡ��λ�ϵ���
			if(i == n*n*n+m*m*m+h*h*h){
				System.out.println(i);
			}
		}

	}

}

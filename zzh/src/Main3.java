import java.util.Scanner;


public class Main3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		double n = 0,a;
		Scanner sc = new Scanner(System.in);
		System.out.println("���������Ĳ�����");
		a = sc.nextInt();
		n = a+2;
		for(double i = a;i>=1;i--){
			n = i+(i+1)/n;
		}
		System.out.println("���Ϊ��"+String.format("%.5f", 1/n));//n
	}

}

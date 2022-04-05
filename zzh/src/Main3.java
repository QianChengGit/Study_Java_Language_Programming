import java.util.Scanner;


public class Main3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		double n = 0,a;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入计算的层数：");
		a = sc.nextInt();
		n = a+2;
		for(double i = a;i>=1;i--){
			n = i+(i+1)/n;
		}
		System.out.println("结果为："+String.format("%.5f", 1/n));//n
	}

}

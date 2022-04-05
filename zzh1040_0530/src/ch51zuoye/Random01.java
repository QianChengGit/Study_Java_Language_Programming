package ch51zuoye;
import java.util.Random;
public class Random01 {

	public static void main(String[] args) {
		Random r=new Random();
		for(int x=0;x<10;x++){
			System.out.println(r.nextInt(100));
		}

		System.out.println();
		
		
		Random r1=new Random(13);
		for(int x=0;x<10;x++){
			System.out.println(r1.nextInt(100));
		}
		
		
		System.out.println();
		
		
		Random r2=new Random();
		System.out.println("产生float类型随机数："+r2.nextFloat());
		System.out.println("产生0~100之间int类型的随机数："+r2.nextInt(100));
		System.out.println("产生double类型的随机数："+r2.nextDouble());
	}

}

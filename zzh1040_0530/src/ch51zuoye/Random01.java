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
		System.out.println("����float�����������"+r2.nextFloat());
		System.out.println("����0~100֮��int���͵��������"+r2.nextInt(100));
		System.out.println("����double���͵��������"+r2.nextDouble());
	}

}

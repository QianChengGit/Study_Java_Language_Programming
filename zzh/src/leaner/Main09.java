package leaner;
/*
 * 十六进制转换十进制
 */
import java.util.Scanner;

public class Main09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String tr = sc.next();
		if(tr.length()>2){
			if(tr.substring(0, 2).equals("ox") || tr.substring(0, 2).equals("0x")
				|| tr.substring(0, 2).equals("oX")|| tr.substring(0, 2).equals("0X")
				|| tr.substring(0, 2).equals("Ox")|| tr.substring(0, 2).equals("OX")){
		
				System.out.println(Long.parseLong(tr.substring(2), 16));
			}else{
				System.out.println(Long.parseLong(tr, 16));
			}
		}else{
			System.out.println(Long.parseLong(tr, 16));
		}
	}

}

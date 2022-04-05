package ch51zuoye;

public class Package {

	public static void main(String[] args) {
		int a=20;
		Integer in=new Integer(a);
		System.out.println(in.toString());
		
		System.out.println();
		
		Integer num=new Integer(20);
		int b=10;
		int sum=num.intValue()+b;
		System.out.println("sum="+sum);
		
		
		System.out.println();
		
		
		int w=Integer.parseInt("20");
		int h=Integer.parseInt("10");
		for(int i=0;i<h;i++){
			StringBuffer sb=new StringBuffer();
			for(int j=0;j<w;j++){
				sb.append("*");
			}
			System.out.println(sb.toString());
		}
	}

}

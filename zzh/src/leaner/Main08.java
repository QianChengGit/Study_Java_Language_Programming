package leaner;

import java.util.Scanner;

public class Main08 {

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int a;
//		a = sc.nextInt();
//		String b = Integer.toHexString(a);
//		System.out.println(b);
//	}
	
	 public static void main(String args[]){
	      Main08 t = new Main08();
	      Scanner sc = new Scanner(System.in);
			int n,d;
			d = sc.nextInt();
			n = sc.nextInt();
	      String a = t.t2(d,n);
	      System.out.println(a);
	   }
	   
	   
	   //把a转成指定进制
	   private String t2(int a,int n){
	      String str = "";
	      //1:用a去除以n，得到商和余数
	      int sun = a/n;
	      int yuShu = a%n;
	      str = ""+shuZhiToZhiMu(Integer.valueOf(String.valueOf(yuShu), 10));
	      while(sun > 0 ){
	         //2：继续用商去除以n，得到商和余数
	         yuShu = sun % n;
	         sun = sun / n;         
	         //3：如果商为0，那么就终止         
	         //4：把所有的余数倒序排列
	         str = shuZhiToZhiMu(Integer.valueOf(String.valueOf(yuShu), 10)) + str;
	      }
	    //  System.out.println(n+"进制==="+str);
	      return str;
	   }
	   //写一个方法实现：把一个十进制的数转换成为16进制的数
	   private String t1(long a){
	      String str = "";
	      //1:用a去除以16，得到商和余数
	      Long sun = a/(16L);
	      Long yuShu = a%16L;
	      str = ""+shuZhiToZhiMu(Integer.valueOf(String.valueOf(yuShu), 10));
	      while(sun > 0 ){
	         //2：继续用商去除以16，得到商和余数
	         yuShu = sun % 16;
	         sun = sun / 16;         
	         //3：如果商为0，那么就终止         
	         //4：把所有的余数倒序排列
	         str = shuZhiToZhiMu(Integer.valueOf(String.valueOf(yuShu), 10)) + str;
	      }
	     // System.out.println("16进制==="+str);
	      return str;
	   }
	   
	   private String shuZhiToZhiMu(int a){ 
	      switch(a){   //若jdk版本switch不支持String,可以将String转换为int类型后判断
	         case 10 :
	            return "A";
	         case 11 :
	           return "B";
	         case 12 :
	           return "C";
	         case 13 :
	           return "D";
	         case 14 :
	           return "E";    
	         case 15 :
	           return "F";  
	      }
	      return ""+a;
	   }

}

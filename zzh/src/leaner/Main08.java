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
	   
	   
	   //��aת��ָ������
	   private String t2(int a,int n){
	      String str = "";
	      //1:��aȥ����n���õ��̺�����
	      int sun = a/n;
	      int yuShu = a%n;
	      str = ""+shuZhiToZhiMu(Integer.valueOf(String.valueOf(yuShu), 10));
	      while(sun > 0 ){
	         //2����������ȥ����n���õ��̺�����
	         yuShu = sun % n;
	         sun = sun / n;         
	         //3�������Ϊ0����ô����ֹ         
	         //4�������е�������������
	         str = shuZhiToZhiMu(Integer.valueOf(String.valueOf(yuShu), 10)) + str;
	      }
	    //  System.out.println(n+"����==="+str);
	      return str;
	   }
	   //дһ������ʵ�֣���һ��ʮ���Ƶ���ת����Ϊ16���Ƶ���
	   private String t1(long a){
	      String str = "";
	      //1:��aȥ����16���õ��̺�����
	      Long sun = a/(16L);
	      Long yuShu = a%16L;
	      str = ""+shuZhiToZhiMu(Integer.valueOf(String.valueOf(yuShu), 10));
	      while(sun > 0 ){
	         //2����������ȥ����16���õ��̺�����
	         yuShu = sun % 16;
	         sun = sun / 16;         
	         //3�������Ϊ0����ô����ֹ         
	         //4�������е�������������
	         str = shuZhiToZhiMu(Integer.valueOf(String.valueOf(yuShu), 10)) + str;
	      }
	     // System.out.println("16����==="+str);
	      return str;
	   }
	   
	   private String shuZhiToZhiMu(int a){ 
	      switch(a){   //��jdk�汾switch��֧��String,���Խ�Stringת��Ϊint���ͺ��ж�
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

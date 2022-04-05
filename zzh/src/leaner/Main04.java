package leaner;

import java.util.Scanner;
/**
 * 十六进制转换八进制
 * @author Administrator
 *
 */
public class Main04 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		String [] result=new String[11];//保存最后输出的结果
		/*十六进制转化为二进制*/
		for(int i=0;i<n;i++){
			String h=in.next();
			StringBuilder tempB=new StringBuilder();
			for(int m=0;m<h.length();m++){
				char numH=h.charAt(m);
				String b=Integer.toBinaryString(Integer.valueOf(String.valueOf(numH), 16));	//先用Integer.valueOf(String.valueOf(numH), 16)将16进制转换为10进制，再用toBinaryString方法将10进制转化为2进制			
				for(int k=b.length();k<4;k++){
					b='0'+b;//在每四位二进制前面补充缺失的0
				}
				tempB.append(b);//将指定的字符串追加到此字符序列。
			}
		
	           
		/*二进制转化为八进制*/
			StringBuilder tempO=new StringBuilder();//长度变为3的倍数，需要补的前导0的个数
			int addZero=3-tempB.length()%3;
			for(int p=0;p<addZero;p++){
				tempB=new StringBuilder("0").append(tempB);
			}
			for(int m=0;m<tempB.length();m+=3){
		//把字符串长度转换为三的倍数添加前导0
				String numB=tempB.substring(m, m+3);
				String o=Integer.toOctalString(Integer.valueOf(String.valueOf(numB), 2));//先用Integer.valueOf(String.valueOf(numB), 2)将2进制转换为10进制，再用toOctalString方法将10进制转化为8进制
				tempO.append(o);
			}
			result[i]=tempO.toString().replaceAll("^(0+)", "");//用正则表达式去掉前导零
	    }
        for(int i=0;i<n;i++){
        	System.out.println(result[i]);
        }
	}
}

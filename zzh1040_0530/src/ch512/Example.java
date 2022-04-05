package ch512;

public class Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="abcde";
		System.out.println("将字符串转为字符数组后的结果：");
		char[] charArray=str.toCharArray();
		for(int i=0;i<charArray.length;i++){
			if(i!=charArray.length-1)
			System.out.print(charArray[i]+",");
			else
				System.out.println(charArray[i]);
		}
		System.out.println("将int值转换为String类型之后的结果："+String.valueOf(12));
		System.out.println("将字符串转换为大写之后的结果："+str.toUpperCase());

		
		System.out.println();
		
		
		String s="itcast";
		System.out.println("将it替换为cn.it的结果："+s.replaceAll("it","cn.it"));
		String s1="   i t  c a s t   ";
		System.out.println("去除字符串两端空格后的结果："+s1.trim());
		System.out.println("去除字符串中所有空格后的结果："+s1.replace(" ",""));
		
		
		
		System.out.println();
		
		
		
		
		String s3="String";
		String s4="Str";
		System.out.println("判断是否以字符串Str开头："+s3.startsWith("Str"));
		System.out.println("判断是否以字符串ng结尾："+s3.endsWith("ng"));
		System.out.println("判断是否包含字符串tri:"+s3.contains("tri"));
		System.out.println("判断字符串是否为空:"+s3.isEmpty());
		System.out.println("判断两个字符串是否相等:"+s3.equals(s4));
		
		
		
		System.out.println();
		
		
		
		
		String s5=new String("abc");
		String s6=new String("abc");
		System.out.println(s5==s6);
		System.out.println(s5.equals(s6));
		
		
		
		System.out.println();
		
		
		
		
		
		String str1="羽毛球-篮球-乒乓球";
		System.out.println("从第五个字符截取到末尾的结果："+str1.substring(4));
		System.out.println("从第5个字符截取到第6个字符的结果："+str1.substring(4,6));
		System.out.println("分割后的字符串数组中的元素依次为：");
		String[] strArray1=str1.split("-");
		for(int i=0;i<strArray1.length;i++){
			if(i!=strArray1.length-1){
				System.out.println(strArray1[i]+",");
			}
			else
			{
				System.out.println(strArray1[i]);
			}
		}
		
		
	}

}

package ch512;

public class Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="abcde";
		System.out.println("���ַ���תΪ�ַ������Ľ����");
		char[] charArray=str.toCharArray();
		for(int i=0;i<charArray.length;i++){
			if(i!=charArray.length-1)
			System.out.print(charArray[i]+",");
			else
				System.out.println(charArray[i]);
		}
		System.out.println("��intֵת��ΪString����֮��Ľ����"+String.valueOf(12));
		System.out.println("���ַ���ת��Ϊ��д֮��Ľ����"+str.toUpperCase());

		
		System.out.println();
		
		
		String s="itcast";
		System.out.println("��it�滻Ϊcn.it�Ľ����"+s.replaceAll("it","cn.it"));
		String s1="   i t  c a s t   ";
		System.out.println("ȥ���ַ������˿ո��Ľ����"+s1.trim());
		System.out.println("ȥ���ַ��������пո��Ľ����"+s1.replace(" ",""));
		
		
		
		System.out.println();
		
		
		
		
		String s3="String";
		String s4="Str";
		System.out.println("�ж��Ƿ����ַ���Str��ͷ��"+s3.startsWith("Str"));
		System.out.println("�ж��Ƿ����ַ���ng��β��"+s3.endsWith("ng"));
		System.out.println("�ж��Ƿ�����ַ���tri:"+s3.contains("tri"));
		System.out.println("�ж��ַ����Ƿ�Ϊ��:"+s3.isEmpty());
		System.out.println("�ж������ַ����Ƿ����:"+s3.equals(s4));
		
		
		
		System.out.println();
		
		
		
		
		String s5=new String("abc");
		String s6=new String("abc");
		System.out.println(s5==s6);
		System.out.println(s5.equals(s6));
		
		
		
		System.out.println();
		
		
		
		
		
		String str1="��ë��-����-ƹ����";
		System.out.println("�ӵ�����ַ���ȡ��ĩβ�Ľ����"+str1.substring(4));
		System.out.println("�ӵ�5���ַ���ȡ����6���ַ��Ľ����"+str1.substring(4,6));
		System.out.println("�ָ����ַ��������е�Ԫ������Ϊ��");
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

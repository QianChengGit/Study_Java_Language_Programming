package ch51;
import java.util.Scanner;
public class Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int j=-1;
		System.out.println("�����ַ�����");
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		System.out.println("�ָ����ַ��������е�Ԫ������Ϊ��");
		String[] strArray1=str.split("");
		for(int i=0;i<strArray1.length;i++){
			if(i!=strArray1.length-1){
				System.out.print(strArray1[i]+",");
			}
			else
			{
				System.out.println(strArray1[i]);
			}
			j++;
	}
		System.out.println("�ַ���Ԫ������Ϊ��"+j);
		
		
		//for(int i=0;i<strArray1.length;i++){
		//	System.out.println("���ָ�����"+str);
			
			
		}	
}


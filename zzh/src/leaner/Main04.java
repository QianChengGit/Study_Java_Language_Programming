package leaner;

import java.util.Scanner;
/**
 * ʮ������ת���˽���
 * @author Administrator
 *
 */
public class Main04 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		String [] result=new String[11];//�����������Ľ��
		/*ʮ������ת��Ϊ������*/
		for(int i=0;i<n;i++){
			String h=in.next();
			StringBuilder tempB=new StringBuilder();
			for(int m=0;m<h.length();m++){
				char numH=h.charAt(m);
				String b=Integer.toBinaryString(Integer.valueOf(String.valueOf(numH), 16));	//����Integer.valueOf(String.valueOf(numH), 16)��16����ת��Ϊ10���ƣ�����toBinaryString������10����ת��Ϊ2����			
				for(int k=b.length();k<4;k++){
					b='0'+b;//��ÿ��λ������ǰ�油��ȱʧ��0
				}
				tempB.append(b);//��ָ�����ַ���׷�ӵ����ַ����С�
			}
		
	           
		/*������ת��Ϊ�˽���*/
			StringBuilder tempO=new StringBuilder();//���ȱ�Ϊ3�ı�������Ҫ����ǰ��0�ĸ���
			int addZero=3-tempB.length()%3;
			for(int p=0;p<addZero;p++){
				tempB=new StringBuilder("0").append(tempB);
			}
			for(int m=0;m<tempB.length();m+=3){
		//���ַ�������ת��Ϊ���ı������ǰ��0
				String numB=tempB.substring(m, m+3);
				String o=Integer.toOctalString(Integer.valueOf(String.valueOf(numB), 2));//����Integer.valueOf(String.valueOf(numB), 2)��2����ת��Ϊ10���ƣ�����toOctalString������10����ת��Ϊ8����
				tempO.append(o);
			}
			result[i]=tempO.toString().replaceAll("^(0+)", "");//��������ʽȥ��ǰ����
	    }
        for(int i=0;i<n;i++){
        	System.out.println(result[i]);
        }
	}
}

package baidu;
import java.io.*;
public class Baidu1{
public static void main(String[] args) throws IOException {
	BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter buff = new BufferedWriter(new FileWriter("D:/ѧ����Ϣϵͳ.txt"));
	BufferedReader buf1 = new BufferedReader(new FileReader("D:/ѧ����Ϣϵͳ.txt"));
	FileReader fr=new FileReader("D:/ѧ����Ϣϵͳ.txt");
	System.out.println("===========================");
	System.out.println(" ѧ����Ϣϵͳ");
	System.out.println("===========================");
	System.out.println("===========================");
	System.out.println(" ������������ѧ�źͳɼ�:");
	System.out.println("===========================");
	System.out.println();
	String str = buf.readLine();//��ȡһ��
	while (!str.equals("")) {
		buff.write(str);//��strд�뵽������
		buff.newLine();//д�뻻�з�
		buff.flush();//���������ڵ�����д�뵽�ļ�
		str = buf.readLine();
	}
	System.out.println("===========================");
		buf.close();//�ر�
		buff.close();//�ر�
		System.out.println(" ѧ����Ϣ�ѴӼ���д���ļ�!");
		System.out.println("===========================");
//����������128���ַ�������
		char data[]=new char[128];
//�����ݶ����ַ�����������
		int num=fr.read(data);
//���ַ�����ת�����ַ���
		String str2=new String(data,0,num);
		System.out.println("===========================");
		System.out.println(" �ļ��е�ѧ����Ϣ:");
		System.out.println("===========================");
		System.out.println();
		System.out.println(str2);
		fr.close();//�ر�
		System.out.println("==========================="); System.out.println("ѧ����Ϣ�Ѵ��ļ�����������!");
		System.out.println("==========================="); System.out.println();
//����������100���ַ���������
		String[]s=new String[100];
//����������100��˫�����е�����
		Double[]score=new Double[100];
//�쳣�������
		try{
//���ַ������ж���
			for(int i=0;s[i]!="";i++)
			{
				s[i]=buf1.readLine();
				int num1=s[i].length();
//��ȡ�����λ�ַ�����Ϊ����,������һ��λ�����
				s[i]=s[i].substring(num1-3,num1);
//���ַ���ת����Double�ʹ���score����
				score[i]=Double.parseDouble(s[i]);
//��ӡÿλѧ���ĳɼ�
				System.out.println(" ��"+(i+1)+"��ѧ���ĳɼ�:"+score[i]);
			}
		}
//����NullPointerException�쳣
		catch(NullPointerException e)
		{
		}
		int k=0;//������־λ
		Double max=score[0];//��߷�
		Double min=score[0];//��ͷ�
		Double total=0.0;//�ܷ�
		Double average=0.0;//ƽ����
		System.out.println();
		System.out.println("==========================="); System.out.println(" ������");
		System.out.println("==========================="); System.out.println();
//�������
		for(int j=0;score[j]!=null;j++)
		{
			if(score[j]>max)
				max=score[j];
			if(score[j]<min)
				min=score[j];
			total=total+score[j];
			k=j+1;
		}
		average=total/k;
		System.out.println(" ��߷�Ϊ:"+max);
		System.out.println(" ��ͷ�Ϊ:"+min);
		System.out.println(" ƽ����Ϊ:"+average);
		System.out.println(" �ܷ�Ϊ:"+total);
		System.out.println();
		System.out.println("===========================");
		System.out.println(" �����Ѿ����!");
		System.out.println("===========================");
	}
}
package ch71;
import java.io.*;
public class Example04 {
	public static void main(String[] args) throws Exception{
		InputStream in=new FileInputStream("C:\\Users\\Public\\Music\\Sample Music\\Sleep Away.mp3");
		OutputStream out=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\target\\Sleep Away.mp3");
		int len;
		long begintime=System.currentTimeMillis();
		while((len=in.read())!=-1){
			out.write(len);
		}
		long endtime=System.currentTimeMillis();
		System.out.println("�����ļ������ĵ�ʱ���ǣ�"+(endtime-begintime)+"����");
		in.close();
		out.close();
	}
}

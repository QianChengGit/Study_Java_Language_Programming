package ch71;
import java.io.*;
public class Example05 {
	public static void main(String[] args) throws Exception{
		InputStream in=new FileInputStream("C:\\Users\\Public\\Music\\Sample Music\\Sleep Away.mp3");
		OutputStream out=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\target\\Sleep Away.mp3");
		byte [] buff=new byte[1024000];
		int len;
		long begintime=System.currentTimeMillis();
		while((len=in.read(buff))!=-1){
			out.write(buff,0,len);
		}
		long endtime=System.currentTimeMillis();
		System.out.println("拷贝文件所消耗的时间是："+(endtime-begintime)+"毫秒");
		in.close();
		out.close();
	}
}

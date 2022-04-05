package ch71;
import java.io.*;
public class Example06 {
	public static void main(String[] args) throws Exception{
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream("src.txt"));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("des.txt"));
		
		int len;
		
		while((len=bis.read())!=-1){
			bos.write(len);
		}
		bis.close();
		bos.close();
	}
}
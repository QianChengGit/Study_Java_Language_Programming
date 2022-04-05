package ch71;
import java.io.*;
public class Example07 {
	public static void main(String[] args) throws Exception{
		FileReader reader=new FileReader("des.txt");
		int ch;
		while((ch=reader.read())!=-1)
		{
			System.out.println((char) ch);
			
		}
		reader.close();
	}
}

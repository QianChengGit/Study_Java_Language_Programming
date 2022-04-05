package ch71;
import java.io.*;
public class Example02 {
	public static void main(String[] args) throws Exception{
		FileOutputStream out=new FileOutputStream("example.txt");
		String str="´«ÖÇ²¥¿Í";
		byte [] b=str.getBytes();
		for(int i=0;i<b.length;i++){
			out.write(b[i]);
		}
		out.close();
	}
}

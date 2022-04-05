package ch71;
import java.io.*;
public class Example08 {
	public static void main(String[] args) throws Exception{
		FileWriter writer=new FileWriter("writer.txt");
		String str="ÄãºÃ£¬´«ÖÇ²¥¿Í£¡";
		writer.write(str);
		writer.write("\r\n");
		writer.close();
	}
}

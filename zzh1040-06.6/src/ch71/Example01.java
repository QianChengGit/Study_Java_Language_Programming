package ch71;
import java.io.*;
public class Example01 {
	public static void main(String[] args) throws Exception{
		FileInputStream in=new FileInputStream("Kalimba.mp3");
		int b=0;
		while(true){
			b=in.read();
			if(b==-1){
				break;
			}
				System.out.println(b);
		}
		in.close();
	}
}

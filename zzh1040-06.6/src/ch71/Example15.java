package ch71;
import java.io.*;
public class Example15 {
	public static void main(String[] args) {
		File file=new File("C:\\Users\\Administrator\\Desktop\\zzh1040-06.6\\自建文件夹test");
		if(file.exists()){
			System.out.println(file.delete());
		}
	}
}

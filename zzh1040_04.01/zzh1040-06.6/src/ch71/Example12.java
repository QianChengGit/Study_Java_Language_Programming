package ch71;
import java.io.*; 
public class Example12 {
	public static void main(String[] args) throws Exception{
		File file=new File("C:\\Users\\Administrator\\Desktop\\zzh1040-06.6");
		if(file.isDirectory()){
			String [] names=file.list();
			for(String name:names){
				System.out.println(name);
			}
		}
	}
}

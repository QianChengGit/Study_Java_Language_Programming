package ch71;
import java.io.File;
public class Example14 {
	public static void main(String[] args) {
		File file=new File("C:\\Users\\Administrator\\Desktop\\zzh1040-06.6");
		fileDir(file);
	}
	public static void fileDir(File dir){
		File [] files=dir.listFiles();
		for(File file:files){
			if(file.isDirectory()){
				fileDir(file);
			}
			System.out.println(file.getAbsolutePath());
		}
	}
}

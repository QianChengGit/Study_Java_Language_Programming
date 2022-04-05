package ch71;
import java.io.*;
public class Example16 {
	public static void main(String[] args) {
		File file=new File("C:\\Users\\Administrator\\Desktop\\zzh1040-06.6\\自建文件夹test");
		deleteDir(file);
	}
	public static void deleteDir(File dir){
		if(dir.exists()){
			File [] files=dir.listFiles();
			for(File file :files){
				if(file.isDirectory()){
					deleteDir(file);
				}else{
					file.delete();
				}
			}
			dir.delete();
		}
	}
}

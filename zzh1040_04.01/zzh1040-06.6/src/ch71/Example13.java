package ch71;
import java.io.File;
import java.io.FilenameFilter;
public class Example13 {
	public static void main(String[] args) throws Exception{
		File file=new File("C:\\Users\\Administrator\\Desktop\\zzh1040-06.6");
		FilenameFilter filter=new FilenameFilter(){
			public boolean accept(File dir,String name){
				File currFile=new File(dir,name);
				if(currFile.isFile()&&name.endsWith(".txt")){
					return true;
				}else{
					return false;
				}
			}
		};
		if(file.exists()){
			String [] lists=file.list(filter);
			for(String name:lists){
				System.out.println(name);
			}
		}
	}
}

package ch71;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
public class DocumentManager {
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("--1: ָ���ؼ��ּ���   2��ָ�� ��׺�������ļ�"
				+"3�������ļ�/Ŀ¼    4���˳�--");
		while(true){
			System.out.println("������ָ�");
			int command=sc.nextInt();
			switch(command){
			case 1:
				searchByKeyWorld();
				break;
			case 2:
				searchBySuffix();
				break;
			case 3:
				copyDirectory();
				break;
			case 4:
				exit();
				break;
			default:
				System.out.println("�������ָ�����") ;
				break;
			}
		}
	}
	private static void searchByKeyWorld(){
		Scanner sc=new Scanner(System.in);
		System.out.println("������Ҫ������Ŀ¼λ�ã�");
		String path=sc.next();
		File file=new File(path);
		if(!file.exists()||!file.isDirectory()){
			System.out.println(path+" (������ЧĿ¼)");
			return;
		}
		System.out.println("�����������ؼ��֣�");
		String key=sc.next();
		ArrayList<String>list=FileUtils.listFiles(file,key);
		for(Object obj:list){
			System.out.println(obj);
		}
	}
	
	private static void searchBySuffix(){
		Scanner sc=new Scanner(System.in);
		System.out.println("������Ҫ������Ŀ¼λ�ã�");
		String path=sc.next();
		File file=new File(path);
		if(!file.exists()||!file.isDirectory()){
			System.out.println(path+" (������ЧĿ¼)");
			return;
		}
		System.out.println("������������׺��");
		String suffix=sc.next();
		String [] suffixArray=suffix.split(",");
		ArrayList<String>list=FileUtils.listFiles(file,suffixArray);
		for(Object obj:list){
			System.out.println(obj);
		}
	}
	
	private static void copyDirectory() throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("������ԴĿ¼��");
		String srcDirectory=sc.next();
		File srcFile=new File(srcDirectory);
		if(!srcFile.exists()||!srcFile.isDirectory()){
			System.out.println("��ЧĿ¼��");
			return;
		}
		System.out.println("������Ŀ��λ�ã�");
		String destDirectory=sc.next();
		File destFile=new File(destDirectory);
		if(!destFile.exists() || destFile.isDirectory()){
			System.out.println("��Чλ�ã�");
			return;
		}
		FileUtils.copySrcPathToDestPath(srcFile,destFile);
	}
	
	private static void exit(){
		System.out.println("�����˳�ϵͳ��ллʹ�ã�");
		System.exit(0);
	}
}

class FileUtils{
	public static ArrayList<String>listFiles(File file,final String key){
		FilenameFilter filter=new FilenameFilter(){
			public boolean accept(File dir,String name){
				File currFile=new File(dir,name);
				if(currFile.isFile() && name.contains(key)){
					return true;
				}
				return false;
			}
		};
		ArrayList<String>arraylist=fileDir(file,filter);
		return arraylist;
	}
	
	public static ArrayList<String>listFiles(File file,final String [] suffixArray){
		FilenameFilter filter=new FilenameFilter(){
			public boolean accept(File dir,String name){
				File currFile=new File(dir,name);
				if(currFile.isFile()){
					for(String suffix:suffixArray){
						if(name.endsWith("."+suffix)){
							return true;
						}
					}
				}
				return false;
			}
		};
		ArrayList<String> arraylist=fileDir(file,filter);
		return arraylist;
	}
	public static ArrayList<String>fileDir(File dir,FilenameFilter filter){
		ArrayList<String>arraylist=new ArrayList<String>();
		File [] lists=dir.listFiles(filter);
		for(File list:lists){
			arraylist.add(list.getAbsolutePath());
		}
		File [] files=dir.listFiles();
		for(File file:files){
			if(file.isDirectory()){
				ArrayList<String>every=fileDir(file,filter);
				arraylist.addAll(every);
			}
		}
		return arraylist;
	}
	
	public static void copySrcPathToDestPath(File srcDir,File destDir) throws Exception{
		File [] files=srcDir.listFiles();
		for(int i=0;i<files.length;i++){
			File copiedFile=new File(destDir,files[i].getName());
			if(files[i].isDirectory()){
				if(!copiedFile.mkdirs()){
					System.out.println("�޷�������"+copiedFile);
					return;
				}
				copySrcPathToDestPath(files[i],copiedFile);
			}else{
				FileInputStream input=new FileInputStream(files[i]);
				FileOutputStream output=new FileOutputStream(copiedFile);
				byte [] buffer=new byte[1024];
				int n=0;
				while((n=input.read(buffer))!=-1){
					output.write(buffer, 0, n);
				}
				input.close();
				output.close();
			}
		}
	}
}



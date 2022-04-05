package ch71;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Notepad {
	private static String filPath;
	private static String message="";
	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("--1:新建文件   2：打开文件   3：修改文件   4：保存   5：退出--");
		while(true){
			System.out.println("请输入操作指令：");
			int command=sc.nextInt();
			switch(command){
			case 1:
				createFile();
				break;
			case 2:
				openFile();
				break;
			case 3:
				editFile();
				break;
			case 4:
				saveFile();
				break;
			case 5:
				exit();
				break;
			default:
				System.out.println("您输入的指令错误！");
				break;
			}
		}
	}	

	private static void createFile(){
		message="";
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入内容，停止编写请输入\"stop\":");
		StringBuffer stb=new StringBuffer();
		String inputMessage="";
		while(!inputMessage.equals("stop")){
			if(stb.length()>0){
				stb.append("\r\n");
			}
			stb.append(inputMessage);
			inputMessage=sc.nextLine();
		}
		message=stb.toString();
	}

	private static void openFile() throws Exception{
		message="";
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入打开文件位置：");
		filPath=sc.next();
		if(filPath!=null && !filPath.endsWith(".txt")){
			System.out.println("请选择文本文件！");
			return;
		}
		FileReader in=new FileReader(filPath);
		char [] charArray=new char[1024];
		int len=0;
		StringBuffer sb=new StringBuffer();
		while((len=in.read(charArray))!=-1){
			sb.append(charArray);
		}
		message=sb.toString();
		System.out.println("打开文件内容："+"\r\n"+message);
		in.close();
	}
	
	private static void editFile(){
		if(message==""&&filPath==null){
			return;
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入要修改内容（以\"修改的目标文字:修改之后的文字\"格式）,"+"停止修改请输入\"stop\":");
		String inputMessage="";
		while(!inputMessage.equals("stop")){
			inputMessage=sc.nextLine();
			if(inputMessage!=null&&inputMessage.length()>0){
				String [] editMessage=inputMessage.split(":");
				if(editMessage!=null&&editMessage.length>1){
					message=message.replace(editMessage[0],editMessage[1]);
				}
			}
		}
		System.out.println("修改后的内容："+"\r\n"+message);
	}

	private static void saveFile() throws IOException{
		Scanner sc=new Scanner(System.in);
		FileWriter out=null;
		if(filPath != null){
			out=new FileWriter(filPath);
		}else{
			System.out.println("请输入文本保存绝对路径：");
			String path=sc.next();
			filPath = path;
			if(!filPath.toLowerCase().endsWith(".txt")){
				filPath+=".txt";
			}
			out=new FileWriter(filPath);
		}
		out.write(message);
		out.close();
		message="";
		filPath=null;
	}
	
	
	private static void exit(){
		System.out.println("您已退出系统，谢谢使用！");
		System.exit(0);
	}

}


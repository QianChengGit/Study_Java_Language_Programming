package shixun;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Student {
	private String name;
	private String sex;
	private String ID;
	private String age;
	private String math;
	private String english;
	private String java;
	private String sj;//数据结构课程变量
	Scanner sc=new Scanner(System.in);//创建了一个全局输入对象
	Teacher teacher=new Teacher();//创建了一个Teacher对象
	public Student(){
		super();
	}
	public Student(String name,String sex,String ID,String age,String math,String english,String java,String sj){
		this.name=name;
		this.sex=sex;
		this.ID=ID;
		this.age=age;
		this.math=math;
		this.english=english;
		this.java=java;
		this.sj=sj;
	}
	public Student(String name,String sex,String ID,String age){
		this.name=name;
		this.sex=sex;
		this.ID=ID;
		this.age=age;
	}
	//定义了一个输出方法
	public void show(){
		System.out.println();
		System.out.println("                                                   "
	    + "                                                        学生个人信息：\n");
		System.out.println("姓名："+name+"\n性别："+sex+"\n学号："
	+ID+"\n年龄："+age+"\n数学："+math+"\n英语："+english+"\nJAVA："+java+"\n数据结构："+sj);
	}
	//登录方法
	public void login() throws IOException{
		int i=0;
		do{
		System.out.println("请输入学生账号(20170108)：");
		String b=sc.next();
		if(ID.equals(b)){
			System.out.println("请输入密码(2001)：");
			String d=sc.next();
			if("2001".equals(d)){
				menuDisplay();//调用菜单显示方法
			}
			else{
				System.out.println("密码错误,请重新输入账号和密码！");
				i=1;
			}
		}
		
		else{
			System.out.println("账号错误，请重新输入账号!");
			i=1;
		    }
		}while(i==1);
		//动态登录
	/*	int i=0,j,s=0,k=0;
		String [][] score=new String[1000][7];
		FileReader reader=new FileReader("studentRegistered.txt");
		BufferedReader br=new BufferedReader(reader);		
		String str;
		for(i=0;(str=br.readLine())!=null&&i<score.length;i++){
			String [] as=str.split("   ");
			s++;
				for(j=0;j<score[i].length;j++){
					switch(j){
					case 0:
						score[i][j]=as[j];
						break;
					case 1:
						score[i][j]=as[j];
						break;
					case 2:
						score[i][j]=as[j];
						break;
					case 3:
						score[i][j]=as[j];
						break;
					case 4:
						score[i][j]=as[j];
						break;
					case 5:
						score[i][j]=as[j];
						break;
					case 6:
						score[i][j]=as[j];
						System.out.println("");
						break;
					default:
						System.out.println("错误显示！");
						break;
					}
				}
			
			}
		System.out.println("请输入学号：");
		String b=sc.next();
		System.out.println("请输入密码：");
		String d=sc.next();
		for(i=0;i<s;i++){
			
			if(score[i][1].equals(b)){
				
				if(score[i][2].equals(d)){
					System.out.println("登录成功！");
					menuDisplay();
					break;
				}
				else{
					System.out.println("密码错误,请重新输入账号和密码！");
				//	k=1;
				}
			}
			else{
				System.out.println("账号错误，请重新输入账号!");
			//	k=1;
				}
			}
		}
		*/
	}
	
	public void ClassSchedule(){
		System.out.println();
		System.out.println("                                                     "
		+ "                                                      课程表：\n");
		System.out.println("                      *****************************************************************");
		System.out.println("                      *******************           课             表                      ***************");
		System.out.println("                      *****************************************************************");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |第一节课  | 软件测试    | 数据结构    |  JAVA     |   英语       |         |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |第二节课  | 软件测试    | 数据结构    |  JAVA     |   英语       |         |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |第三节课  | 软件测试    | 数据结构    |  JAVA     |   数学       | 软件测试  |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |第四节课  | 软件测试    | 数据结构    |  JAVA     |   数学       | 软件测试  |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |第五节课  |          |          | 计算机网络  |   数学       |  思修       |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |第六节课  |          |          | 计算机网络  |   数学       |  思修       |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |第七节课  |   英语       |          | 计算机网络  |   体育       |         |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |第八节课  |   英语       |          | 计算机网络  |   体育       |         |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      *****************************************************************");
		System.out.println("                      *****************************************************************");
	}
	//定义了一个菜单显示方法
	public void menuDisplay() throws IOException{
		itcast: while(true){
		System.out.println();
		System.out.println("                                             "
	    + "                                                              学生系统菜单(学生登录界面)\n");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |选项       |          内容                           |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |1、         |         个人信息                     |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |2、         |         课程表                         |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |3、         |         成绩查询                     |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |4、         |         退出学生登录             |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("请输入选择：");
		String studentInformation=sc.next();
		switch(studentInformation){
			case "1":
				show();
				break;
			case "2":
				ClassSchedule();
				break;
			case "3":
				teacher.find();
				break;
			case "4":
				break itcast;
			default:
				System.out.println("您输入的指令错误！");
				break;
			}
		}
	}
	
	//学生注册方法
	public void StudentRegistered() throws IOException{
		int i=1,j=7;
		String [][] score=new String[i][j];
		File f = new File("studentRegistered.txt");
		FileWriter fw=new FileWriter(f,true);
		PrintWriter writer = new PrintWriter(fw);
		//输入信息
		for(i=0;i<score.length;i++){
			System.out.println("\n录入注册信息：");
			writer.write("");
			for(j=0;j<score[i].length;j++){
				switch(j){
				case 0:
					System.out.print("姓名：");
					String name1=sc.next();
					score[i][j]=name1;
					break;
				case 1:
					System.out.print("学号：");
					String ID=sc.next();
					score[i][j]=ID;
					break;
				case 2:
					System.out.print("密码：");
					String math=sc.next();
					score[i][j]=math;
					break;
				case 3:
					System.out.print("身份证号：");
					String English=sc.next();
					score[i][j]=English;
					break;
				case 4:
					System.out.print("出生日期：");
					String java=sc.next();
					score[i][j]=java;
					break;
				case 5:
					System.out.print("家庭住址：");
					String sj=sc.next();
					score[i][j]=sj;
					break;
				case 6:
					System.out.print("电话号码：");
					String phone=sc.next();
					score[i][j]=phone;
					break;
				default:
					System.out.println("错误显示！");
					break;
				}
				writer.write(score[i][j]);
				writer.write("   ");
			}
			writer.write("\r\n");
		}
		fw.close();
		writer.close();	
	}
}





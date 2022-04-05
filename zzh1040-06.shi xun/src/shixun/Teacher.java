package shixun;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
public class Teacher {
	
	private String name;
	private String ID1;
	private String sex;
	private String age;
	Scanner sc=new Scanner(System.in);
	ArrayList <String>list=new ArrayList<String>();
	public Teacher(){
		super();
	}
	
	public Teacher(String name,String sex,String ID,String age){
		this.name=name;
		this.sex=sex;
		this.ID1=ID;
		this.age=age;
	}
	
	public void show1(){
		System.out.println();
		System.out.println("                                                   "
			    + "                                                        教师个人信息：\n");
		System.out.println("姓名："+name+"\n性别："+sex+"\n学号："
	+ID1+"\n年龄："+age);
	}
	//登录方法
	public void login() throws Exception {
		int i=0;
		do{
		System.out.println("请输入教师账号(2001452)：");
		String c=sc.next();
		if(ID1.equals(c)){
			System.out.println("请输入密码(2000)：");
			String e=sc.next();
			if("2000".equals(e)){
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

}
	public void menuDisplay() throws IOException{
		itcast: while(true){
		System.out.println();
		System.out.println("                                             "
	    + "                                                              教师系统菜单(教师登录界面)\n");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |选项       |          内容                           |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |1、         |         教师个人信息             |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |2、         |         录入学生成绩             |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |3、         |         增加学生成绩             |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |4、         |         删除学生成绩             |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |5、         |         查询学生成绩             |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |6、         |         修改学生成绩             |");
		System.out.println("                                      |——————————————————————————————————|");
	//	System.out.println("                                      |7、         |         学生成绩排序             |");
	//	System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |7、         |         退出教师登录             |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("请输入选择：");
		String studentInformation=sc.next();
		switch(studentInformation){
			case "1":
				show1();
			//	studentadd();
				break;
			case "2":
				entryStudent();
				break;
			case "3":
				add();
				break;	
			case "4":
				delete();
				break;	
			case "5":
				find();
				break;	
			case "6":
				Modify();
				break;	
			case "7":
				break itcast;
			default:
				System.out.println("您输入的指令错误！");
			}
		}
	}
	//定义了一个录入学生成绩方法
	public void entryStudent() throws IOException{
		int j=6;
		System.out.println("请输入学生个数：");
		int i=sc.nextInt();
		System.out.println("(学号，姓名，数学，英语，JAVA，数据结构)姓名内输入stop结束录入,请输入学生成绩：");
		String [][] score=new String[i][j];
		FileWriter writer=new FileWriter("writer.txt");
		//输入信息
		ok:for(i=0;i<score.length;i++){
			System.out.println("\n录入第"+(i+1)+"个学生成绩：");
			for(j=0;j<score[i].length;j++){
				switch(j){
				case 0:
					System.out.print("姓名：");
					String name1=sc.next();
					//输入stop，就跳出输入循环
					if("stop".equals(name1)){
						break ok;
					}
					score[i][0]=name1;
					break;
				case 1:
					System.out.print("学号：");
					String ID=sc.next();
					score[i][1]=ID;
					break;
				case 2:
					System.out.print("数学：");
					String math=sc.next();
					score[i][2]=math;
					break;
				case 3:
					System.out.print("英语：");
					String English=sc.next();
					score[i][3]=English;
					break;
				case 4:
					System.out.print("JAVA：");
					String java=sc.next();
					score[i][4]=java;
					break;
				case 5:
					System.out.print("数据结构：");
					String sj=sc.next();
					score[i][5]=sj;
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
		writer.close();
		
		//输出信息
		System.out.println("\n\n输入学生信息为：\n");
			for(i=0;i<score.length;i++){
				System.out.println("第"+(i+1)+"个学生成绩为：");
				for(j=0;j<score[i].length;j++){
					
					switch(j){
					case 0:
						System.out.print("姓名：");
						System.out.println(score[i][j]);
						break;
					case 1:
						System.out.print("学号：");
						System.out.println(score[i][j]);
						break;
					case 2:
						System.out.print("数学：");
						System.out.println(score[i][j]);
						break;
					case 3:
						System.out.print("英语：");
						System.out.println(score[i][j]);
						break;
					case 4:
						System.out.print("JAVA：");
						System.out.println(score[i][j]);
						break;
					case 5:
						System.out.print("数据结构：");
						System.out.println(score[i][j]);
						System.out.println("");
						break;
					default:
						System.out.println("错误显示！");
						break;
					}
				}
			}	
	}
	//定义了一个增加学生成绩方法
	public void add() throws IOException{
		int j=6;
		System.out.println("请输入学生个数：");
		Scanner sc = new Scanner(System.in);
		int i=sc.nextInt();
		System.out.println("(学号，姓名，数学，英语，JAVA，数据结构)姓名内输入stop结束录入,请输入学生成绩：");
		String [][] score=new String[i][j];
		File f = new File("writer.txt");
		FileWriter fw=new FileWriter(f,true);
		PrintWriter writer = new PrintWriter(fw);
		//输入信息
		ok:for(i=0;i<score.length;i++){
			System.out.println("\n录入第"+(i+1)+"个学生成绩：");
			writer.write("");
			for(j=0;j<score[i].length;j++){
				switch(j){
				case 0:
					System.out.print("姓名：");
					String name1=sc.next();
					//输入stop，就跳出输入循环
					if("stop".equals(name1)){
						break ok;
					}
					score[i][0]=name1;
					break;
				case 1:
					System.out.print("学号：");
					String ID=sc.next();
					score[i][1]=ID;
					break;
				case 2:
					System.out.print("数学：");
					String math=sc.next();
					score[i][2]=math;
					break;
				case 3:
					System.out.print("英语：");
					String English=sc.next();
					score[i][3]=English;
					break;
				case 4:
					System.out.print("JAVA：");
					String java=sc.next();
					score[i][4]=java;
					break;
				case 5:
					System.out.print("数据结构：");
					String sj=sc.next();
					score[i][5]=sj;
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
		
		//输出信息
		System.out.println("\n\n增加的学生信息为：\n");
			for(i=0;i<score.length;i++){
				System.out.println("第"+(i+1)+"个学生成绩为：");
				for(j=0;j<score[i].length;j++){
					
					switch(j){
					case 0:
						System.out.print("姓名：");
						System.out.println(score[i][j]);
						break;
					case 1:
						System.out.print("学号：");
						System.out.println(score[i][j]);
						break;
					case 2:
						System.out.print("数学：");
						System.out.println(score[i][j]);
						break;
					case 3:
						System.out.print("英语：");
						System.out.println(score[i][j]);
						break;
					case 4:
						System.out.print("JAVA：");
						System.out.println(score[i][j]);
						break;
					case 5:
						System.out.print("数据结构：");
						System.out.println(score[i][j]);
						System.out.println("");
						break;
					default:
						System.out.println("错误显示！");
						break;
				}
			}
		}
	}
	//定义了一个删除学生成绩方法
	public void delete() throws IOException{
		int i=0,j,s=0;
		String [][] score=new String[10][6];
		FileReader reader=new FileReader("writer.txt");
		BufferedReader br=new BufferedReader(reader);		
		String str;
		FileWriter writerr=new FileWriter("writerr.txt");
		System.out.println("请输入您想删除学生的学号：");
		String ID=sc.next();
		for(i=0;(str=br.readLine())!=null&&i<score.length;i++){
			String [] as=str.split("   ");
			System.out.println("第"+(i+1)+"个学生成绩为：");
			s++;
			if(!as[1].equals(ID)){
			for(j=0;j<score[i].length;j++){
				switch(j){
					case 0:
						System.out.print("姓名：");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 1:
						System.out.print("学号：");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 2:
						System.out.print("数学：");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 3:
						System.out.print("英语：");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 4:
						System.out.print("JAVA：");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 5:
						System.out.print("数据结构：");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						System.out.println("");
						break;
					default:
						System.out.println("错误显示！");
						break;
					}
				writerr.write(score[i][j]);
				writerr.write("   ");
				}
			writerr.write("\r\n");
			}
			else{
				System.out.println("学生已删除！");
				System.out.println("\n");
			}
		}
		writerr.close();
		reader.close();
		
		InputStream in = new FileInputStream("writerr.txt");
		OutputStream out = new FileOutputStream("writer.txt");
		byte[] buff = new byte[1024];
		int len;
		while((len = in.read(buff))!=-1){
			out.write(buff,0,len);
		}
		in.close();
		out.close();
	
	}
	//定义了一个查询学生成绩方法
	public void find() throws IOException{
		int i=0,j,s=0,k=0;
		String [][] score=new String[100000][6];
		FileReader reader=new FileReader("writer.txt");
		BufferedReader br=new BufferedReader(reader);		
		String str;
		System.out.println("请输入你想查找的学生学号：");
		Scanner sc=new Scanner(System.in);
		String ID=sc.next();
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
						System.out.println("");
						break;
					default:
						System.out.println("错误显示！");
						break;
					}
				}
			
			}	
			for(i=0;i<=s;i++){
				for(j=0;j<score[i].length;j++){
					if(score[i][1]!=null){
						if(score[i][1].equals(ID)){
							k=1;
							switch(j){
							case 0:
								System.out.print("姓名：");
								System.out.println(score[i][j]);
								break;
							case 1:
								System.out.print("学号：");
								System.out.println(score[i][j]);
								break;
							case 2:
								System.out.print("数学：");
								System.out.println(score[i][j]);
								break;
							case 3:
								System.out.print("英语：");
								System.out.println(score[i][j]);
								break;
							case 4:
								System.out.print("JAVA：");
								System.out.println(score[i][j]);
								break;
							case 5:
								System.out.print("数据结构：");
								System.out.println(score[i][j]);
								System.out.println("");
								break;
							default:
								System.out.println("错误显示！");
								break;
						}
					}
				}
				else{
					if(k!=1){
					System.out.println("没有此学生！");
					break;
					}
				}
			}
		}
	}
	//定义了一个修改学生成绩方法
	public void Modify() throws IOException{
		int i=0,j,s=0;
		String [][] score=new String[100000][6];
		
		FileReader reader=new FileReader("writer.txt");
		BufferedReader br=new BufferedReader(reader);		
		String str;
		System.out.println("请输入你想修改的学生学号：");
		Scanner sc=new Scanner(System.in);
		String ID=sc.next();
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
								System.out.println("");
								break;
							default:
								System.out.println("错误显示！");
								break;
						}
						
				}
			
			}
			reader.close();
			FileWriter writerr=new FileWriter("writerr.txt");
			System.out.println();
			System.out.println("                                             "
		    + "                                                        学生成绩修改菜单(教师登录界面)\n");
			System.out.println("                                      |——————————————————————————————————|");
			System.out.println("                                      |选项       |          内容                           |");
			System.out.println("                                      |——————————————————————————————————|");
			System.out.println("                                      |1、         |         修改姓名                     |");
			System.out.println("                                      |——————————————————————————————————|");
			System.out.println("                                      |2、         |         修改学号                     |");
			System.out.println("                                      |——————————————————————————————————|");
			System.out.println("                                      |3、         |         修改数学成绩             |");
			System.out.println("                                      |——————————————————————————————————|");
			System.out.println("                                      |4、         |         修改英语成绩             |");
			System.out.println("                                      |——————————————————————————————————|");
			System.out.println("                                      |5、         |         修改JAVA成绩             |");
			System.out.println("                                      |——————————————————————————————————|");
			System.out.println("                                      |6、         |         修改数据结构成绩      |");
			System.out.println("                                      |——————————————————————————————————|");
			
			System.out.println("请输入你想修改的信息：");
			Scanner sa=new Scanner(System.in);
			int I=sc.nextInt();
			for(i=0;i<s;i++){
				for(j=0;j<score[i].length;j++){
					if(score[i][1]!=null){
					if(score[i][1].equals(ID)){
						switch(I){
						case 1:							
							System.out.println("请输入修改的名字:");
							Scanner sq=new Scanner(System.in);
							String NAME=sq.nextLine();
							score[i][0]=NAME;
							System.out.println("修改成功!");
							I=7;
							break;
						case 2:							
							System.out.println("请输入修改的学号:");
							Scanner sw=new Scanner(System.in);
							String SID=sw.nextLine();
							score[i][1]=SID;
							System.out.println("修改成功!");
							I=7;
							break;
						case 3:							
							System.out.println("请输入修改的数学成绩:");
							Scanner se=new Scanner(System.in);
							String MATH=se.nextLine();
							score[i][2]=MATH;
							System.out.println("修改成功！");
							I=7;
							break;
						case 4:							
							System.out.println("请输入修改的英语成绩：");
							Scanner sr=new Scanner(System.in);
							String English=sr.nextLine();
							score[i][3]=English;
							System.out.println("修改成功！");
							I=7;
							break;
						case 5:							
							System.out.println("请输入你要修改的java成绩：");
							Scanner st=new Scanner(System.in);
							String Java=st.nextLine();
							score[i][4]=Java;
							System.out.println("修改成功！");
							I=7;
							break;
						case 6:							
							System.out.println("请输入修改的数据结构成绩：");
							Scanner sy=new Scanner(System.in);
							String Data=sy.nextLine();
							score[i][5]=Data;
							System.out.println("修改成功！");
							I=7;
							break;
						case 7:
							break;
						default:
							System.out.println("选择输入错误！");
							I=7;
							break;
						}
					}
					writerr.write(score[i][j]);
					writerr.write("   ");
					}
					}	
				writerr.write("\r\n");	
			}
			writerr.close();
			
			InputStream in = new FileInputStream("writerr.txt");
			OutputStream out = new FileOutputStream("writer.txt");
			byte[] buff = new byte[1024];
			int len;
			while((len = in.read(buff))!=-1){
				out.write(buff,0,len);
			}
			in.close();
			out.close();

	}
	
	//定义了一个教师注册方法
	public void TeacherRegistered() throws IOException{
		int i=1,j=7;
		String [][] score=new String[i][j];
		File f = new File("teacherRegistered.txt");
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
					System.out.print("账号：");
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
	//将文本文档中的内容转化为二维数组显示出来
	public void studentadd() throws IOException{
		int i,j;
		String [][] score=new String[10][6];
		FileReader reader=new FileReader("writer.txt");
		BufferedReader br=new BufferedReader(reader);		
		String str;
		for(i=0;(str=br.readLine())!=null&&i<score.length;i++){
			String [] as=str.split("   ");
			System.out.println("第"+(i+1)+"个学生成绩为：");
			for(j=0;j<score[i].length;j++){
				switch(j){
					case 0:
						System.out.print("姓名：");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 1:
						System.out.print("学号：");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 2:
						System.out.print("数学：");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 3:
						System.out.print("英语：");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 4:
						System.out.print("JAVA：");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 5:
						System.out.print("数据结构：");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						System.out.println("");
						break;
					default:
						System.out.println("错误显示！");
						break;
				}
			}
		}	
	}
	
}

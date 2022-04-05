package shixun;
import java.io.IOException;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) throws Exception {
		
		Student student=new Student("张三","男","20170108","18");
		Teacher teacher=new Teacher("李老师","女","2001452","25");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("                                                   "
		+ "                                                        欢迎进入学生管理系统！\n");
		
		while(true){
		System.out.println();
		System.out.println("                                             "
	    + "                                                              学生管理系统菜单(主界面)\n");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |选项       |          内容                           |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |1、         |         注册                             |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |2、         |         学生登录                     |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |3、         |         教师登录                     |");
		System.out.println("                                      |——————————————————————————————————|");
		System.out.println("                                      |4、         |         退出系统                     |");
		System.out.println("                                      |——————————————————————————————————|");
		
		System.out.println("请输入选择：");
		String a=sc.next();
		System.out.println();
		//选择登录
		switch(a){
			case "1":
				System.out.println("您的选择为注册！");
				System.out.println("(1、学生注册      2、教师注册)");
				int registered=sc.nextInt();
				ok:switch(registered){
					case 1:
						student.StudentRegistered();
						break ok;
					case 2:
						teacher.TeacherRegistered();
						break ok;
					default:
						System.out.println("选择输入错误！");
				}
				System.out.println("恭喜您，注册成功！");
				break;
			case "2":
				System.out.println("您的选择为学生登录！");
				student.login();
				break;
			case "3":
				System.out.println("您的选择为教师登录！");
				teacher.login();
				break;
			case "4":
				System.out.println("您的选择为退出系统！");
				exit();
				break;
			default:
				System.out.println("您输入的指令错误！");
				break;
		}
	}
}
	//定义了一个退出系统方法
	private static void exit(){
			System.out.println("您已退出系统！");
			System.exit(0);
		}
}

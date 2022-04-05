package ch31;
//import java.util.Scanner;
public class Test1 {

	public static void main(String[] args) {
		Student1 s1=new Student1("201701081040","张泽宏",'男',99,100,100);
//		s1.showStu();
//		s1.stuID="201701081040";
 //   	s1.setStuID("201701081040");
//		s1.stuName="张泽宏";
//		s1.setSex('男');
//		s1.showStu();
//		s1.stuE=100;
		s1.showStu();
		Student1[] s={new Student1("201701081040","一"),new Student1("201701081041","二"),new Student1("201701081042","三")};
		for(int i=0;i<s.length;i++){
			s[i].showStu();
		}
		
		Grade1 rj=new Grade1();
		rj.setStuArr(s);
		System.out.println("以下是软件技术171班同学胡信息：");
		rj.printStuArr();
		System.out.println("请输入想查找的学生姓名：");
//		Scanner in=new Scanner(System.in);
//		String name=in.next();
		rj.findStuArr();
		
		
		
	}

}

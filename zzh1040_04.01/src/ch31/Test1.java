package ch31;
//import java.util.Scanner;
public class Test1 {

	public static void main(String[] args) {
		Student1 s1=new Student1("201701081040","�����",'��',99,100,100);
//		s1.showStu();
//		s1.stuID="201701081040";
 //   	s1.setStuID("201701081040");
//		s1.stuName="�����";
//		s1.setSex('��');
//		s1.showStu();
//		s1.stuE=100;
		s1.showStu();
		Student1[] s={new Student1("201701081040","һ"),new Student1("201701081041","��"),new Student1("201701081042","��")};
		for(int i=0;i<s.length;i++){
			s[i].showStu();
		}
		
		Grade1 rj=new Grade1();
		rj.setStuArr(s);
		System.out.println("�������������171��ͬѧ����Ϣ��");
		rj.printStuArr();
		System.out.println("����������ҵ�ѧ��������");
//		Scanner in=new Scanner(System.in);
//		String name=in.next();
		rj.findStuArr();
		
		
		
	}

}

package ch26;

public class Test {

	public static void main(String[] args) {
		Student s1=new Student("201701081040","�����",'��',99,100,100);
		s1.showStu();
//		s1.stuID="201701081040";
		s1.setStuID("201701081040");
		s1.stuName="�����";
		s1.setSex('��');
		s1.showStu();
		s1.stuE=100;
		s1.showStu();
		Student[] s={new Student("201701081040","һ"),new Student("201701081041","��"),new Student("201701081042","��")};
		for(int i=0;i<s.length;i++){
			s[i].showStu();
		}
		
		Grade rj=new Grade("�������171");
		rj.setStuArr(s);
		System.out.println("�������������171��ͬѧ����Ϣ��");
		rj.printStuArr();
	}

}

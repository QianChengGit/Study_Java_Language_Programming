package shixun;
import java.io.IOException;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) throws Exception {
		
		Student student=new Student("����","��","20170108","18");
		Teacher teacher=new Teacher("����ʦ","Ů","2001452","25");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("                                                   "
		+ "                                                        ��ӭ����ѧ������ϵͳ��\n");
		
		while(true){
		System.out.println();
		System.out.println("                                             "
	    + "                                                              ѧ������ϵͳ�˵�(������)\n");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |ѡ��       |          ����                           |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |1��         |         ע��                             |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |2��         |         ѧ����¼                     |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |3��         |         ��ʦ��¼                     |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |4��         |         �˳�ϵͳ                     |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		
		System.out.println("������ѡ��");
		String a=sc.next();
		System.out.println();
		//ѡ���¼
		switch(a){
			case "1":
				System.out.println("����ѡ��Ϊע�ᣡ");
				System.out.println("(1��ѧ��ע��      2����ʦע��)");
				int registered=sc.nextInt();
				ok:switch(registered){
					case 1:
						student.StudentRegistered();
						break ok;
					case 2:
						teacher.TeacherRegistered();
						break ok;
					default:
						System.out.println("ѡ���������");
				}
				System.out.println("��ϲ����ע��ɹ���");
				break;
			case "2":
				System.out.println("����ѡ��Ϊѧ����¼��");
				student.login();
				break;
			case "3":
				System.out.println("����ѡ��Ϊ��ʦ��¼��");
				teacher.login();
				break;
			case "4":
				System.out.println("����ѡ��Ϊ�˳�ϵͳ��");
				exit();
				break;
			default:
				System.out.println("�������ָ�����");
				break;
		}
	}
}
	//������һ���˳�ϵͳ����
	private static void exit(){
			System.out.println("�����˳�ϵͳ��");
			System.exit(0);
		}
}

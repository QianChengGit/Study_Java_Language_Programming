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
	private String sj;//���ݽṹ�γ̱���
	Scanner sc=new Scanner(System.in);//������һ��ȫ���������
	Teacher teacher=new Teacher();//������һ��Teacher����
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
	//������һ���������
	public void show(){
		System.out.println();
		System.out.println("                                                   "
	    + "                                                        ѧ��������Ϣ��\n");
		System.out.println("������"+name+"\n�Ա�"+sex+"\nѧ�ţ�"
	+ID+"\n���䣺"+age+"\n��ѧ��"+math+"\nӢ�"+english+"\nJAVA��"+java+"\n���ݽṹ��"+sj);
	}
	//��¼����
	public void login() throws IOException{
		int i=0;
		do{
		System.out.println("������ѧ���˺�(20170108)��");
		String b=sc.next();
		if(ID.equals(b)){
			System.out.println("����������(2001)��");
			String d=sc.next();
			if("2001".equals(d)){
				menuDisplay();//���ò˵���ʾ����
			}
			else{
				System.out.println("�������,�����������˺ź����룡");
				i=1;
			}
		}
		
		else{
			System.out.println("�˺Ŵ��������������˺�!");
			i=1;
		    }
		}while(i==1);
		//��̬��¼
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
						System.out.println("������ʾ��");
						break;
					}
				}
			
			}
		System.out.println("������ѧ�ţ�");
		String b=sc.next();
		System.out.println("���������룺");
		String d=sc.next();
		for(i=0;i<s;i++){
			
			if(score[i][1].equals(b)){
				
				if(score[i][2].equals(d)){
					System.out.println("��¼�ɹ���");
					menuDisplay();
					break;
				}
				else{
					System.out.println("�������,�����������˺ź����룡");
				//	k=1;
				}
			}
			else{
				System.out.println("�˺Ŵ��������������˺�!");
			//	k=1;
				}
			}
		}
		*/
	}
	
	public void ClassSchedule(){
		System.out.println();
		System.out.println("                                                     "
		+ "                                                      �γ̱�\n");
		System.out.println("                      *****************************************************************");
		System.out.println("                      *******************           ��             ��                      ***************");
		System.out.println("                      *****************************************************************");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |��һ�ڿ�  | �������    | ���ݽṹ    |  JAVA     |   Ӣ��       |         |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |�ڶ��ڿ�  | �������    | ���ݽṹ    |  JAVA     |   Ӣ��       |         |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |�����ڿ�  | �������    | ���ݽṹ    |  JAVA     |   ��ѧ       | �������  |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |���Ľڿ�  | �������    | ���ݽṹ    |  JAVA     |   ��ѧ       | �������  |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |����ڿ�  |          |          | ���������  |   ��ѧ       |  ˼��       |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |�����ڿ�  |          |          | ���������  |   ��ѧ       |  ˼��       |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |���߽ڿ�  |   Ӣ��       |          | ���������  |   ����       |         |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      |�ڰ˽ڿ�  |   Ӣ��       |          | ���������  |   ����       |         |");
		System.out.println("                      |        |          |          |           |          |         |");
		System.out.println("                      _________________________________________________________________");
		System.out.println("                      *****************************************************************");
		System.out.println("                      *****************************************************************");
	}
	//������һ���˵���ʾ����
	public void menuDisplay() throws IOException{
		itcast: while(true){
		System.out.println();
		System.out.println("                                             "
	    + "                                                              ѧ��ϵͳ�˵�(ѧ����¼����)\n");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |ѡ��       |          ����                           |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |1��         |         ������Ϣ                     |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |2��         |         �γ̱�                         |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |3��         |         �ɼ���ѯ                     |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |4��         |         �˳�ѧ����¼             |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("������ѡ��");
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
				System.out.println("�������ָ�����");
				break;
			}
		}
	}
	
	//ѧ��ע�᷽��
	public void StudentRegistered() throws IOException{
		int i=1,j=7;
		String [][] score=new String[i][j];
		File f = new File("studentRegistered.txt");
		FileWriter fw=new FileWriter(f,true);
		PrintWriter writer = new PrintWriter(fw);
		//������Ϣ
		for(i=0;i<score.length;i++){
			System.out.println("\n¼��ע����Ϣ��");
			writer.write("");
			for(j=0;j<score[i].length;j++){
				switch(j){
				case 0:
					System.out.print("������");
					String name1=sc.next();
					score[i][j]=name1;
					break;
				case 1:
					System.out.print("ѧ�ţ�");
					String ID=sc.next();
					score[i][j]=ID;
					break;
				case 2:
					System.out.print("���룺");
					String math=sc.next();
					score[i][j]=math;
					break;
				case 3:
					System.out.print("���֤�ţ�");
					String English=sc.next();
					score[i][j]=English;
					break;
				case 4:
					System.out.print("�������ڣ�");
					String java=sc.next();
					score[i][j]=java;
					break;
				case 5:
					System.out.print("��ͥסַ��");
					String sj=sc.next();
					score[i][j]=sj;
					break;
				case 6:
					System.out.print("�绰���룺");
					String phone=sc.next();
					score[i][j]=phone;
					break;
				default:
					System.out.println("������ʾ��");
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





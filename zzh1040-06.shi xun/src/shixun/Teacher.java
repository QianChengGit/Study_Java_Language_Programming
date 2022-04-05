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
			    + "                                                        ��ʦ������Ϣ��\n");
		System.out.println("������"+name+"\n�Ա�"+sex+"\nѧ�ţ�"
	+ID1+"\n���䣺"+age);
	}
	//��¼����
	public void login() throws Exception {
		int i=0;
		do{
		System.out.println("�������ʦ�˺�(2001452)��");
		String c=sc.next();
		if(ID1.equals(c)){
			System.out.println("����������(2000)��");
			String e=sc.next();
			if("2000".equals(e)){
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

}
	public void menuDisplay() throws IOException{
		itcast: while(true){
		System.out.println();
		System.out.println("                                             "
	    + "                                                              ��ʦϵͳ�˵�(��ʦ��¼����)\n");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |ѡ��       |          ����                           |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |1��         |         ��ʦ������Ϣ             |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |2��         |         ¼��ѧ���ɼ�             |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |3��         |         ����ѧ���ɼ�             |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |4��         |         ɾ��ѧ���ɼ�             |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |5��         |         ��ѯѧ���ɼ�             |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |6��         |         �޸�ѧ���ɼ�             |");
		System.out.println("                                      |��������������������������������������������������������������������|");
	//	System.out.println("                                      |7��         |         ѧ���ɼ�����             |");
	//	System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("                                      |7��         |         �˳���ʦ��¼             |");
		System.out.println("                                      |��������������������������������������������������������������������|");
		System.out.println("������ѡ��");
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
				System.out.println("�������ָ�����");
			}
		}
	}
	//������һ��¼��ѧ���ɼ�����
	public void entryStudent() throws IOException{
		int j=6;
		System.out.println("������ѧ��������");
		int i=sc.nextInt();
		System.out.println("(ѧ�ţ���������ѧ��Ӣ�JAVA�����ݽṹ)����������stop����¼��,������ѧ���ɼ���");
		String [][] score=new String[i][j];
		FileWriter writer=new FileWriter("writer.txt");
		//������Ϣ
		ok:for(i=0;i<score.length;i++){
			System.out.println("\n¼���"+(i+1)+"��ѧ���ɼ���");
			for(j=0;j<score[i].length;j++){
				switch(j){
				case 0:
					System.out.print("������");
					String name1=sc.next();
					//����stop������������ѭ��
					if("stop".equals(name1)){
						break ok;
					}
					score[i][0]=name1;
					break;
				case 1:
					System.out.print("ѧ�ţ�");
					String ID=sc.next();
					score[i][1]=ID;
					break;
				case 2:
					System.out.print("��ѧ��");
					String math=sc.next();
					score[i][2]=math;
					break;
				case 3:
					System.out.print("Ӣ�");
					String English=sc.next();
					score[i][3]=English;
					break;
				case 4:
					System.out.print("JAVA��");
					String java=sc.next();
					score[i][4]=java;
					break;
				case 5:
					System.out.print("���ݽṹ��");
					String sj=sc.next();
					score[i][5]=sj;
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
		writer.close();
		
		//�����Ϣ
		System.out.println("\n\n����ѧ����ϢΪ��\n");
			for(i=0;i<score.length;i++){
				System.out.println("��"+(i+1)+"��ѧ���ɼ�Ϊ��");
				for(j=0;j<score[i].length;j++){
					
					switch(j){
					case 0:
						System.out.print("������");
						System.out.println(score[i][j]);
						break;
					case 1:
						System.out.print("ѧ�ţ�");
						System.out.println(score[i][j]);
						break;
					case 2:
						System.out.print("��ѧ��");
						System.out.println(score[i][j]);
						break;
					case 3:
						System.out.print("Ӣ�");
						System.out.println(score[i][j]);
						break;
					case 4:
						System.out.print("JAVA��");
						System.out.println(score[i][j]);
						break;
					case 5:
						System.out.print("���ݽṹ��");
						System.out.println(score[i][j]);
						System.out.println("");
						break;
					default:
						System.out.println("������ʾ��");
						break;
					}
				}
			}	
	}
	//������һ������ѧ���ɼ�����
	public void add() throws IOException{
		int j=6;
		System.out.println("������ѧ��������");
		Scanner sc = new Scanner(System.in);
		int i=sc.nextInt();
		System.out.println("(ѧ�ţ���������ѧ��Ӣ�JAVA�����ݽṹ)����������stop����¼��,������ѧ���ɼ���");
		String [][] score=new String[i][j];
		File f = new File("writer.txt");
		FileWriter fw=new FileWriter(f,true);
		PrintWriter writer = new PrintWriter(fw);
		//������Ϣ
		ok:for(i=0;i<score.length;i++){
			System.out.println("\n¼���"+(i+1)+"��ѧ���ɼ���");
			writer.write("");
			for(j=0;j<score[i].length;j++){
				switch(j){
				case 0:
					System.out.print("������");
					String name1=sc.next();
					//����stop������������ѭ��
					if("stop".equals(name1)){
						break ok;
					}
					score[i][0]=name1;
					break;
				case 1:
					System.out.print("ѧ�ţ�");
					String ID=sc.next();
					score[i][1]=ID;
					break;
				case 2:
					System.out.print("��ѧ��");
					String math=sc.next();
					score[i][2]=math;
					break;
				case 3:
					System.out.print("Ӣ�");
					String English=sc.next();
					score[i][3]=English;
					break;
				case 4:
					System.out.print("JAVA��");
					String java=sc.next();
					score[i][4]=java;
					break;
				case 5:
					System.out.print("���ݽṹ��");
					String sj=sc.next();
					score[i][5]=sj;
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
		
		//�����Ϣ
		System.out.println("\n\n���ӵ�ѧ����ϢΪ��\n");
			for(i=0;i<score.length;i++){
				System.out.println("��"+(i+1)+"��ѧ���ɼ�Ϊ��");
				for(j=0;j<score[i].length;j++){
					
					switch(j){
					case 0:
						System.out.print("������");
						System.out.println(score[i][j]);
						break;
					case 1:
						System.out.print("ѧ�ţ�");
						System.out.println(score[i][j]);
						break;
					case 2:
						System.out.print("��ѧ��");
						System.out.println(score[i][j]);
						break;
					case 3:
						System.out.print("Ӣ�");
						System.out.println(score[i][j]);
						break;
					case 4:
						System.out.print("JAVA��");
						System.out.println(score[i][j]);
						break;
					case 5:
						System.out.print("���ݽṹ��");
						System.out.println(score[i][j]);
						System.out.println("");
						break;
					default:
						System.out.println("������ʾ��");
						break;
				}
			}
		}
	}
	//������һ��ɾ��ѧ���ɼ�����
	public void delete() throws IOException{
		int i=0,j,s=0;
		String [][] score=new String[10][6];
		FileReader reader=new FileReader("writer.txt");
		BufferedReader br=new BufferedReader(reader);		
		String str;
		FileWriter writerr=new FileWriter("writerr.txt");
		System.out.println("����������ɾ��ѧ����ѧ�ţ�");
		String ID=sc.next();
		for(i=0;(str=br.readLine())!=null&&i<score.length;i++){
			String [] as=str.split("   ");
			System.out.println("��"+(i+1)+"��ѧ���ɼ�Ϊ��");
			s++;
			if(!as[1].equals(ID)){
			for(j=0;j<score[i].length;j++){
				switch(j){
					case 0:
						System.out.print("������");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 1:
						System.out.print("ѧ�ţ�");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 2:
						System.out.print("��ѧ��");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 3:
						System.out.print("Ӣ�");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 4:
						System.out.print("JAVA��");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 5:
						System.out.print("���ݽṹ��");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						System.out.println("");
						break;
					default:
						System.out.println("������ʾ��");
						break;
					}
				writerr.write(score[i][j]);
				writerr.write("   ");
				}
			writerr.write("\r\n");
			}
			else{
				System.out.println("ѧ����ɾ����");
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
	//������һ����ѯѧ���ɼ�����
	public void find() throws IOException{
		int i=0,j,s=0,k=0;
		String [][] score=new String[100000][6];
		FileReader reader=new FileReader("writer.txt");
		BufferedReader br=new BufferedReader(reader);		
		String str;
		System.out.println("������������ҵ�ѧ��ѧ�ţ�");
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
						System.out.println("������ʾ��");
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
								System.out.print("������");
								System.out.println(score[i][j]);
								break;
							case 1:
								System.out.print("ѧ�ţ�");
								System.out.println(score[i][j]);
								break;
							case 2:
								System.out.print("��ѧ��");
								System.out.println(score[i][j]);
								break;
							case 3:
								System.out.print("Ӣ�");
								System.out.println(score[i][j]);
								break;
							case 4:
								System.out.print("JAVA��");
								System.out.println(score[i][j]);
								break;
							case 5:
								System.out.print("���ݽṹ��");
								System.out.println(score[i][j]);
								System.out.println("");
								break;
							default:
								System.out.println("������ʾ��");
								break;
						}
					}
				}
				else{
					if(k!=1){
					System.out.println("û�д�ѧ����");
					break;
					}
				}
			}
		}
	}
	//������һ���޸�ѧ���ɼ�����
	public void Modify() throws IOException{
		int i=0,j,s=0;
		String [][] score=new String[100000][6];
		
		FileReader reader=new FileReader("writer.txt");
		BufferedReader br=new BufferedReader(reader);		
		String str;
		System.out.println("�����������޸ĵ�ѧ��ѧ�ţ�");
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
								System.out.println("������ʾ��");
								break;
						}
						
				}
			
			}
			reader.close();
			FileWriter writerr=new FileWriter("writerr.txt");
			System.out.println();
			System.out.println("                                             "
		    + "                                                        ѧ���ɼ��޸Ĳ˵�(��ʦ��¼����)\n");
			System.out.println("                                      |��������������������������������������������������������������������|");
			System.out.println("                                      |ѡ��       |          ����                           |");
			System.out.println("                                      |��������������������������������������������������������������������|");
			System.out.println("                                      |1��         |         �޸�����                     |");
			System.out.println("                                      |��������������������������������������������������������������������|");
			System.out.println("                                      |2��         |         �޸�ѧ��                     |");
			System.out.println("                                      |��������������������������������������������������������������������|");
			System.out.println("                                      |3��         |         �޸���ѧ�ɼ�             |");
			System.out.println("                                      |��������������������������������������������������������������������|");
			System.out.println("                                      |4��         |         �޸�Ӣ��ɼ�             |");
			System.out.println("                                      |��������������������������������������������������������������������|");
			System.out.println("                                      |5��         |         �޸�JAVA�ɼ�             |");
			System.out.println("                                      |��������������������������������������������������������������������|");
			System.out.println("                                      |6��         |         �޸����ݽṹ�ɼ�      |");
			System.out.println("                                      |��������������������������������������������������������������������|");
			
			System.out.println("�����������޸ĵ���Ϣ��");
			Scanner sa=new Scanner(System.in);
			int I=sc.nextInt();
			for(i=0;i<s;i++){
				for(j=0;j<score[i].length;j++){
					if(score[i][1]!=null){
					if(score[i][1].equals(ID)){
						switch(I){
						case 1:							
							System.out.println("�������޸ĵ�����:");
							Scanner sq=new Scanner(System.in);
							String NAME=sq.nextLine();
							score[i][0]=NAME;
							System.out.println("�޸ĳɹ�!");
							I=7;
							break;
						case 2:							
							System.out.println("�������޸ĵ�ѧ��:");
							Scanner sw=new Scanner(System.in);
							String SID=sw.nextLine();
							score[i][1]=SID;
							System.out.println("�޸ĳɹ�!");
							I=7;
							break;
						case 3:							
							System.out.println("�������޸ĵ���ѧ�ɼ�:");
							Scanner se=new Scanner(System.in);
							String MATH=se.nextLine();
							score[i][2]=MATH;
							System.out.println("�޸ĳɹ���");
							I=7;
							break;
						case 4:							
							System.out.println("�������޸ĵ�Ӣ��ɼ���");
							Scanner sr=new Scanner(System.in);
							String English=sr.nextLine();
							score[i][3]=English;
							System.out.println("�޸ĳɹ���");
							I=7;
							break;
						case 5:							
							System.out.println("��������Ҫ�޸ĵ�java�ɼ���");
							Scanner st=new Scanner(System.in);
							String Java=st.nextLine();
							score[i][4]=Java;
							System.out.println("�޸ĳɹ���");
							I=7;
							break;
						case 6:							
							System.out.println("�������޸ĵ����ݽṹ�ɼ���");
							Scanner sy=new Scanner(System.in);
							String Data=sy.nextLine();
							score[i][5]=Data;
							System.out.println("�޸ĳɹ���");
							I=7;
							break;
						case 7:
							break;
						default:
							System.out.println("ѡ���������");
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
	
	//������һ����ʦע�᷽��
	public void TeacherRegistered() throws IOException{
		int i=1,j=7;
		String [][] score=new String[i][j];
		File f = new File("teacherRegistered.txt");
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
					System.out.print("�˺ţ�");
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
	//���ı��ĵ��е�����ת��Ϊ��ά������ʾ����
	public void studentadd() throws IOException{
		int i,j;
		String [][] score=new String[10][6];
		FileReader reader=new FileReader("writer.txt");
		BufferedReader br=new BufferedReader(reader);		
		String str;
		for(i=0;(str=br.readLine())!=null&&i<score.length;i++){
			String [] as=str.split("   ");
			System.out.println("��"+(i+1)+"��ѧ���ɼ�Ϊ��");
			for(j=0;j<score[i].length;j++){
				switch(j){
					case 0:
						System.out.print("������");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 1:
						System.out.print("ѧ�ţ�");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 2:
						System.out.print("��ѧ��");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 3:
						System.out.print("Ӣ�");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 4:
						System.out.print("JAVA��");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						break;
					case 5:
						System.out.print("���ݽṹ��");
						score[i][j]=as[j];
						System.out.println(score[i][j]);
						System.out.println("");
						break;
					default:
						System.out.println("������ʾ��");
						break;
				}
			}
		}	
	}
	
}

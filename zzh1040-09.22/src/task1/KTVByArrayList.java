package task1;
import java.util.ArrayList;
import java.util.Scanner;
public class KTVByArrayList {
	public static void main(String[] args) {
		System.out.println("------��ӭ�������ϵͳ------");
		System.out.println("0.��Ӹ������б�");
		System.out.println("1.�������ö�");
		System.out.println("2.������ǰ��һλ");
		System.out.println("3.�鿴�赥");
		System.out.println("4.�˳�");
		ArrayList lineUpList = new ArrayList();
		addMusicList(lineUpList);
		while(true){
			System.out.println("������Ҫִ�еĲ�����ţ�");
			Scanner scan = new Scanner(System.in);
			int command = scan.nextInt();
			//ִ����Ŷ�Ӧ�Ĺ���
			switch(command){
			case 0:
				addMusic(lineUpList);
				break;
			case 1:
				setTop(lineUpList);
				break;
			case 2:
				setBefore(lineUpList);
				break;
			case 3:
				System.out.println(lineUpList);
				break;
			case 4:
				exit();
				break;
			default:
				System.out.println("-------------------------");
				System.out.println("����ѡ��������������ȷ�Ĺ�����ţ�");
				break;
			}
		}
	}
	
	//��ʼʱ��Ӹ�������
	private static void addMusicList(ArrayList lineUpList){
		lineUpList.add("����");
		lineUpList.add("ҹ��");
		lineUpList.add("ҹ�ĵ�����");
		lineUpList.add("������Ļ�");
		lineUpList.add("�����");
		System.out.println("��ʼ�����б�"+lineUpList);
	}
	
	//ִ����Ӹ���
	private static void addMusic(ArrayList lineUpList) {
		System.out.println("������Ҫ��ӵĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();
		lineUpList.add(musicName);
		System.out.println("����Ӹ�����"+musicName);
		System.out.println("��Ӹ�����ĸ����б�"+lineUpList);
	}
	
	//ִ�н������ö�
	private static void setTop(ArrayList lineUpList){
		System.out.println("������Ҫ�ö��ĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();
		int position = lineUpList.indexOf(musicName);
		if(position < 0){
			System.out.println("��ǰ�б���û������ĸ�����");
		} else{
			lineUpList.remove(musicName);
			lineUpList.add(0,musicName);
		}
		System.out.println("�ѽ�����"+ musicName +"�ö�");
		System.out.println("�ö���ĸ����б�"+lineUpList);
	}
	
	//ִ�н�������ǰһλ
	private static void setBefore(ArrayList lineUpList){
		System.out.println("������Ҫ��ǰ�ĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();
		int position = lineUpList.indexOf(musicName);
		if(position < 0){
			System.out.println("��ǰ�б���û������ĸ�����");
		} else if(position == 0){
			System.out.println("��ǰ�������������");
		} else{
			lineUpList.remove(musicName);
			lineUpList.add(position-1,musicName);
		}
		System.out.println("�ѽ�����"+ musicName +"��ǰһλ");
		System.out.println("��ǰһλ������б�"+lineUpList);
	}
	
	//�˳�
	private static void exit(){
		System.out.println("-----------�˳�--------");
		System.out.println("�����˳�ϵͳ��");
		System.exit(0);
	}
}

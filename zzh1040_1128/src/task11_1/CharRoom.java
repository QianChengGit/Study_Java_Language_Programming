package task11_1;

import java.util.Scanner;

public class CharRoom {
	public static void main(String[] args) {
		System.out.println("��ӭ���������ң�");
		Scanner sc = new Scanner(System.in);
		System.out.println("�����뱾�����Ͷ˶˿ںţ�");
		int sentPort = sc.nextInt();
		System.out.println("�����뱾������ն˶˿ںţ�");
		int receivePoet = sc.nextInt();
		System.out.println("����ϵͳ��������");
		new Thread(new SendTask(sentPort),"���Ͷ�����").start();
		new Thread(new ReceiveTask(receivePoet),"���ն�����").start();
	}
}

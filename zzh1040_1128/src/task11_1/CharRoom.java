package task11_1;

import java.util.Scanner;

public class CharRoom {
	public static void main(String[] args) {
		System.out.println("欢迎进入聊天室！");
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入本程序发送端端口号：");
		int sentPort = sc.nextInt();
		System.out.println("请输入本程序接收端端口号：");
		int receivePoet = sc.nextInt();
		System.out.println("聊天系统启动！！");
		new Thread(new SendTask(sentPort),"发送端任务").start();
		new Thread(new ReceiveTask(receivePoet),"接收端任务").start();
	}
}

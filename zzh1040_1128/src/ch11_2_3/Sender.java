package ch11_2_3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Sender {
	public static void main(String[] args) throws Exception {
		//����һ��DatagramSocket����
		DatagramSocket ds = new DatagramSocket(3000);
		String str = "Hello world";
		byte[] arr = str.getBytes();
		DatagramPacket dp = new DatagramPacket(arr, arr.length,InetAddress.getByName("localhost"),8954);
		System.out.println("������Ϣ");
		ds.send(dp);
		ds.close();
	} 
}

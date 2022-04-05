package ch11_2_3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import sun.security.util.Length;

public class Receiver {
	public static void main(String[] args) throws Exception {
		byte[] buf = new byte[1024];
		DatagramSocket ds = new DatagramSocket(8954);
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		System.out.println("等待接收数据");
		ds.receive(dp);
		byte[] data = dp.getData();
		String ip = dp.getAddress().getHostAddress();
		int port = dp.getPort();
		String str = new String(data,0,dp.getLength())+"from"+ip+":"+port;
		System.out.println(str);
		ds.close();
	}
}

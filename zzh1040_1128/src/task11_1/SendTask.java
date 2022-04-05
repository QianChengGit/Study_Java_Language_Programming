package task11_1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class SendTask implements Runnable{
	private int sendPort;
	public SendTask(int sendPort) {
		// TODO Auto-generated constructor stub
		this.sendPort = sendPort;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			DatagramSocket ds = new DatagramSocket();
			Scanner sc = new Scanner(System.in);
			while(true){
				String data = sc.nextLine();
				byte[] buf = data.getBytes();
				DatagramPacket dp = new DatagramPacket(buf, buf.length,InetAddress.getByName("192.168.135.53"),sendPort);
				ds.send(dp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

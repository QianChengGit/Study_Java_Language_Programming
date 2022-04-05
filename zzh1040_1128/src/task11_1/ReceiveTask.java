package task11_1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveTask implements Runnable{
	private int receivePort;
	public ReceiveTask(int receivePort) {
		// TODO Auto-generated constructor stub
		this.receivePort = receivePort;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			DatagramSocket ds = new DatagramSocket(receivePort);
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			while(true){
				ds.receive(dp);
				String str = new String(dp.getData(),0,dp.getLength());
				System.out.println("收到"+dp.getAddress().getHostAddress()+"--发送的数据--"+str);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

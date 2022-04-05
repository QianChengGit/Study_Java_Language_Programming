package ch11_3;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {
		new TCPClient().connect();
	}

}
class TCPClient{
	private static final int PORT = 7788;
	public void connect() throws Exception{
		Socket client = new Socket(InetAddress.getLocalHost(),PORT);
		
		InputStream is = client.getInputStream();
		byte [] buf = new byte[1024];
		int len = is.read(buf);
		System.out.println(new String(buf,0,len));
		
		while(true){
			OutputStream os = client.getOutputStream();
			Scanner sc=new Scanner(System.in);
			System.out.println("请输入要发送的消息：");
			String st =sc.nextLine();
			if(st.equals("退出")){
				client.close();
				os.close();
				break;
			}else{
				os.write(st.getBytes());
				System.out.println("发送成功！");
			}
		}
	}
}
package ch11_3_2;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		
	}
}
class TCPServer{
	private final static int PORT = 7788;
	public void listen() throws Exception{
		ServerSocket serverSocket = new ServerSocket(PORT);
		Socket client = serverSocket.accept();
		OutputStream os = client.getOutputStream();
		System.out.println("开始与客户端交互数据！");
		
	}
}